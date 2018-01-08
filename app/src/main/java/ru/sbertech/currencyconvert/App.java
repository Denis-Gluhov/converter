package ru.sbertech.currencyconvert;

import android.app.Application;
import android.support.annotation.NonNull;

import ru.sbertech.currencyconvert.dagger.AppComponent;
import ru.sbertech.currencyconvert.dagger.AppModule;
import ru.sbertech.currencyconvert.dagger.DaggerAppComponent;
import ru.sbertech.currencyconvert.dagger.NetworkModule;
import ru.sbertech.currencyconvert.list_valute.ListFragment;
import ru.sbertech.currencyconvert.list_valute.ListFragmentComponent;
import ru.sbertech.currencyconvert.list_valute.ListFragmentModule;

public class App extends Application {

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    private AppComponent appComponent;
    private ListFragmentComponent listFragmentComponent;

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

    public ListFragmentComponent initListFragmentComponent(@NonNull ListFragment listFragment) {
        listFragmentComponent = appComponent.listFragmentComponent(new ListFragmentModule(listFragment));
        return listFragmentComponent;
    }
}
