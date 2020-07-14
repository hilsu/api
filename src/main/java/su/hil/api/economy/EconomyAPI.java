package su.hil.api.economy;

import su.hil.api.tools.IRequestAPI;
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
        @Override
        public Class<BalanceResponse> getResponseClass() {
            return BalanceResponse.class;
        }

        @Override
        public String getUrl() {
            return "economy/balance";
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

    public static class BalanceResponse {
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

        public TransactionRequest(Currency currency, String targetName, BigDecimal amount, String description) {
            this.currency = currency;
            this.targetName = targetName;
            this.amount = amount;
            this.description = description;
        }

        public TransactionRequest(String targetName, BigDecimal amount) {
            this(Currency.COINS, targetName, amount, null);
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

    public static class TransactionResponse {
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
            return Misc.formatQueryURL("economy/changes", "currency", currency, "limit", limit, "offset", offset);
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

    public static class ChangesResponse {
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
            return Misc.formatQueryURL("economy/transfers", "limit", limit, "offset", offset);
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

    public static class TransfersResponse {
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

}
