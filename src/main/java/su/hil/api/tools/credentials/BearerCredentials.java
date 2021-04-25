package su.hil.api.tools.credentials;

public class BearerCredentials extends Credentials {
    public final String token;
    protected final String authorizationHeader;

    public BearerCredentials(String token){
        this.token = token;
        this.authorizationHeader = "Bearer " + token;
    }

    @Override
    public String toAuthorizationHeader() {
        return authorizationHeader;
    }
}
