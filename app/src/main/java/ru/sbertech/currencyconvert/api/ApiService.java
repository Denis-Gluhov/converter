package ru.sbertech.currencyconvert.api;

import retrofit2.http.GET;
import ru.sbertech.currencyconvert.model.ValCurs;
import rx.Observable;

public interface ApiService {
    @GET("/scripts/XML_daily.asp")
    Observable<ValCurs> getValute();
}
