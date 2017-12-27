package ru.sbertech.currencyconvert.screens.list.interactor;

import java.util.List;

import ru.sbertech.currencyconvert.model.CurrencyOld;
import ru.sbertech.currencyconvert.screens.list.presenter.IListPresenter;

public class ListInteractor implements IListInteractor, ContractRepository.OnLoadDataListener {

    private IListPresenter listPresenter;
    private ContractRepository.Database databaseModule;
    private ContractRepository.Network networkModule;

    public ListInteractor(IListPresenter listPresenter) {
        this.listPresenter = listPresenter;
        databaseModule = new Database();
        networkModule = new Network();
    }

    @Override
    public void loadData() {
        networkModule.onLoadData(this);
    }

    @Override
    public void onSuccess(List<CurrencyOld> data) {
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
