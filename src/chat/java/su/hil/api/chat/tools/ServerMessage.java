package su.hil.api.chat.tools;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import static su.hil.api.chat.ChatClient.GSON;

public class ServerMessage {
    protected String type;
    protected Object data;

    public ServerMessage() {

    }

    public ServerMessage(String rawMessage) {
        JsonObject element = GSON.fromJson(rawMessage, JsonObject.class);

        this.type = element.get("type").getAsString();
        element.remove("type");

        this.data = GSON.fromJson(element, DataTypesMap.types.getOrDefault(type, Object.class));
    }

    public String getType() {
        return type;
    }

    public Object getData() {
        return data;
    }
}
