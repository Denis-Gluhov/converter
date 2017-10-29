package ru.sbertech.currencyconvert.screens.list.view;

import ru.sbertech.currencyconvert.IView;

public interface IListView extends IView {
    void showProgressDialog();
    void dismissProgressDialog();
    void dismissRefreshing();
}
