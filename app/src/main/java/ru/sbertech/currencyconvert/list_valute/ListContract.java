package ru.sbertech.currencyconvert.list_valute;

import android.support.annotation.NonNull;

import java.util.List;

import ru.sbertech.currencyconvert.model.ValCurs;
import ru.sbertech.currencyconvert.model.Valute;

public interface ListContract {

    interface View {
        void showProgressDialog();
        void dismissProgressDialog();
        void dismissRefreshing();
        void refreshData(@NonNull List<Valute> data);
    }

    interface Presenter {
        void onLoadData();
        void onRefreshData();
    }

    interface Interactor {
        void loadData(@NonNull OnLoadDataListener listener);

        interface OnLoadDataListener {
            void onSuccess(@NonNull ValCurs response);
            void onFailed(@NonNull Throwable throwable);
        }
    }
}
