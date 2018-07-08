package ru.sbertech.currencyconvert.di;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import ru.sbertech.currencyconvert.network.ApiService;

@Module
public class NetworkModule {

    private static final String BASE_URL = "http://www.cbr.ru/";
    private static final long TIMEOUT = 60;

    @NonNull
    @Singleton
    @Provides
    ApiService provideNetworkService(@NonNull Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @NonNull
    @Singleton
    @Provides
    Retrofit provideRetrofit(@NonNull OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @NonNull
    @Singleton
    @Provides
    OkHttpClient provideClient() {
        return new OkHttpClient.Builder()
//                .addInterceptor((Interceptor.Chain chain) -> {
//                    Response response = chain.proceed(chain.request());
//                    response.newBuilder()
//                            .build();
//                    return response;
//                })
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }
}
