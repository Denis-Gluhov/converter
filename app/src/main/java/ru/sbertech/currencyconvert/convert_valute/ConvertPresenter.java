package ru.sbertech.currencyconvert.convert_valute;

public class ConvertPresenter {
/*
    private IConvertView convertView;
    private ContractRepository.Database databaseModule;

    private List<CurrencyOld> data;

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
*/
}
