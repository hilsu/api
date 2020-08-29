package su.hil.api.economy;

import su.hil.api.tools.IRequestAPI;
import su.hil.api.tools.IResponseMessage;
import su.hil.api.tools.Misc;
import su.hil.api.economy.objects.ChangeLog;
import su.hil.api.economy.objects.Currency;
import su.hil.api.economy.objects.TransferLog;
import su.hil.api.tools.RequestMethod;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

public class EconomyAPI {
    public static class BalanceRequest implements IRequestAPI<BalanceResponse> {
        protected UUID userId;
        protected String username;

        public void setUser(UUID userId) {
            this.userId = userId;
            username = null;
        }

        public void setUser(String username){
            this.username = username;
            userId = null;
        }

        @Override
        public Class<BalanceResponse> getResponseClass() {
            return BalanceResponse.class;
        }

        @Override
        public String getUrl() {
            if (userId == null && username == null)
                return "economy/balance";

            return userId != null ?
                    Misc.formatQueryURL("economy/balance", "userId", userId) :
                    Misc.formatQueryURL("economy/balance", "username", username);
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

    public static class BalanceResponse implements IResponseMessage {
        protected UUID userId;
        protected String username;
        protected Map<Currency, BigDecimal> balances;

        public UUID getUserId() {
            return userId;
        }

        public String getUsername() {
            return username;
        }

        public Map<Currency, BigDecimal> getBalances() {
            return balances;
        }
    }

    public static class TransactionRequest implements IRequestAPI<TransactionResponse> {
        protected Currency currency;
        protected String targetName;
        protected BigDecimal amount;
        protected String description;
        protected UUID senderId;
        protected String senderName;

        public TransactionRequest(Currency currency, String targetName, BigDecimal amount, String description) {
            this.currency = currency;
            this.targetName = targetName;
            this.amount = amount;
            this.description = description;
        }

        public TransactionRequest(String targetName, BigDecimal amount) {
            this(Currency.COINS, targetName, amount, null);
        }

        public void setSenderUser(UUID userId) {
            this.senderId = userId;
            senderName = null;
        }

        public void setSenderUser(String username){
            this.senderName = username;
            senderId = null;
        }

        @Override
        public Class<TransactionResponse> getResponseClass() {
            return TransactionResponse.class;
        }

        @Override
        public String getUrl() {
            return "economy/transfer";
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

    public static class TransactionResponse implements IResponseMessage {
        protected String currency;
        protected UUID senderId;
        protected String senderName;
        protected UUID targetId;
        protected String targetName;
        protected String balance;

        public String getCurrency() {
            return currency;
        }

        public UUID getSenderId() {
            return senderId;
        }

        public String getSenderName() {
            return senderName;
        }

        public UUID getTargetId() {
            return targetId;
        }

        public String getTargetName() {
            return targetName;
        }

        public String getBalance() {
            return balance;
        }
    }

    public static class ChangesRequest implements IRequestAPI<ChangesResponse> {
        protected Currency currency;
        protected int limit;
        protected int offset;

        public ChangesRequest(Currency currency, int limit, int offset) {
            this.currency = currency;
            this.limit = limit;
            this.offset = offset;
        }

        @Override
        public Class<ChangesResponse> getResponseClass() {
            return ChangesResponse.class;
        }

        @Override
        public String getUrl() {
            return Misc.formatQueryURL("economy/changes", "currency", currency, "limit", limit, "offset", offset, "currency", currency);
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

    public static class ChangesResponse implements IResponseMessage {
        protected UUID userId;
        protected String username;
        protected ChangeLog[] changes;

        public UUID getUserId() {
            return userId;
        }

        public String getUsername() {
            return username;
        }

        public ChangeLog[] getChanges() {
            return changes;
        }
    }

    public static class TransfersRequest implements IRequestAPI<TransfersResponse> {
        protected Currency currency;
        protected int limit;
        protected int offset;

        public TransfersRequest(Currency currency, int limit, int offset) {
            this.currency = currency;
            this.limit = limit;
            this.offset = offset;
        }

        @Override
        public Class<TransfersResponse> getResponseClass() {
            return TransfersResponse.class;
        }

        @Override
        public String getUrl() {
            return Misc.formatQueryURL("economy/transfers", "limit", limit, "offset", offset, "currency", currency);
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

    public static class TransfersResponse implements IResponseMessage {
        UUID userId;
        String username;
        TransferLog[] transfers;

        public UUID getUserId() {
            return userId;
        }

        public String getUsername() {
            return username;
        }

        public TransferLog[] getTransfers() {
            return transfers;
        }
    }

    public static class TransfersCountRequest implements IRequestAPI<TransfersCountResponse> {
        protected Currency currency;

        public TransfersCountRequest(Currency currency) {
            this.currency = currency;
        }

        @Override
        public Class<TransfersCountResponse> getResponseClass() {
            return TransfersCountResponse.class;
        }

        @Override
        public String getUrl() {
            return Misc.formatQueryURL("economy/transfersCount", "currency", currency);
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

    public static class TransfersCountResponse implements IResponseMessage {
        long count;

        public long getCount() {
            return count;
        }
    }

    public static class ChangesCountRequest implements IRequestAPI<ChangesCountResponse> {
        protected Currency currency;

        public ChangesCountRequest(Currency currency) {
            this.currency = currency;
        }

        @Override
        public Class<ChangesCountResponse> getResponseClass() {
            return ChangesCountResponse.class;
        }

        @Override
        public String getUrl() {
            return Misc.formatQueryURL("economy/changesCount", "currency", currency);
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

    public static class ChangesCountResponse implements IResponseMessage {
        long count;

        public long getCount() {
            return count;
        }
    }

    public static class ChangeRequest implements IRequestAPI<ChangeResponse> {
        protected Currency currency;
        protected BigDecimal amount;
        protected UUID targetId;
        protected String targetName;

        public ChangeRequest(Currency currency, BigDecimal amount, UUID targetId) {
            this.currency = currency;
            this.amount = amount;
            this.targetId = targetId;
        }

        public ChangeRequest(Currency currency, BigDecimal amount, String targetName) {
            this.currency = currency;
            this.amount = amount;
            this.targetName = targetName;
        }

        @Override
        public Class<ChangeResponse> getResponseClass() {
            return ChangeResponse.class;
        }

        @Override
        public String getUrl() {
            return "economy/change";
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

    public static class ChangeResponse implements IResponseMessage {
        BigDecimal balance;

        public BigDecimal getBalance() {
            return balance;
        }
    }

}
