package su.hil.api.chat.objects.messageacknowledged;

import su.hil.api.chat.objects.User;

public class AcknowledgedResult {
    protected String type;
    protected long id;
    protected User muter;
    protected double expiresAt;

    public String getType() {
        return type;
    }

    public long getId() {
        return id;
    }

    public User getMuter() {
        return muter;
    }

    public double getExpiresAt() {
        return expiresAt;
    }
}
