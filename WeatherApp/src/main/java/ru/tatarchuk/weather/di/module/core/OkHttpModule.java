package ru.tatarchuk.weather.di.module.core;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author tatarchukilya@gmail.com
 */
@Module
public class OkHttpModule {

    @Provides
    @Singleton
    static HttpLoggingInterceptor provideInterceptor() {
        return new HttpLoggingInterceptor(System.out::println).setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    static OkHttpClient provideOkHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }
}
