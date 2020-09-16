package su.hil.api.chat.tools;

import su.hil.api.chat.objects.historyresponse.HistoryResponseData;
import su.hil.api.chat.objects.messageacknowledged.MessageAcknowledgedData;
import su.hil.api.chat.objects.messagereceived.MessageReceivedData;
import su.hil.api.chat.objects.permissionsupdate.PermissionsUpdateData;

import java.util.HashMap;

public class DataTypesMap {
    public final static HashMap<String, Class<? extends Object>> types;

    static {
        types = new HashMap<>();

        types.put("messageReceived", MessageReceivedData.class);
        types.put("permissionsUpdate", PermissionsUpdateData.class);
        types.put("messageAcknowledged", MessageAcknowledgedData.class);
        types.put("historyResponse", HistoryResponseData.class);
    }
}
