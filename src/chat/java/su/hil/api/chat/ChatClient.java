package su.hil.api.chat;

import com.google.gson.Gson;
import su.hil.api.chat.objects.exceptions.ConnectFailException;
import su.hil.api.chat.tools.ClientRequest;
import su.hil.api.chat.tools.MessageHandler;
import su.hil.api.chat.tools.ServerMessage;
import su.hil.api.chat.tools.SocketClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ChatClient  {
    protected MessageHandler handler;
    protected SocketClient socketClient;
    protected ScheduledThreadPoolExecutor executor;

    public static final Gson GSON = new Gson();

    public ChatClient(String chatID, String accessToken) throws URISyntaxException {
        this.socketClient = new SocketClient(new URI(
                "wss://api.hil.su/v2/chat/" + chatID + "/socket" + (accessToken != null ? "?accessToken=" + accessToken : "")
        ), this);

        this.socketClient.connect();

        executor = new ScheduledThreadPoolExecutor(1);

        executor.scheduleAtFixedRate(() -> {
            if (!checkConnect()) {
                try {
                    reconnect();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 5000, 5000, TimeUnit.MILLISECONDS);
    }

    public ChatClient(String chatID) throws URISyntaxException {
        this(chatID, null);
    }

    public void sendMessage(ClientRequest message) throws ConnectFailException {
        if (!checkConnect()) {
            try {
                reconnect();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new ConnectFailException();
            }
        }

        socketClient.send(GSON.toJson(message));
    }

    public boolean checkConnect(){
        return socketClient.isOpen();
    }

    public void reconnectAsync(){
        if (!socketClient.isOpen())
            socketClient.reconnect();
    }

    public void closeConnect(){
        executor.shutdown();

        if (checkConnect())
            socketClient.close();
    }

    public void reconnect() throws InterruptedException {
        socketClient.reconnectBlocking();
    }

    public void onMessage(String message) {
        ServerMessage serverMessage = new ServerMessage(message);

        if (serverMessage.getType().equals("keepAlive")){
            try {
                sendMessage(new ChatAPI.KeepAliveRequest());
            } catch (ConnectFailException e) {
                e.printStackTrace();
            }
        }else {
            if (handler != null)
                handler.newMessage(serverMessage);
        }
    }

    public MessageHandler getHandler() {
        return handler;
    }

    public void setHandler(MessageHandler handler) {
        this.handler = handler;
    }
}
