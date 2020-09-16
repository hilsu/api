package su.hil.api.chat.objects.permissionsupdate;

import su.hil.api.chat.objects.User;

public class Mute {
    protected User[] muters;
    protected double expiresAt;

    public User[] getMuters() {
        return muters;
    }

    public double getExpiresAt() {
        return expiresAt;
    }
}
