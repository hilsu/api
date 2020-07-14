package su.hil.api.economy.objects;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ChangeLog {
    protected LocalDate date;
    protected String source;
    protected String description;
    protected BigDecimal delta;

    public LocalDate getDate() {
        return date;
    }

    public String getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getDelta() {
        return delta;
    }
}
