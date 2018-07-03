package ru.sbertech.currencyconvert.model;

import android.util.Xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import okio.Utf8;

@Root(name = "Valute", strict = false)
public class Valute {

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


//        return name;
    }
}
