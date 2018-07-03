package ru.sbertech.currencyconvert.list_valute;

import android.support.annotation.NonNull;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ListInteractor implements ListContract.Interactor {

    @NonNull
    private final Network network;

    ListInteractor(@NonNull Network network) {
        this.network = network;
    }

    @Override
    public void loadData(@NonNull OnLoadDataListener listener) {
        network.getValute()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess, listener::onFailed);
    }
}
