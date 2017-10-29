package ru.tander.currencyconvert.screens.convert.view;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ru.tander.currencyconvert.R;
import ru.tander.currencyconvert.model.Currency;

public class CustomSpinnerAdapter extends ArrayAdapter<Currency> {

    private List<Currency> data;
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

    public void setData(List<Currency> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final Currency currency = data.get(position);
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.custom_dropdown_item, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.dropdown_item);
        textView.setText(currency.getName());
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Currency currency = data.get(position);
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.custom_dropdown_item, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.dropdown_item);
        textView.setText(currency.getName());
        return view;
    }
}
