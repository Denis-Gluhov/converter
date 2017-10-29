package ru.sbertech.currencyconvert.model.repository;

import java.util.List;

import ru.sbertech.currencyconvert.model.Currency;

public interface IDatabaseModule {
    void add(List<Currency> data);
    void clear();
    List<Currency> getAll();
}
