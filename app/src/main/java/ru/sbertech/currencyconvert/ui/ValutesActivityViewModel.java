package ru.sbertech.currencyconvert.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import ru.sbertech.currencyconvert.App;
import ru.sbertech.currencyconvert.repository.ValuteInfo;
import ru.sbertech.currencyconvert.repository.ValutesRepository;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ValutesActivityViewModel extends ViewModel {

    @Inject
    ValutesRepository repository;

    private CompositeDisposable compositeDisposable;
    private MutableLiveData<List<ValuteInfo>> liveData;

    public ValutesActivityViewModel() {
        App.getInstance().plusValutesComponent().inject(this);
        compositeDisposable = new CompositeDisposable();
        liveData = new MutableLiveData<>();

    }

    public LiveData<List<ValuteInfo>> getListValutes() {
        repository.getValutes()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::success, this::fail);
        return liveData;
    }

    private void success(@NonNull List<ValuteInfo> data) {
        liveData.setValue(data);
    }

    private void fail(@NonNull Throwable throwable) {
        Throwable t = throwable;
    }
}
