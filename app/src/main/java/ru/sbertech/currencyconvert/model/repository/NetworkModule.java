package ru.sbertech.currencyconvert.model.repository;

import android.os.AsyncTask;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import ru.sbertech.currencyconvert.model.Currency;
import ru.sbertech.currencyconvert.utils.SAXHandler;

public class NetworkModule implements INetworkModule {
    private final static String ENCODING = "windows-1251";
    private static final String URL = "http://www.cbr.ru/scripts/XML_daily.asp";

    private OnLoadDataListener listener;

    @Override
    public void onLoadData(OnLoadDataListener listener) {
        this.listener = listener;
        new Load().execute();
    }

    private class Load extends AsyncTask<Void, Void, List<Currency>> {
        @Override
        protected List<Currency> doInBackground(Void... params) {
            List<Currency> data = null;
            try {
                URL url = new URL(URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setUseCaches(false);

                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    InputStreamReader inputStreamReader = new InputStreamReader(url.openStream(), ENCODING);
                    InputSource inputSource = new InputSource(inputStreamReader);
                    inputSource.setEncoding(ENCODING);
                    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
                    SAXParser saxParser = saxParserFactory.newSAXParser();
                    XMLReader xmlReader = saxParser.getXMLReader();
                    SAXHandler saxHandler = new SAXHandler();
                    xmlReader.setContentHandler(saxHandler);
                    xmlReader.parse(inputSource);
                    inputStreamReader.close();
                    data = saxHandler.getCurrencies();
                }
            } catch (ParserConfigurationException | SAXException | IOException e) {
                e.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPostExecute(List<Currency> data) {
            if (data == null){
                listener.onFail();
            } else {
                listener.onSuccess(data);
            }
        }
    }
}
