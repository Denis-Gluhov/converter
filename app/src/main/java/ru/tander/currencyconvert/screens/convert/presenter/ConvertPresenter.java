package ru.tander.currencyconvert.screens.convert.presenter;

import ru.tander.currencyconvert.screens.convert.view.IConvertView;

public class ConvertPresenter implements IConvertPresenter {

    private IConvertView convertView;

    public ConvertPresenter(IConvertView convertView) {
        this.convertView = convertView;
    }


}
