package ru.tander.currencyconvert.screens.list.view;

import ru.tander.currencyconvert.IView;

public interface IListView extends IView {
    void showProgressDialog();
    void dismissProgressDialog();
    void dismissRefreshing();
}
