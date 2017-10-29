package ru.sbertech.currencyconvert.screens.convert.view;

import ru.sbertech.currencyconvert.IView;

public interface IConvertView extends IView {
    void showMessage(String message);
    void setResult(String value);
}
