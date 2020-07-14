package su.hil.api.economy.objects;

import com.google.gson.annotations.SerializedName;

public enum Currency {
    @SerializedName("coins")
    COINS,
    @SerializedName("gems")
    GEMS;


    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
