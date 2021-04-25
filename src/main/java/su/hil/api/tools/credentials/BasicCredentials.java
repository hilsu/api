package su.hil.api.tools.credentials;

import java.util.Base64;

public class BasicCredentials extends Credentials{
    public final String username;
    public final String password;
    protected final String authorizationHeader;

    public BasicCredentials(String username, String password) {
        this.username = username;
        this.password = password;
        this.authorizationHeader = "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
    }

    @Override
    public String toAuthorizationHeader() {
        return authorizationHeader;
    }
}
