package ru.sbertech.currencyconvert.screens.list.presenter;

import android.support.annotation.NonNull;

import java.util.List;

import ru.sbertech.currencyconvert.model.Currency;

public interface IListPresenter {
    void setData(@NonNull List<Currency> data);
    void onRefreshData();
}
