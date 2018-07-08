package ru.sbertech.currencyconvert.di;

import dagger.Subcomponent;
import ru.sbertech.currencyconvert.ui.ValutesActivityViewModel;

@ValutesScope
@Subcomponent(modules = ValutesModule.class)
public interface ValutesComponent {
    void inject(ValutesActivityViewModel viewModel);
}
