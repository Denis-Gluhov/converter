package ru.sbertech.currencyconvert.repository;

import android.support.annotation.NonNull;

import ru.sbertech.currencyconvert.network.ValuteResponse;

public class ValuteInfo {

    private int numCode;
    private String charCode;
    private int nominal;
    private String name;
    private double value;

    public ValuteInfo(@NonNull ValuteResponse data) {
        this.numCode = Integer.parseInt(data.getNumCode());
        this.charCode = data.getCharCode();
        this.nominal = Integer.parseInt(data.getNominal());
        this.name = data.getName();
        this.value = Double.parseDouble(data.getValue().replace(',', '.'));
    }

    public int getNumCode() {
        return numCode;
    }

    public void setNumCode(int numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
