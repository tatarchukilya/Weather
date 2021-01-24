package ru.tatarchuk.remotelib.openweathermap;

import io.reactivex.rxjava3.core.Single;

/**
 * @author tatarchukilya@gmail.com
 */
public interface WeatherApi {

    public Single<String> getWeather(String lang, String units, float lat, float lng);
}
