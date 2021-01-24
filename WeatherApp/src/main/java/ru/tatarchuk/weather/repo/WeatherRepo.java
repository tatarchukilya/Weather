package ru.tatarchuk.weather.repo;

import ru.tatarchuk.weather.db.WeatherDataBase;
import ru.tatarchuk.weather.remote.openweathermap.WeatherApi;

/**
 * @author tatarchukilya@gmail.com
 */
public class WeatherRepo {

    private final WeatherApi weatherApi;

    private final WeatherDataBase dataBase;

    public WeatherRepo(WeatherApi weatherApi, WeatherDataBase dataBase) {
        this.weatherApi = weatherApi;
        this.dataBase = dataBase;
    }

//    public void loadWeather(float lat, float lng) {
//        weatherApi.getCurrentWeather("ru", "metric", lat, lng)
//                .subscribeOn(Schedulers.io())
////                .subscribe(s -> {
////                    dataBase
////                });
//    }
}
