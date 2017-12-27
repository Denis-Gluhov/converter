package ru.sbertech.currencyconvert;

import android.support.annotation.NonNull;

import java.util.List;

import ru.sbertech.currencyconvert.model.CurrencyOld;

public interface IView {
    void refreshData(@NonNull List<CurrencyOld> data);
}
