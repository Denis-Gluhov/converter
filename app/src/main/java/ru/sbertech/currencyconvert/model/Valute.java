package ru.sbertech.currencyconvert.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.strategy.Type;

@Root(name = "Valute", strict = false)
public class Valute {

    @Element(required = false, name = "NumCode")
    private String numCode;

    @Element(required = false, name = "CharCode")
    private String charCode;

    @Element(required = false, name = "Nominal")
    private int nominal;

    @Element(required = false, name = "Name")
    private String name;

    @Element(required = true, name = "Value", type = Double.class)
    private Double value;

    public Valute() {
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

//    public String getCharCode() {
//        return charCode;
//    }
//
//    public void setCharCode(String charCode) {
//        this.charCode = charCode;
//    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
