package ru.sbertech.currencyconvert.ui.list_valute;

import dagger.Subcomponent;

@ListFragmentScope
@Subcomponent(modules = ListFragmentModule.class)
public interface ListFragmentComponent {
    void inject(ListFragment listFragment);
}
