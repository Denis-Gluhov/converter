package ru.sbertech.currencyconvert.di;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.sbertech.currencyconvert.App;

@Module
public class AppModule {

    @NonNull
    private final App app;

    public AppModule(@NonNull App app) {
        this.app = app;
    }

    @NonNull
    @Singleton
    @Provides
    Context provideContext() {
        return app;
    }
}
