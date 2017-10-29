package ru.sbertech.currencyconvert;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import ru.sbertech.currencyconvert.screens.convert.view.ConvertView;
import ru.sbertech.currencyconvert.screens.list.view.ListView;

public class TabFragmentAdapter extends FragmentPagerAdapter {

    private List<TabFragment> tab;
    private ListView listView;
    private ConvertView convertView;

    public TabFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        initTabs(context);
    }

    private void initTabs(Context context) {
        tab = new ArrayList<>(2);
        listView = ListView.getInstance(context);
        tab.add(listView);
        convertView = ConvertView.getInstance(context);
        tab.add(convertView);
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
