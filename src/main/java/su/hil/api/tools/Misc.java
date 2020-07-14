package su.hil.api.tools;

import com.google.gson.*;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Misc {
    public static final Gson GSON;

    static {
        GsonBuilder builder = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(Instant.class, new InstantAdapter());

        GSON = builder.create();
    }

    public static String formatQueryURL(String base, Object... args) {
        if (args.length == 0) return base;
        if (args.length % 2 != 0) throw new IllegalArgumentException("The number of arguments is odd!");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(base).append("?");

        try {
            for (int i = 0; i < args.length / 2; i++) {
                if (i > 0) stringBuilder.append("&");
                stringBuilder
                        .append(args[i * 2])
                        .append("=")
                        .append(URLEncoder.encode(args[i * 2 + 1].toString(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        return stringBuilder.toString();
    }

    static class LocalDateAdapter implements JsonDeserializer<LocalDate>, JsonSerializer<LocalDate> {
        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return LocalDate.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE);
        }

        @Override
        public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.toString());
        }
    }

    static class InstantAdapter implements JsonDeserializer<Instant>, JsonSerializer<Instant> {
        @Override
        public Instant deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Instant.ofEpochMilli(json.getAsBigDecimal().multiply(new BigDecimal("1000")).longValue());
        }

        @Override
        public JsonElement serialize(Instant src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.toString());
        }
    }

}
