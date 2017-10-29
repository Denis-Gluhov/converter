package ru.sbertech.currencyconvert.screens.convert.presenter;

public interface IConvertPresenter {
    void setBaseCurrency(int position);
    void setFinalCurrency(int position);
    void setValueBaseCurrency(String value);
}
