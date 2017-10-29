package ru.sbertech.currencyconvert;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

public class TabFragment extends Fragment {
    private String title;
    protected View view;
    public Context context;

    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
}
