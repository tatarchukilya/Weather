package ru.tatarchuk.weather.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ru.tatarchuk.weather.remote.openweathermap.WeatherApi;

/**
 * @author tatarchukilya@gmail.com
 */
public class WeatherViewModel extends ViewModel {

    private final WeatherApi weatherApi;

    public WeatherViewModel(WeatherApi api) {
        weatherApi = api;
    }

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void getCurrent(float lat, float lng) {
        compositeDisposable.add(weatherApi.getCurrentWeather("ru", "metric", lat, lng)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(currentWeather -> Log.i("<>", currentWeather.toString()),
                        Throwable::printStackTrace));
    }

    public void getHourly(float lat, float lng) {
        compositeDisposable.add(weatherApi.getHourlyForecast("ru", "metric", lat, lng)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> Log.i("<>", s), Throwable::printStackTrace));
    }

    public void call(float lat, float lng) {
        compositeDisposable.add(weatherApi.oneCall("ru", "metric", lat, lng)
                .subscribe(s -> Log.i("<>", s), Throwable::printStackTrace));
    }

    public void getDaily(float lat, float lng) {
        compositeDisposable.add(weatherApi.getDaily("ru", "metric", lat, lng)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> Log.i("<>", s), Throwable::printStackTrace));
    }
}
