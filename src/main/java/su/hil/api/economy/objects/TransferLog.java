package su.hil.api.economy.objects;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class TransferLog {
    protected int id;
    protected UUID peerId;
    protected String peerName;
    protected BigDecimal delta;
    protected String comment;
    protected Instant time;

    public int getId() {
        return id;
    }

    public UUID getPeerId() {
        return peerId;
    }

    public String getPeerName() {
        return peerName;
    }

    public BigDecimal getDelta() {
        return delta;
    }

    public String getComment() {
        return comment;
    }

    public Instant getTime() {
        return time;
    }
}
