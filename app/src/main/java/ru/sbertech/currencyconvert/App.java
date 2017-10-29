package ru.sbertech.currencyconvert;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    public static Context APP_CONTEXT;

    @Override
    public void onCreate() {
        super.onCreate();
        APP_CONTEXT = getApplicationContext();
    }
}
