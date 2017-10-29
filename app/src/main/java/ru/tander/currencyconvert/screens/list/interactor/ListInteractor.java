package ru.tander.currencyconvert.screens.list.interactor;

import java.util.List;

import ru.tander.currencyconvert.model.Currency;
import ru.tander.currencyconvert.model.repository.DatabaseModule;
import ru.tander.currencyconvert.model.repository.IDatabaseModule;
import ru.tander.currencyconvert.model.repository.INetworkModule;
import ru.tander.currencyconvert.model.repository.NetworkModule;
import ru.tander.currencyconvert.screens.list.presenter.IListPresenter;

public class ListInteractor implements IListInteractor, INetworkModule.OnLoadDataListener {

    private IListPresenter listPresenter;
    private IDatabaseModule databaseModule;
    private INetworkModule networkModule;

    public ListInteractor(IListPresenter listPresenter) {
        this.listPresenter = listPresenter;
        databaseModule = new DatabaseModule();
        networkModule = new NetworkModule();
    }

    @Override
    public void loadData() {
        networkModule.onLoadData(this);
    }

    @Override
    public void onSuccess(List<Currency> data) {
        databaseModule.clear();
        databaseModule.add(data);
        listPresenter.setData(data);
    }

    @Override
    public void onFail() {
        if (databaseModule.getAll().size() != 0) {
            listPresenter.setData(databaseModule.getAll());
        }
    }
}
