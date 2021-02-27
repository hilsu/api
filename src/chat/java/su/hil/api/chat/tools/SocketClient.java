package su.hil.api.chat.tools;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import su.hil.api.chat.ChatClient;

import javax.net.ssl.SSLContext;
import java.net.URI;
import java.security.NoSuchAlgorithmException;

public class SocketClient extends WebSocketClient {
    ChatClient chatClient;

    public SocketClient(URI serverUri, ChatClient chatClient) {
        super(serverUri);
        this.chatClient = chatClient;

        try {
            setSocketFactory(SSLContext.getDefault().getSocketFactory());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {

    }

    @Override
    public void onMessage(String message) {
        chatClient.onMessage(message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {

    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }
}
