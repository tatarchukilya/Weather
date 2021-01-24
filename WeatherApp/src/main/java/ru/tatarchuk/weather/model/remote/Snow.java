package ru.tatarchuk.weather.model.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author tatarchukilya@gmail.com
 */
public class Snow {

    @SerializedName("1h")
    @Expose
    private Float _1h;

    public Float get1h() {
        return _1h;
    }

    public void set1h(Float _1h) {
        this._1h = _1h;
    }

}
