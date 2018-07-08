package ru.sbertech.currencyconvert.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.sbertech.currencyconvert.R;
import ru.sbertech.currencyconvert.repository.ValuteInfo;

public class ValutesListAdapter extends RecyclerView.Adapter<ValutesListAdapter.CurrencyViewHolder> {

    private List<ValuteInfo> data;
    private LayoutInflater inflater;

    ValutesListAdapter(@NonNull Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CurrencyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_currency, parent, false);
        return new CurrencyViewHolder(view);
    }

    public void setData(@NonNull List<ValuteInfo> data) {
        this.data = data;
    }

    @Override
    public void onBindViewHolder(CurrencyViewHolder holder, int position) {
        ValuteInfo valute = data.get(position);
        holder.name.setText(valute.getName());
    }

    @Override
    public int getItemCount() {
        if (data == null)
            return 0;
        else
            return data.size();
    }

    static class CurrencyViewHolder extends RecyclerView.ViewHolder{
        final TextView name;
        final TextView fullText;

        CurrencyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_currency);
            fullText = itemView.findViewById(R.id.full_text);
        }
    }
}
