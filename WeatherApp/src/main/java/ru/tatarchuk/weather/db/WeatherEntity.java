package ru.tatarchuk.weather.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author tatarchukilya@gmail.com
 */
@Entity
public class WeatherEntity {

    @PrimaryKey(autoGenerate = true)
    long id;

    String firstName;

    String secondName;

    float lat;

    float lng;

    int timeZone;

    String weather_data;
}
