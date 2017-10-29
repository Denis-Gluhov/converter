package ru.sbertech.currencyconvert.screens.convert.interactor;

import ru.sbertech.currencyconvert.model.repository.DatabaseModule;
import ru.sbertech.currencyconvert.model.repository.IDatabaseModule;
import ru.sbertech.currencyconvert.screens.convert.presenter.IConvertPresenter;

public class ConvertInteractor implements IConvertInteractor {

    private IDatabaseModule databaseModule;
    private IConvertPresenter convertPresenter;

    public ConvertInteractor(IConvertPresenter convertPresenter) {
        this.convertPresenter = convertPresenter;
        databaseModule = new DatabaseModule();
    }

    @Override
    public void loadData() {
        databaseModule.getAll();
    }
}
