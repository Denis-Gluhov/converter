package ru.tander.currencyconvert.screens.convert.interactor;

import ru.tander.currencyconvert.model.repository.DatabaseModule;
import ru.tander.currencyconvert.model.repository.IDatabaseModule;
import ru.tander.currencyconvert.screens.convert.presenter.IConvertPresenter;

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
