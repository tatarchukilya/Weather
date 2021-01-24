package ru.tatarchuk.weather.di.module.viewmodel;

import dagger.Module;
import dagger.Provides;
import ru.tatarchuk.weather.remote.openweathermap.WeatherApi;
import ru.tatarchuk.weather.viewmodel.base.ViewModelProviderFactory;
import ru.tatarchuk.weather.viewmodel.WeatherViewModel;

/**
 * @author tatarchukilya@gmail.com
 */
@Module
public class ViewModelModule {

    @Provides
    ViewModelProviderFactory<WeatherViewModel> WeatherViewModelProviderFactory(WeatherApi api) {
        return new ViewModelProviderFactory<>(() -> new WeatherViewModel(api));
    }
}
