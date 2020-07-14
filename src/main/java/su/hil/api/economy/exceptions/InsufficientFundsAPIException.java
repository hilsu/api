package su.hil.api.economy.exceptions;

import su.hil.api.tools.APIResponse;
import su.hil.api.tools.HilAPIException;

public class InsufficientFundsAPIException extends HilAPIException {
    public InsufficientFundsAPIException(APIResponse response) {
        super("Insufficient funds error", response);
    }
}
