package ru.tander.currencyconvert.model.repository;

import java.util.List;

import ru.tander.currencyconvert.model.Currency;

public interface INetworkModule {
    void onLoadData(OnLoadDataListener listener);

    interface OnLoadDataListener {
        void onSuccess(List<Currency> data);
        void onFail();
    }
}
