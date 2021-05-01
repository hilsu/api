package su.hil.api.economy.objects;

import java.math.BigDecimal;

public class TopEntry {
    protected int num;
    protected BigDecimal balance;
    protected User user;

    public int getNum() {
        return num;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }
}
