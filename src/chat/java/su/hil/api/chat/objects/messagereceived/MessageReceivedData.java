package su.hil.api.chat.objects.messagereceived;

public class MessageReceivedData {
    protected Message message;
    protected boolean isEdited;

    public Message getMessage() {
        return message;
    }

    public boolean isEdited() {
        return isEdited;
    }
}
