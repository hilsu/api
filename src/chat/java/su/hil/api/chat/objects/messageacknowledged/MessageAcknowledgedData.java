package su.hil.api.chat.objects.messageacknowledged;

public class MessageAcknowledgedData {
    protected String acknowledgement;
    protected AcknowledgedResult result;

    public String getAcknowledgement() {
        return acknowledgement;
    }

    public AcknowledgedResult getResult() {
        return result;
    }
}
