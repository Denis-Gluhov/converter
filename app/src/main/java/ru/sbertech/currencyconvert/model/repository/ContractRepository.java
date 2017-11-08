package ru.sbertech.currencyconvert.model.repository;

import java.util.List;

import ru.sbertech.currencyconvert.model.Currency;

public interface ContractRepository {

    interface Database {
        void add(List<Currency> data);
        void clear();
        List<Currency> getAll();
    }

    interface Network {
        void onLoadData(OnLoadDataListener listener);
    }

    interface OnLoadDataListener {
        void onSuccess(List<Currency> data);
        void onFail();
    }
}
