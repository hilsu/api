package su.hil.api.exp;

import su.hil.api.tools.IRequestAPI;
import su.hil.api.tools.IResponseMessage;
import su.hil.api.tools.Misc;
import su.hil.api.tools.RequestMethod;

import java.util.UUID;

public class ExperienceAPI {
    public static class ExperienceRequest implements IRequestAPI<ExperienceResponse> {
        protected String username;
        protected UUID userId;

        public ExperienceRequest(String username) {
            this.username = username;
        }

        public ExperienceRequest(UUID userId) {
            this.userId = userId;
        }

        @Override
        public Class<ExperienceResponse> getResponseClass() {
            return ExperienceResponse.class;
        }

        @Override
        public String getUrl() {
            return userId != null ?
                    Misc.formatQueryURL("experience", "userId", userId) :
                    Misc.formatQueryURL("experience", "username", username);
        }

        @Override
        public RequestMethod getMethod() {
            return RequestMethod.GET;
        }

        @Override
        public Object getData() {
            return null;
        }
    }

    public static class ExperienceResponse implements IResponseMessage {
        protected int level;
        protected int exp;
        protected int nextLevelExp;

        public int getLevel() {
            return level;
        }

        public int getExp() {
            return exp;
        }

        public int getNextLevelExp() {
            return nextLevelExp;
        }
    }
}
