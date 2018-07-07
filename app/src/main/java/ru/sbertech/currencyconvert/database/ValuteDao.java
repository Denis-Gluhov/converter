package ru.sbertech.currencyconvert.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.support.annotation.NonNull;

import java.util.List;

@Dao
public interface ValuteDao {
    @NonNull
    @Query("SELECT * FROM Valute")
    LiveData<List<Valute>> load();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(@NonNull Valute valute);
}
