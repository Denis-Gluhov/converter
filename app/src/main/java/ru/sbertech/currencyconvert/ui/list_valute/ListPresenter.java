package ru.sbertech.currencyconvert.ui.list_valute;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import ru.sbertech.currencyconvert.model.ValCurs;

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
    public void loadData() {
        interactor.loadData(this);
    }

    @Override
    public void onSuccess(@NonNull ValCurs response) {
        view.dismissRefreshing();
        view.setData(response.getValutes());
    }

    @Override
    public void onFailed(@NonNull Throwable throwable) {
        Throwable throwable1 = throwable;
    }
}
