package ru.tatarchuk.weather;

import android.app.Application;

import ru.tatarchuk.weather.di.component.AppComponent;
import ru.tatarchuk.weather.di.component.DaggerAppComponent;
import ru.tatarchuk.weather.di.module.core.ContextModule;

/**
 * @author tatarchukilya@gmail.com
 */
public class WeatherApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
