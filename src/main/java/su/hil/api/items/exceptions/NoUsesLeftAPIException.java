package su.hil.api.items.exceptions;

import su.hil.api.tools.APIResponse;
import su.hil.api.tools.HilAPIException;

public class NoUsesLeftAPIException extends HilAPIException {
    public NoUsesLeftAPIException(APIResponse response) {
        super(response);
    }
}
