package su.hil.api.tools;

public class HilAPIException extends Exception {

    public HilAPIException(APIResponse response) {
        this("Unknown API error", response);
    }

    public HilAPIException(String message, APIResponse response) {
        super(message + ": '" + response.toString() + "'");
    }

}
