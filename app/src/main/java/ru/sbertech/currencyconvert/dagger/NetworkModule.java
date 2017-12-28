package ru.sbertech.currencyconvert.dagger;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import ru.sbertech.currencyconvert.repository.NetworkRepository;
import ru.sbertech.currencyconvert.repository.NetworkRepositoryImpl;
import ru.sbertech.currencyconvert.repository.NetworkService;

@Module
class NetworkModule {

    @NonNull
    @Singleton
    @Provides
    NetworkRepository provideNetworkRepository(@NonNull NetworkService service) {
        return new NetworkRepositoryImpl(service);
    }

    @NonNull
    @Singleton
    @Provides
    NetworkService provideNetworkService(@NonNull Retrofit retrofit) {
        return retrofit.create(NetworkService.class);
    }

    @NonNull
    @Singleton
    @Provides
    Retrofit provideRetrofit(@NonNull OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(NetworkRepositoryImpl.BASE_URL)
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
                .build();
    }
}
