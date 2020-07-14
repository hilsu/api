package su.hil.api.economy.exceptions;

import su.hil.api.tools.APIResponse;
import su.hil.api.tools.HilAPIException;

public class UserNotFoundAPIException extends HilAPIException {
    public UserNotFoundAPIException(APIResponse response) {
        super("User not found error", response);
    }
}
