package ru.sbertech.currencyconvert.list_valute;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import ru.sbertech.currencyconvert.repository.NetworkRepository;

@Module
public class ListFragmentModule {

    @NonNull
    private final ListContract.View view;

    public ListFragmentModule(@NonNull ListContract.View view) {
        this.view = view;
    }

    @NonNull
    @ListFragmentScope
    @Provides
    ListContract.View provideView() {
        return view;
    }

    @NonNull
    @ListFragmentScope
    @Provides
    ListContract.Interactor provideInteractor(@NonNull NetworkRepository networkRepository) {
        return new ListInteractor(networkRepository);
    }

    @NonNull
    @ListFragmentScope
    @Provides
    ListContract.Presenter providePresenter(@NonNull ListContract.View view,
                                            @NonNull ListContract.Interactor interactor) {
        return new ListPresenter(view, interactor);
    }
}
