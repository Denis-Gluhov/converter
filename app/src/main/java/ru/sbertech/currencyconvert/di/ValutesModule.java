package ru.sbertech.currencyconvert.di;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import ru.sbertech.currencyconvert.database.AppDatabase;
import ru.sbertech.currencyconvert.database.ValuteDao;
import ru.sbertech.currencyconvert.network.ApiService;
import ru.sbertech.currencyconvert.repository.ValutesRepository;

@Module
public class ValutesModule {

    @NonNull
    @ValutesScope
    @Provides
    ValutesRepository provideValuteRepository(@NonNull ApiService apiService,
                                              @NonNull ValuteDao valuteDao) {
        return new ValutesRepository(apiService, valuteDao);
    }

    @NonNull
    @ValutesScope
    @Provides
    ValuteDao provideValuteDao(@NonNull AppDatabase appDatabase) {
        return appDatabase.valuteDao();
    }
}
