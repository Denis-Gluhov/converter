package ru.sbertech.currencyconvert.repository;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;
import ru.sbertech.currencyconvert.model.Valute;

public class NetworkRepositoryImpl implements NetworkRepository {

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
