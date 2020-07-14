package su.hil.api.economy.exceptions;

import su.hil.api.tools.APIResponse;
import su.hil.api.tools.HilAPIException;

public class InvalidUserAPIException extends HilAPIException {
    public InvalidUserAPIException(APIResponse response) {
        super("Invalid user error", response);
    }
}
