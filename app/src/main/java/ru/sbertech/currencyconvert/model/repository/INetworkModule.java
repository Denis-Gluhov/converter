package ru.sbertech.currencyconvert.model.repository;

import java.util.List;

import ru.sbertech.currencyconvert.model.Currency;

public interface INetworkModule {
    void onLoadData(OnLoadDataListener listener);

    interface OnLoadDataListener {
        void onSuccess(List<Currency> data);
        void onFail();
    }
}
