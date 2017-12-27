package ru.sbertech.currencyconvert.screens.list.presenter;

import android.support.annotation.NonNull;

import java.util.List;

import ru.sbertech.currencyconvert.model.CurrencyOld;
import ru.sbertech.currencyconvert.screens.list.interactor.IListInteractor;
import ru.sbertech.currencyconvert.screens.list.interactor.ListInteractor;
import ru.sbertech.currencyconvert.screens.list.view.IListView;

public class ListPresenter implements IListPresenter {

    private IListView listView;
    private IListInteractor listInteractor;

    public ListPresenter(IListView listView) {
        this.listView = listView;
        listInteractor = new ListInteractor(this);
        listView.showProgressDialog();
        listInteractor.loadData();
    }

    @Override
    public void setData(@NonNull List<CurrencyOld> data) {
        listView.dismissProgressDialog();
        listView.dismissRefreshing();
        listView.refreshData(data);
    }

    public void onRefreshData() {
        listInteractor.loadData();
    }
}
