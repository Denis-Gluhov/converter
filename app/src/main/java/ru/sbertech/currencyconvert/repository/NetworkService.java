package ru.sbertech.currencyconvert.repository;

import retrofit2.http.GET;
import ru.sbertech.currencyconvert.model.ValCurs;
import rx.Observable;

public interface NetworkService {
    @GET("/scripts/XML_daily.asp")
    Observable<ValCurs> getValute();
}
