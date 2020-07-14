package su.hil.api.economy.exceptions;

import su.hil.api.tools.APIResponse;
import su.hil.api.tools.HilAPIException;

public class InvalidAmountAPIException extends HilAPIException {
    public InvalidAmountAPIException(APIResponse response) {
        super("Invalid amount error", response);
    }
}
