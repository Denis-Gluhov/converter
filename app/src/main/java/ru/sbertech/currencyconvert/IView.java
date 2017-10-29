package ru.sbertech.currencyconvert;

import android.support.annotation.NonNull;

import java.util.List;

import ru.sbertech.currencyconvert.model.Currency;

public interface IView {
    void refreshData(@NonNull List<Currency> data);
}
