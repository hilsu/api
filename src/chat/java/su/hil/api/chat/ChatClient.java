package su.hil.api.chat;

import com.google.gson.Gson;
import su.hil.api.chat.tools.ClientRequest;
import su.hil.api.chat.tools.MessageHandler;
import su.hil.api.chat.tools.ServerMessage;
import su.hil.api.chat.tools.SocketClient;

import java.net.URI;
import java.net.URISyntaxException;

public class ChatClient  {
    protected MessageHandler handler;
    protected SocketClient socketClient;
    public static final Gson GSON = new Gson();

    public ChatClient(String chatID, String accessToken) throws URISyntaxException {
        this.socketClient = new SocketClient(new URI(
                "wss://api.hil.su/v2/chat/" + chatID + "/socket" + (accessToken != null ? "?accessToken=" + accessToken : "")
        ), this);

        this.socketClient.connect();
    }

    public ChatClient(String chatID) throws URISyntaxException {
        this(chatID, null);
    }

    public void sendMessage(ClientRequest message){
        socketClient.send(GSON.toJson(message));
    }

    public void onMessage(String message) {
        ServerMessage serverMessage = new ServerMessage(message);

        if (serverMessage.getType().equals("keepAlive")){
            sendMessage(new ChatAPI.KeepAliveRequest());
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
