package ru.sbertech.currencyconvert.convert_valute;

import android.support.annotation.NonNull;

import java.util.List;

import ru.sbertech.currencyconvert.model.Valute;

public interface ConvertContract {

    interface View {

        void refreshData(@NonNull List<Valute> data);

        void showMessage(@NonNull String message);

        void setResult(@NonNull String value);

    }

    interface Presenter {

        void setBaseCurrency(int position);

        void setFinalCurrency(int position);

        void setValueBaseCurrency(String value);


    }

    interface Interactor {

    }

}
