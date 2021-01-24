package ru.tatarchuk.weather.di.module.remote;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import ru.tatarchuk.weather.remote.openweathermap.WeatherApi;
import ru.tatarchuk.weather.remote.openweathermap.WeatherApiImpl;
import ru.tatarchuk.weather.remote.openweathermap.WeatherRetrofitApi;

/**
 * @author tatarchukilya@gmail.com
 */
@Module
public class WeatherRemoteModule {

    public static final String OPEN_WEATHER_MAP = "https://api.openweathermap.org/data/2.5/";

    @Named(OPEN_WEATHER_MAP)
    @Singleton
    @Provides
    static Retrofit provideWeatherRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(client)
                .baseUrl(OPEN_WEATHER_MAP)
                .build();
    }

    @Provides
    @Singleton
    static WeatherRetrofitApi provideRetrofitWeatherApi(@Named(OPEN_WEATHER_MAP) Retrofit retrofit) {
        return retrofit.create(WeatherRetrofitApi.class);
    }

    @Provides
    @Singleton
    static WeatherApi provideWeatherApi(WeatherRetrofitApi api) {
        return new WeatherApiImpl(api);
    }
}
