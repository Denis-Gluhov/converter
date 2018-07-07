package ru.sbertech.currencyconvert.database;

import android.arch.persistence.room.Database;

@Database(entities = Valute.class, version = 1)
public abstract class AppDatabase {
    public abstract ValuteDao valuteDao();
}
