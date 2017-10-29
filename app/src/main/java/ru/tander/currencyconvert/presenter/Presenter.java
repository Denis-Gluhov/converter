package ru.tander.currencyconvert.presenter;

import android.support.annotation.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import ru.tander.currencyconvert.model.Currency;
import ru.tander.currencyconvert.model.repository.DatabaseModule;
import ru.tander.currencyconvert.model.repository.IDatabaseModule;
import ru.tander.currencyconvert.model.repository.INetworkModule;
import ru.tander.currencyconvert.model.repository.NetworkModule;
import ru.tander.currencyconvert.IView;

public class Presenter implements IPresenter {

    private IView iView;
    private INetworkModule networkRepository;
    private IDatabaseModule databaseRepository;

    private double valueSource, valueFinal;
    private int nominal;

    public Presenter(@NonNull IView iView) {
        this.iView = iView;
//        databaseRepository = new DatabaseModule(iView.getContext());
//        networkRepository = new NetworkModule(this);
//        networkRepository.onLoadData(URL);
    }

    @Override
    public void setData(List<Currency> data) {
        if (data != null) {
            databaseRepository.clear();
            databaseRepository.add(data);
            iView.refreshData(data);
        } else {
            iView.refreshData(databaseRepository.getAll());
        }
    }

    @Override
    public String convert(String sum) {
        if (!sum.equals("")) {
            double sumSourceCurrency = Double.parseDouble(sum);
            double result = new BigDecimal(((valueSource * sumSourceCurrency) / valueFinal) * nominal).setScale(2,
                    RoundingMode.UP).doubleValue();
            return result + "";
        } else {
            return "Error";
        }
    }

    @Override
    public void setValueSource(double valueSource) {
        this.valueSource = valueSource;
    }

    @Override
    public void setValueFinal(double valueFinal) {
        this.valueFinal = valueFinal;
    }

    @Override
    public void setNominal(int nominal) {
        this.nominal = nominal;
    }
}
