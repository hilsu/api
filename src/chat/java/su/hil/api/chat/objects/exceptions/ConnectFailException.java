package su.hil.api.chat.objects.exceptions;

public class ConnectFailException extends Exception {
    public ConnectFailException(){
        super("Cannot connect to API server!");
    }
}
