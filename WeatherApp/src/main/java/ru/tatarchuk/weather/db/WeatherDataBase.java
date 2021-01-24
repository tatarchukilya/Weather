package ru.tatarchuk.weather.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * @author tatarchukilya@gmail.com
 */
@Database(entities = {WeatherEntity.class}, version = 1)
public abstract class WeatherDataBase extends RoomDatabase {

    public abstract WeatherDao getWeatherDao();
}
