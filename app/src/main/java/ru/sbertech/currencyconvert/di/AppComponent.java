package ru.sbertech.currencyconvert.di;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Component;
import ru.sbertech.currencyconvert.ui.list_valute.ListFragmentComponent;
import ru.sbertech.currencyconvert.ui.list_valute.ListFragmentModule;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, DatabaseModule.class})
public interface AppComponent {
    ListFragmentComponent listFragmentComponent(@NonNull ListFragmentModule listFragmentModule);
}
