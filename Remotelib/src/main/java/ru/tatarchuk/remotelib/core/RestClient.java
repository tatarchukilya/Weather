package ru.tatarchuk.remotelib.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author tatarchukilya@gmail.com
 */
public abstract class RestClient {

    private Retrofit mRetrofit;

    public RestClient() {
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new OkHttpClient.Builder().addInterceptor(createInterceptor()).build())
                .baseUrl(getBaseUrl())
                .build();
    }

    protected HttpLoggingInterceptor createInterceptor() {
        return new HttpLoggingInterceptor(System.out::println);
    }

    protected Gson createGson() {
        return new GsonBuilder().create();
    }

    public <S> S createService(Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }

    protected abstract String getBaseUrl();
}
