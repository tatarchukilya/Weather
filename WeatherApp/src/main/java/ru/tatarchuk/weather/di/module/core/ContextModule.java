package ru.tatarchuk.weather.di.module.core;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * @author tatarchukilya@gmail.com
 */
@Module
public class ContextModule {

    private final Application application;

    public ContextModule(Application application) {
        this.application = application;
    }

    @Provides
    Context getContext() {
        return application.getApplicationContext();
    }

//    @Provides
//    public ViewModelProviderFactory<WeatherViewModel> provideWeatherViewModelFactory(Context context) {
//        return new ViewModelProviderFactory<>(() -> new WeatherViewModel(context),
//                weatherViewModel -> weatherViewModel.getCurrent(48.302697f, 39.925032f));
//    }
}
