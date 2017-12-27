package ru.sbertech.currencyconvert.repository;

import java.util.List;

import io.reactivex.Observable;
import ru.sbertech.currencyconvert.model.Valute;

public interface NetworkRepository {
    Observable<List<Valute>> getValute();
}
