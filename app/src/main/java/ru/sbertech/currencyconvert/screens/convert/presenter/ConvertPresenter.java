package ru.sbertech.currencyconvert.screens.convert.presenter;

import ru.sbertech.currencyconvert.screens.convert.view.IConvertView;

public class ConvertPresenter implements IConvertPresenter {

    private IConvertView convertView;

    public ConvertPresenter(IConvertView convertView) {
        this.convertView = convertView;
    }

    @Override
    public void setBaseCurrency(int position) {

    }

    @Override
    public void setFinalCurrency(int position) {

    }

    @Override
    public void setValueBaseCurrency(String value) {

    }
}
