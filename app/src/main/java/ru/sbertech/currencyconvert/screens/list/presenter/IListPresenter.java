package ru.sbertech.currencyconvert.screens.list.presenter;

import java.util.List;

import ru.sbertech.currencyconvert.model.Currency;

public interface IListPresenter {
    void setData(List<Currency> data);
    void onRefreshData();
}
