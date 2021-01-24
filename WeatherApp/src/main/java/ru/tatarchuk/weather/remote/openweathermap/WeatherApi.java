package ru.tatarchuk.weather.remote.openweathermap;

import androidx.annotation.NonNull;

import io.reactivex.rxjava3.core.Single;

/**
 * @author tatarchukilya@gmail.com
 */
public interface WeatherApi {
    /**
     * Call current weather data for one location
     *
     * @param lang  Language
     * @param units Units of measurement. standard, metric and imperial
     * @param lat   Latitude
     * @param lng   Longitude
     * @return current weather data
     */
    @NonNull
    Single<String> getCurrentWeather(String lang, String units, float lat, float lng);

    /**
     * Hourly forecast by OpenWeatherMap! Hourly forecast for 4 days,
     * with 96 timestamps and higher geographic accuracy.
     *
     * @param lang  Language
     * @param units Units of measurement. standard, metric and imperial
     * @param lat   Latitude
     * @param lng   Longitude
     * @return Hourly forecast for 4 days
     */
    @NonNull
    Single<String> getHourlyForecast(String lang, String units, float lat, float lng);

    /**
     * The One Call API provides the following weather data for any geographical coordinates:
     * <p>
     * Current weather
     * Minute forecast for 1 hour
     * Hourly forecast for 48 hours
     * Daily forecast for 7 days
     * National weather alerts
     * Historical weather data for the previous 5 days
     *
     * @param lang  Language
     * @param units Units of measurement. standard, metric and imperial
     * @param lat   Latitude
     * @param lng   Longitude
     * @return weather data
     */
    @NonNull
    Single<String> oneCall(String lang, String units, float lat, float lng);

    /**
     * Daily Forecast
     */
    @NonNull
    Single<String> getDaily(String lang, String units, float lat, float lng);
}
