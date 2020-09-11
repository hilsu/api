package su.hil.api.tools;

public class HilAPIException extends Exception {

    protected APIResponse response;

    public HilAPIException(APIResponse response) {
        this("Unknown API error", response);
    }

    public HilAPIException(String message, APIResponse response) {
        super(message + ": '" + response.toString() + "'");
        this.response = response;
    }

    public APIResponse getResponse() {
        return response;
    }
}
