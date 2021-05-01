package su.hil.api.economy.objects;

import java.util.UUID;

public class User {
    protected int id;
    protected UUID uuid;
    protected String username;

    public int getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }
}
