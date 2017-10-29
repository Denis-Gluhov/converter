package ru.tander.currencyconvert.model.repository;

import java.util.List;

import ru.tander.currencyconvert.model.Currency;

public interface IDatabaseModule {
    void add(List<Currency> data);
    void clear();
    List<Currency> getAll();
}
