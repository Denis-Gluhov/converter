package ru.sbertech.currencyconvert;

import android.app.Application;

import ru.sbertech.currencyconvert.di.AppComponent;
import ru.sbertech.currencyconvert.di.AppModule;
import ru.sbertech.currencyconvert.di.DaggerAppComponent;
import ru.sbertech.currencyconvert.di.NetworkModule;
import ru.sbertech.currencyconvert.di.ValutesComponent;

public class App extends Application {

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    private AppComponent appComponent;
    private ValutesComponent valutesComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDagger();
    }

    private void initDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public ValutesComponent plusValutesComponent() {
        if (valutesComponent == null)
            valutesComponent = appComponent.plusValutesComponent();
        return valutesComponent;
    }

    public void clearValutesComponent() {
        valutesComponent = null;
    }
}
