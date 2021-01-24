package ru.tatarchuk.weather.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import ru.tatarchuk.weather.di.module.core.ContextModule;
import ru.tatarchuk.weather.di.module.core.OkHttpModule;
import ru.tatarchuk.weather.di.module.remote.WeatherRemoteModule;
import ru.tatarchuk.weather.di.module.viewmodel.ViewModelModule;
import ru.tatarchuk.weather.viewmodel.base.ViewModelProviderFactory;
import ru.tatarchuk.weather.viewmodel.WeatherViewModel;

/**
 * @author tatarchukilya@gmail.com
 */
@Singleton
@Component(modules = {
        ContextModule.class,
        OkHttpModule.class,
        WeatherRemoteModule.class,
        ViewModelModule.class})
public interface AppComponent {

    ViewModelProviderFactory<WeatherViewModel> getWeatherViewModelFactory();

    Context getContext();
}
