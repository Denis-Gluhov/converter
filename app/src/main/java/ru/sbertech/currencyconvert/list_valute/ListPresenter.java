package ru.sbertech.currencyconvert.list_valute;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import ru.sbertech.currencyconvert.model.ValCurs;
import ru.sbertech.currencyconvert.model.Valute;

public class ListPresenter implements ListContract.Presenter, ListContract.Interactor.OnLoadDataListener {

    @NonNull
    private final ListContract.View view;
    @NonNull
    private final ListContract.Interactor interactor;

    @Inject
    ListPresenter(@NonNull ListContract.View view,
                  @NonNull ListContract.Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onLoadData() {
        interactor.loadData(this);
    }

    @Override
    public void onRefreshData() {

    }

    @Override
    public void onSuccess(@NonNull ValCurs response) {
        List<Valute> valutes = response.getValutes();
    }

    @Override
    public void onFailed(@NonNull Throwable throwable) {
        Throwable throwable1 = throwable;
    }
}
