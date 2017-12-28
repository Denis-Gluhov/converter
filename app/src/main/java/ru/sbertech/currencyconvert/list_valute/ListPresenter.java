package ru.sbertech.currencyconvert.list_valute;

import android.support.annotation.NonNull;

import java.util.List;

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
