package su.hil.api.items;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import lombok.Builder;
import lombok.NonNull;
import su.hil.api.items.objects.Item;
import su.hil.api.items.objects.Series;
import su.hil.api.tools.IRequestAPI;
import su.hil.api.tools.IResponseMessage;
import su.hil.api.tools.Misc;
import su.hil.api.tools.RequestMethod;

import java.beans.Transient;
import java.time.Instant;
import java.util.HashMap;
import java.util.UUID;

public class RegisteredItemsAPI {
    public static class ItemViewRequest implements IRequestAPI<ItemResponse> {
        protected String id;

        public ItemViewRequest(String id) {
            this.id = id;
        }

        @Override
        public Class<ItemResponse> getResponseClass() {
            return ItemResponse.class;
        }

        @Override
        public String getUrl() {
            return Misc.formatQueryURL("registeredItems/" + id);
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

    public static class ItemUseRequest implements IRequestAPI<ItemResponse> {
        protected transient String id;
        protected Object metadata;

        public ItemUseRequest(String id, Object metadata) {
            this.id = id;
            this.metadata = metadata;
        }

        @Override
        public Class<ItemResponse> getResponseClass() {
            return ItemResponse.class;
        }

        @Override
        public String getUrl() {
            return Misc.formatQueryURL("registeredItems/" + id + "/use");
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

    public static class ItemResponse implements IResponseMessage {
        protected String id;
        protected Series series;
        protected int remainingUses;

        protected JsonPrimitive usageMetadata;
        protected JsonPrimitive itemMetadata;

        protected Instant createdAt;
        protected Instant updatedAt;
        protected Instant expiresAt;
        protected Instant usedAt;

        public String getId() {
            return id;
        }

        public Series getSeries() {
            return series;
        }

        public int getRemainingUses() {
            return remainingUses;
        }

        public JsonPrimitive getUsageMetadata() {
            return usageMetadata;
        }

        public Instant getCreatedAt() {
            return createdAt;
        }

        public Instant getUpdatedAt() {
            return updatedAt;
        }

        public Instant getExpiresAt() {
            return expiresAt;
        }

        public Instant getUsedAt() {
            return usedAt;
        }

        public JsonPrimitive getItemMetadata() {
            return itemMetadata;
        }

        @Override
        public String toString() {
            return "ItemResponse{" +
                    "id='" + id + '\'' +
                    ", series=" + series +
                    ", remainingUses=" + remainingUses +
                    ", usageMetadata=" + usageMetadata +
                    ", itemMetadata=" + itemMetadata +
                    ", createdAt=" + createdAt +
                    ", updatedAt=" + updatedAt +
                    ", expiresAt=" + expiresAt +
                    ", usedAt=" + usedAt +
                    '}';
        }
    }

    @Builder
    public static class GenerateItemRequest implements IRequestAPI<GenerateItemResponse> {
        @NonNull
        protected String series;

        @Builder.Default
        protected int itemCount = 1;

        protected Object[] itemMetadata;

        @Builder.Default
        protected int uses = 1;

        protected Instant expiresAt;

        protected GenerateItemRequest(@NonNull String series, int itemCount, Object[] itemMetadata, int uses, Instant expiresAt) {
            this.series = series;
            this.itemCount = itemCount;
            this.itemMetadata = itemMetadata;
            this.uses = uses;
            this.expiresAt = expiresAt;
        }

        @Override
        public Class<GenerateItemResponse> getResponseClass() {
            return GenerateItemResponse.class;
        }

        @Override
        public String getUrl() {
            return Misc.formatQueryURL("registeredItems/generate");
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

    public static class GenerateItemResponse implements IResponseMessage {
        protected Item[] items;

        public Item[] getItems() {
            return items;
        }
    }
}
