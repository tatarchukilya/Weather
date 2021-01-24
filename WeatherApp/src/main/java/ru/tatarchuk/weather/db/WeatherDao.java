package ru.tatarchuk.weather.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import io.reactivex.rxjava3.core.Flowable;

/**
 * @author tatarchukilya@gmail.com
 */
@Dao
public abstract class WeatherDao {

    @Insert
    abstract void insert(WeatherEntity entity);

    @Query("SELECT * FROM WeatherEntity")
    abstract Flowable<WeatherEntity> getWeather();
}
