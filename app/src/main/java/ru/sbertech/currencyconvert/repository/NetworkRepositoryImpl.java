package ru.sbertech.currencyconvert.repository;

import android.support.annotation.NonNull;

import ru.sbertech.currencyconvert.model.ValCurs;
import rx.Observable;

public class NetworkRepositoryImpl implements NetworkRepository {

    public static final String BASE_URL = "http://www.cbr.ru/";

    @NonNull
    private NetworkService service;

    public NetworkRepositoryImpl(@NonNull NetworkService service) {
        this.service = service;
    }

    @Override
    public Observable<ValCurs> getValute() {
        return service.getValute();
    }
}
