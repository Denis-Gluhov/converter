package ru.sbertech.currencyconvert.screens.list.presenter;

import android.support.annotation.NonNull;

import java.util.List;

import ru.sbertech.currencyconvert.model.CurrencyOld;

public interface IListPresenter {
    void setData(@NonNull List<CurrencyOld> data);
    void onRefreshData();
}
