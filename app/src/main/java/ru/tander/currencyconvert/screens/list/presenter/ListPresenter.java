package ru.tander.currencyconvert.screens.list.presenter;

import java.util.List;

import ru.tander.currencyconvert.model.Currency;
import ru.tander.currencyconvert.screens.list.interactor.IListInteractor;
import ru.tander.currencyconvert.screens.list.interactor.ListInteractor;
import ru.tander.currencyconvert.screens.list.view.IListView;

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
    public void setData(List<Currency> data) {
        listView.dismissProgressDialog();
        listView.dismissRefreshing();
        listView.refreshData(data);
    }

    @Override
    public void onRefreshData() {
        listInteractor.loadData();
    }
}
