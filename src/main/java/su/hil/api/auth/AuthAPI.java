package su.hil.api.auth;

import su.hil.api.tools.IRequestAPI;
import su.hil.api.tools.IResponseMessage;
import su.hil.api.tools.RequestMethod;

import java.math.BigDecimal;

public class AuthAPI {
    public static class AuthRequest implements IRequestAPI<AuthResponse> {
        protected String username;
        protected String password;

        public AuthRequest(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public Class<AuthResponse> getResponseClass() {
            return AuthResponse.class;
        }

        @Override
        public String getUrl() {
            return "auth/account/login/password";
        }

        @Override
        public RequestMethod getMethod() {
            return RequestMethod.POST;
        }

        @Override
        public Object getData() {
            return this;
        }
    }

    public static class AuthResponse implements IResponseMessage {
        protected String accessToken;
        protected BigDecimal expires;

        public String getAccessToken() {
            return accessToken;
        }

        public BigDecimal getExpires() {
            return expires;
        }
    }
}
