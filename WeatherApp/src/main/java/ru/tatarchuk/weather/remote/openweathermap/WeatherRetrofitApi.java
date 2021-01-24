package ru.tatarchuk.weather.remote.openweathermap;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author tatarchukilya@gmail.com
 */
public interface WeatherRetrofitApi {

    /**
     * Call current weather data for one location
     *
     * @param key   appid
     * @param lang  Language
     * @param units Units of measurement. standard, metric and imperial
     * @param lat   Latitude
     * @param lng   Longitude
     * @return current weather data
     */

    @GET("weather?")
    Single<String> getWeather(@Query("appid") String key,
                              @Query("lang") String lang,
                              @Query("units") String units,
                              @Query("lat") float lat,
                              @Query("lon") float lng);

    @GET("forecast/hourly?")
    Single<String> getHourlyForecast(@Query("appid") String key,
                                     @Query("lang") String lang,
                                     @Query("units") String units,
                                     @Query("lat") float lat,
                                     @Query("lon") float lng);

    @GET("onecall?")
    Single<String> oneCall(@Query("appid") String key,
                           @Query("lang") String lang,
                           @Query("units") String units,
                           @Query("lat") float lat,
                           @Query("lon") float lng);

    @GET("onecall?")
    Single<String> getDaily(@Query("appid") String key,
                            @Query("lang") String lang,
                            @Query("units") String units,
                            @Query("lat") float lat,
                            @Query("lon") float lng);
}
