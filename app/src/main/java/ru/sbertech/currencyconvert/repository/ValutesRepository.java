package ru.sbertech.currencyconvert.repository;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


import ru.sbertech.currencyconvert.database.ValuteDao;
import ru.sbertech.currencyconvert.network.Response;
import ru.sbertech.currencyconvert.network.ValuteResponse;
import ru.sbertech.currencyconvert.network.ApiService;
import rx.Single;

public class ValutesRepository {

    @NonNull
    private final ApiService apiService;
    @NonNull
    private final ValuteDao valuteDao;

    @Inject
    public ValutesRepository(@NonNull ApiService apiService, @NonNull ValuteDao valuteDao) {
        this.apiService = apiService;
        this.valuteDao = valuteDao;
    }

    public Single<List<ValuteInfo>> getValutes() {
        return Single.create(response -> apiService.getValuteCursResponse()
                .subscribe(api -> response.onSuccess(mapper(api)), response::onError));
    }

    private List<ValuteInfo> mapper(Response api) {
        List<ValuteInfo> valuteInfoList = new ArrayList<>();
        for (ValuteResponse valuteResponse : api.getValuteResponses()) {
            valuteInfoList.add(new ValuteInfo(valuteResponse));
        }
        return valuteInfoList;
    }
}
