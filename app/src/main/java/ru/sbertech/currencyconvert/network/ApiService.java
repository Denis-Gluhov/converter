package ru.sbertech.currencyconvert.network;

import android.support.annotation.NonNull;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {
    @NonNull
    @GET("/scripts/XML_daily.asp")
    Single<ValuteCursResponse> getValuteCursResponse();
}
