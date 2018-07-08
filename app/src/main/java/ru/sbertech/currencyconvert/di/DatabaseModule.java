package ru.sbertech.currencyconvert.di;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.sbertech.currencyconvert.database.AppDatabase;

@Module
public class DatabaseModule {

    private static final String DATABASE_NAME = "valutes";

    @NonNull
    @Singleton
    @Provides
    AppDatabase provideAppDatabase(@NonNull Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .build();
    }
}
