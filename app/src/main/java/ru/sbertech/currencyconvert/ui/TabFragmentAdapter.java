package ru.sbertech.currencyconvert.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabFragmentAdapter extends FragmentPagerAdapter {

    private List<TabFragment> tab;

    TabFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        initTabs(context);
    }

    private void initTabs(Context context) {
        tab = new ArrayList<>(2);
        ListValutesFragment listValutesFragment = ListValutesFragment.getInstance(context);
        tab.add(listValutesFragment);
        ConvertValutesFragment convertValutesFragment = ConvertValutesFragment.getInstance(context);
        tab.add(convertValutesFragment);
    }

    @Override
    public Fragment getItem(int position) {
        return tab.get(position);
    }

    @Override
    public int getCount() {
        return tab.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tab.get(position).getTitle();
    }
}
