package ru.sbertech.currencyconvert.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Valute.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract ValuteDao valuteDao();
}
