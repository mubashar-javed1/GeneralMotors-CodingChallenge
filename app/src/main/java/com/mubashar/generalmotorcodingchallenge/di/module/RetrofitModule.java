package com.mubashar.generalmotorcodingchallenge.di.module;

import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mubashar.generalmotorcodingchallenge.BuildConfig;
import com.mubashar.generalmotorcodingchallenge.network.ApiConfig;
import com.mubashar.generalmotorcodingchallenge.network.exception.ConnectivityInterceptor;
import com.mubashar.generalmotorcodingchallenge.network.exception.ConnectivityInterceptorImp;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {
    private final Context context;

    public RetrofitModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder builder =
                new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return builder.setLenient().create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(ApiConfig.BASE)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient getHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // adding logging interceptor
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ?
                HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        httpClient.addInterceptor(loggingInterceptor);
        // adding connectivity interceptor
        ConnectivityInterceptor connectivityInterceptor = new ConnectivityInterceptorImp(context);
        httpClient.addInterceptor(connectivityInterceptor);

        httpClient.addInterceptor(chain -> {
            Request original = chain.request()
                    .newBuilder()
                    // adding header
                    .build();
            Request request = original.newBuilder().build();
            return chain.proceed(request);
        })
                .connectTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS);

        return httpClient.build();
    }
}