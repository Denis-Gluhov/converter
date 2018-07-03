package ru.sbertech.currencyconvert.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

public interface Repository<T> {

    boolean isEmpty();

    @Nullable
    T getItem(int id);

    void addAllItems(@NonNull List<T> items);

    void removeAll();

    List<T> getAllItems();

}
