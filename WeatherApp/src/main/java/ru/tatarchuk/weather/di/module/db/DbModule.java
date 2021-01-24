package ru.tatarchuk.weather.di.module.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.tatarchuk.weather.db.WeatherDao;
import ru.tatarchuk.weather.db.WeatherDataBase;

/**
 * @author tatarchukilya@gmail.com
 */
@Module
public class DbModule {

    @Provides
    @Singleton
    static WeatherDataBase provideWeatherDataBase(@NonNull Context context) {
        return Room.databaseBuilder(context, WeatherDataBase.class, "weather_db").build();
    }

    @Provides
    @Singleton
    static WeatherDao provideWeatherDao(@NonNull WeatherDataBase dataBase) {
        return dataBase.getWeatherDao();
    }
}
