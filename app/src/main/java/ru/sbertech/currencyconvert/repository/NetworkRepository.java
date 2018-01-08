package ru.sbertech.currencyconvert.repository;

import ru.sbertech.currencyconvert.model.ValCurs;
import rx.Observable;

public interface NetworkRepository {
    Observable<ValCurs> getValute();
}
