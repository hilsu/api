package su.hil.api.chat.objects.historyresponse;

import su.hil.api.chat.objects.messagereceived.Message;

public class HistoryResponseData {
    protected Message[] history;

    public Message[] getHistory() {
        return history;
    }
}
