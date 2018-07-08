package ru.sbertech.currencyconvert.network;

import android.support.annotation.NonNull;

import retrofit2.http.GET;
import rx.Single;

public interface ApiService {
    @NonNull
    @GET("/scripts/XML_daily.asp")
    Single<Response> getValuteCursResponse();
}
