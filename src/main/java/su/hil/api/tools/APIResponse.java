package su.hil.api.tools;

import com.google.gson.JsonElement;

public class APIResponse {
    protected boolean success;
    protected String status;
    protected String[] statuses;
    protected JsonElement response;

    public boolean isSuccess() {
        return success;
    }

    public String getStatus() {
        return status;
    }

    public String[] getStatuses() {
        return statuses;
    }

    public <T> T getResponse(Class<T> responseClass) {
        return Misc.GSON.fromJson(response, responseClass);
    }

    @Override
    public String toString() {
        return "success: " + success + ", status: " + status + ", response: " + (response != null ? response.toString() : "null");
    }
}
