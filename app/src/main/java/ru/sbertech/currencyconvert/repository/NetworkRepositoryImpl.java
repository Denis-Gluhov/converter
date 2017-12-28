package ru.sbertech.currencyconvert.repository;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;
import ru.sbertech.currencyconvert.model.Valute;

public class NetworkRepositoryImpl implements NetworkRepository {

    public static final String BASE_URL = "http://www.cbr.ru/";

    @NonNull
    private NetworkService service;

    public NetworkRepositoryImpl(@NonNull NetworkService service) {
        this.service = service;
    }

    @Override
    public Observable<List<Valute>> getValute() {
        return service.getValute();
    }
}
