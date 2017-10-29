package ru.tander.currencyconvert;

import android.support.annotation.NonNull;

import java.util.List;

import ru.tander.currencyconvert.model.Currency;

public interface IView {
    void refreshData(@NonNull List<Currency> data);
}
