package ru.tatarchuk.weather.remote.openweathermap;

import androidx.annotation.NonNull;

import io.reactivex.rxjava3.core.Single;

/**
 * @author tatarchukilya@gmail.com
 */
public final class WeatherApiImpl implements WeatherApi {

    private static final String KEY = "3bdd540451c1109d4899c0d734de69d9";

    private final WeatherRetrofitApi api;

    /**
     * @param api Retrofit ProxyInstance
     */
    public WeatherApiImpl(@NonNull WeatherRetrofitApi api) {
        this.api = api;
    }

    @NonNull
    @Override
    public Single<String> getCurrentWeather(String lang, String units, float lat, float lng) {
        return api.getWeather(KEY, lang, units, lat, lng);
    }

    @NonNull
    @Override
    public Single<String> getHourlyForecast(String lang, String units, float lat, float lng) {
        return api.getHourlyForecast(KEY, lang, units, lat, lng);
    }

    @NonNull
    @Override
    public Single<String> oneCall(String lang, String units, float lat, float lng) {
        return api.oneCall(KEY, lang, units, lat, lng);
    }

    @NonNull
    @Override
    public Single<String> getDaily(String lang, String units, float lat, float lng) {
        return api.getDaily(KEY, lang, units, lat, lng);
    }
}
