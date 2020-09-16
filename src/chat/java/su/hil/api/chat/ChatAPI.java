package su.hil.api.chat;

import su.hil.api.chat.tools.ClientRequest;
import su.hil.api.chat.tools.ServerMessage;

public class ChatAPI {
    public static class KeepAliveRequest extends ClientRequest {
        public KeepAliveRequest() {
            this.type = "keepAlive";
        }
    }

    public static class SendRequestRequest extends ClientRequest {
        protected String text;
        protected Long replyTo;
        protected String acknowledgement;

        public SendRequestRequest(String text, Long replyTo, String acknowledgement) {
            this.type = "sendMessage";
            this.text = text;
            this.replyTo = replyTo;
            this.acknowledgement = acknowledgement;
        }

        public SendRequestRequest(String text, Long replyTo) {
            this(text, replyTo, null);
        }

        public SendRequestRequest(String text, String acknowledgement) {
            this(text, null, acknowledgement);
        }

        public SendRequestRequest(String text) {
            this(text, null, null);
        }
    }

    public static class HistoryRequest extends ClientRequest {
        protected long lastMessageId;
        protected int count;

        public HistoryRequest(long lastMessageId, int count) {
            this.type = "requestHistory";
            this.lastMessageId = lastMessageId;
            this.count = count;
        }
    }

    public static class DeleteMessageRequest extends ClientRequest {
        protected long[] ids;

        public DeleteMessageRequest(long[] ids) {
            this.type = "deleteMessages";
            this.ids = ids;
        }
    }
}
