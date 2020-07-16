package su.hil.api;

import su.hil.api.tools.*;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class APIClient {
    protected ExecutorService threadPool = Executors.newFixedThreadPool(4,
            r -> {
                Thread thread = new Thread(r);
                thread.setDaemon(true);

                return thread;
            });

    protected String authorizationToken;
    protected String baseURL = "https://api.hil.su/v2/";

    public APIClient(String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }

    public APIClient() {
        this(null);
    }

    public void setAuthorizationToken(String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }

    public <R extends IResponseMessage, T extends IRequestAPI<R>> CompletableFuture<R> runRequest(T request) {
        CompletableFuture<R> future = new CompletableFuture<>();

        threadPool.submit(() -> {
            try {
                future.complete(sendRequest(request));
            } catch (Throwable t) {
                future.completeExceptionally(t);
            }
        });

        return future;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    protected <R extends IResponseMessage, T extends IRequestAPI<R>> R sendRequest(T request) throws Exception {
        Object data = request.getData();
        HttpURLConnection connection = (HttpURLConnection) new URL(baseURL + request.getUrl()).openConnection();

        if (data != null)
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");

        if (authorizationToken != null)
            connection.setRequestProperty("Authorization", "Bearer " + authorizationToken);

        connection.setDoOutput(true);
        connection.setRequestMethod(request.getMethod().name());

        if (data != null) {
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8);
            Misc.GSON.toJson(data, writer);
            writer.close();
        }

        InputStreamReader reader = new InputStreamReader(
                connection.getResponseCode() == 200 ? connection.getInputStream() : connection.getErrorStream(),
                StandardCharsets.UTF_8
        );

        APIResponse response = Misc.GSON.fromJson(reader, APIResponse.class);

        reader.close();

        if (response.isSuccess()) {
            return response.getResponse(request.getResponseClass());
        }

        String[] statuses = response.getStatuses();

        for (int i = statuses.length - 1; i >= 0; i--) {
            if (ExceptionsMap.exceptions.containsKey(statuses[i]))
                throw (HilAPIException) ExceptionsMap.exceptions.get(statuses[i]).getConstructors()[0].newInstance(response);
        }

        throw new HilAPIException(response);
    }
}