package ru.sbertech.currencyconvert.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

import ru.sbertech.currencyconvert.model.CurrencyOld;

public class SAXHandler extends DefaultHandler {

    private static final String VALUTE = "Valute";
    private static final String NUM_CODE = "NumCode";
    private static final String CHAR_CODE = "CharCode";
    private static final String NOMINAL = "Nominal";
    private static final String NAME = "Name";
    private static final String VALUE = "Value";

    private ArrayList<CurrencyOld> currencies;
    private CurrencyOld currencyOld;
    private boolean numCodeTag, charCodeTag, nominalTag, nameTag, valueTag;

    @Override
    public void startDocument() throws SAXException {
        currencies = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (VALUTE.equals(qName)){
            currencyOld = new CurrencyOld();
        }
        numCodeTag = NUM_CODE.equals(qName);
        charCodeTag = CHAR_CODE.equals(qName);
        nominalTag = NOMINAL.equals(qName);
        nameTag = NAME.equals(qName);
        valueTag = VALUE.equals(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!numCodeTag && !charCodeTag && !nominalTag && !nameTag && !valueTag){
            currencies.add(currencyOld);
        }
        numCodeTag = false;
        charCodeTag = false;
        nominalTag = false;
        nameTag = false;
        valueTag = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (numCodeTag){
            currencyOld.setNumCode(new String(ch, start, length));
        } else if (charCodeTag){
            currencyOld.setCharCode(new String(ch, start, length));
        } else if (nominalTag){
            currencyOld.setNominal(Integer.parseInt(new String(ch, start, length)));
        } else if (valueTag){
            String s = new String(ch, start, length);
            currencyOld.setValue(Double.parseDouble(s.replace(',', '.')));
        } else if (nameTag){
            currencyOld.setName(new String(ch, start, length));
        }
    }

    @Override
    public void endDocument() throws SAXException {
        currencies.remove(currencies.size() - 1);
    }

    public ArrayList<CurrencyOld> getCurrencies(){
        return currencies;
    }
}
