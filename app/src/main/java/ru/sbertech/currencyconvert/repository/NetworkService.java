package ru.sbertech.currencyconvert.repository;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import ru.sbertech.currencyconvert.model.Valute;

public interface NetworkService {
    @GET("/scripts/XML_daily.asp")
    Observable<List<Valute>> getValute();
}
