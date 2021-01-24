package ru.tatarchuk.remotelib.openweathermap;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author tatarchukilya@gmail.com
 */
public final class WeatherApiImpl implements WeatherApi {

    private static final String KEY = "3bdd540451c1109d4899c0d734de69d9";

    private static final Api api = new WeatherRestClient().createService(Api.class);

    @Override
    public Single<String> getWeather(String lang, String units, float lat, float lng) {
        return api.getWeather(KEY, lang, units, lat, lng);
    }

    private interface Api {
        @GET("weather?")
        Single<String> getWeather(@Query("appid") String key,
                                  @Query("lang") String lang,
                                  @Query("units") String units,
                                  @Query("lat") float lat,
                                  @Query("lon") float lng);
    }
}
