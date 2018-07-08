package ru.sbertech.currencyconvert.network;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.UnsupportedEncodingException;

@Root(name = "Valute", strict = false)
public class ValuteResponse {

    @Element(required = false, name = "NumCode")
    private String numCode;

    @Element(required = false, name = "CharCode")
    private String charCode;

    @Element(required = false, name = "Nominal")
    private String nominal;

    @Element(required = false, name = "Name")
    private String name;

    @Element(required = true, name = "Value")
    private String value;

    public String getName() {
        return name;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
