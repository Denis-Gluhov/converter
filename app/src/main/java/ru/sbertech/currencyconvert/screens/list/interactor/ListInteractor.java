package ru.sbertech.currencyconvert.screens.list.interactor;

import java.util.List;

import ru.sbertech.currencyconvert.model.Currency;
import ru.sbertech.currencyconvert.model.repository.ContractRepository;
import ru.sbertech.currencyconvert.model.repository.Database;
import ru.sbertech.currencyconvert.model.repository.Network;
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
