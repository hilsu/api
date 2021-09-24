package su.hil.api.items.objects;

public class Item {
    protected String id;
    protected String display;
    protected double expiresAt;

    public String getId() {
        return id;
    }

    public String getDisplay() {
        return display;
    }

    public double getExpiresAt() {
        return expiresAt;
    }
}
