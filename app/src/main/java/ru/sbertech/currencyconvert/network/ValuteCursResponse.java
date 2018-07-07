package ru.sbertech.currencyconvert.network;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Root(name = "ValCurs", strict = false)
public final class ValuteCursResponse {

    @Attribute(name = "name")
    private String name;

    @Attribute(name = "Date")
    private String date;

    @ElementList(required = false, name = "Valute", inline = true)
    private List<Data> valutes;

    public List<Data> getValutes() {
        return valutes;
    }

    public void setValutes(List<Data> valutes) {
        this.valutes = valutes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Root(name = "Valute", strict = false)
    public final class Data {

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
            try {
                return new String(name.getBytes("UTF-8"), "cp1251");
            } catch (UnsupportedEncodingException e) {
                return name;
            }
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
}
