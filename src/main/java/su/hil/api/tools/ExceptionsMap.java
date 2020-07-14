package su.hil.api.tools;

import su.hil.api.economy.exceptions.InsufficientFundsAPIException;
import su.hil.api.economy.exceptions.InvalidAmountAPIException;
import su.hil.api.economy.exceptions.InvalidUserAPIException;
import su.hil.api.economy.exceptions.UserNotFoundAPIException;

import java.util.HashMap;

public class ExceptionsMap {
    public final static HashMap<String, Class<? extends HilAPIException>> exceptions;

    static {
        exceptions = new HashMap<>();
        exceptions.put("economy.userNotFound", UserNotFoundAPIException.class);
        exceptions.put("economy.invalidUser", InvalidUserAPIException.class);
        exceptions.put("economy.invalidAmount", InvalidAmountAPIException.class);
        exceptions.put("economy.insufficientFunds", InsufficientFundsAPIException.class);
    }

}
