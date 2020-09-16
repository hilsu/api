package su.hil.api.chat.objects.permissionsupdate;

import su.hil.api.chat.objects.permissionsupdate.Mute;

public class UserPermissions {
    protected Mute mute;
    protected String[] userActions;
    protected String[] adminActions;

    public Mute getMute() {
        return mute;
    }

    public String[] getUserActions() {
        return userActions;
    }

    public String[] getAdminActions() {
        return adminActions;
    }
}
