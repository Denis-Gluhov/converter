package ru.sbertech.currencyconvert.list_valute;

import android.support.annotation.NonNull;

import ru.sbertech.currencyconvert.model.ValCurs;
import ru.sbertech.currencyconvert.repository.NetworkRepository;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ListInteractor implements ListContract.Interactor {

    @NonNull
    private final NetworkRepository networkRepository;

    public ListInteractor(@NonNull NetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    public void loadData(@NonNull OnLoadDataListener listener) {
        Observable<ValCurs> data = networkRepository.getValute();
        data.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess, listener::onFailed);
    }
}
