package su.hil.api.tools.credentials;

public abstract class Credentials {
    public static Credentials bearer(String token) {
        return new BearerCredentials(token);
    }

    public static Credentials basic(String username, String password) {
        return new BasicCredentials(username, password);
    }

    public abstract String toAuthorizationHeader();
}
