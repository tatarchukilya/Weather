package ru.tatarchuk.weather.model.remote;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author tatarchukilya@gmail.com
 */
public class Clouds {

    @SerializedName("all")
    @Expose
    private Integer all;

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    @NonNull
    @Override
    public String toString() {
        return "Clouds{" +
                "all=" + all +
                '}';
    }
}
