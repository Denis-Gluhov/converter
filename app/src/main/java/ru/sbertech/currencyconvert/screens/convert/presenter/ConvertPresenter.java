package ru.sbertech.currencyconvert.screens.convert.presenter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import ru.sbertech.currencyconvert.model.Currency;
import ru.sbertech.currencyconvert.model.repository.ContractRepository;
import ru.sbertech.currencyconvert.model.repository.Database;
import ru.sbertech.currencyconvert.screens.convert.view.IConvertView;

public class ConvertPresenter implements IConvertPresenter {

    private IConvertView convertView;
    private ContractRepository.Database databaseModule;

    private List<Currency> data;

    private double baseValue;
    private double finalValue;

    public ConvertPresenter(IConvertView convertView) {
        this.convertView = convertView;
        databaseModule = new Database();
        data = databaseModule.getAll();
        convertView.refreshData(data);
    }

    private double round(double value) {
        return new BigDecimal(value)
                .setScale(1, RoundingMode.UP).doubleValue();
    }

    @Override
    public void setBaseCurrency(int position) {
        baseValue = round(data.get(position).getValue()/data.get(position).getNominal());
    }

    @Override
    public void setFinalCurrency(int position) {
        finalValue = round(data.get(position).getValue()/data.get(position).getNominal());
    }

    @Override
    public void setValueBaseCurrency(String value) {
        if (value.length() > 0)
            convertView.setResult(String.valueOf(round(baseValue * Double.valueOf(value) / finalValue)));
        else
            convertView.showMessage("Error!");
    }
}
