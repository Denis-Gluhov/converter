package ru.sbertech.currencyconvert.convert_valute;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ru.sbertech.currencyconvert.R;
import ru.sbertech.currencyconvert.model.Valute;

public class CustomSpinnerAdapter extends ArrayAdapter<Valute> {

    private List<Valute> data;
    private Activity activity;

    public CustomSpinnerAdapter(Activity activity) {
        super(activity, R.layout.custom_dropdown_item);
        this.activity = activity;
    }

    @Override
    public int getCount() {
        if (data == null)
            return 0;
        else
            return data.size();
    }

    public void setData(List<Valute> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final Valute currencyOld = data.get(position);
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.custom_dropdown_item, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.dropdown_item);
        textView.setText(currencyOld.getName());
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Valute currencyOld = data.get(position);
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.custom_dropdown_item, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.dropdown_item);
        textView.setText(currencyOld.getName());
        return view;
    }
}
