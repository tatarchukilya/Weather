package ru.tatarchuk.remotelib.openweathermap;

import ru.tatarchuk.remotelib.core.RestClient;

/**
 * @author tatarchukilya@gmail.com
 */
public class WeatherRestClient extends RestClient {

    @Override
    protected String getBaseUrl() {
        return "http://api.openweathermap.org/data/2.5/";
    }
}
