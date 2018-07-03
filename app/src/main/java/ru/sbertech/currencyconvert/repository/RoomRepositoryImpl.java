package ru.sbertech.currencyconvert.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import ru.sbertech.currencyconvert.model.Valute;

public class RoomRepositoryImpl implements Repository<Valute> {

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Nullable
    @Override
    public Valute getItem(int id) {
        return null;
    }

    @Override
    public void addAllItems(@NonNull List<Valute> items) {

    }

    @Override
    public void removeAll() {

    }

    @Override
    public List<Valute> getAllItems() {
        return null;
    }
}
