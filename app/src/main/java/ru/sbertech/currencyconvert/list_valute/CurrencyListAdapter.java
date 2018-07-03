package ru.sbertech.currencyconvert.list_valute;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.sbertech.currencyconvert.R;
import ru.sbertech.currencyconvert.model.Valute;

public class CurrencyListAdapter extends RecyclerView.Adapter<CurrencyListAdapter.CurrencyViewHolder> {

    private List<Valute> data;
    private LayoutInflater inflater;

    CurrencyListAdapter(@NonNull Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CurrencyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_currency, parent, false);
        return new CurrencyViewHolder(view);
    }

    public void setData(@NonNull List<Valute> data) {
        this.data = data;
    }

    @Override
    public void onBindViewHolder(CurrencyViewHolder holder, int position) {
        Valute valute = data.get(position);
        holder.name.setText(valute.getName());
//        holder.fullText.setText(valute.getNominal() + " " + valute.getCharCode() + " = " + valute.getValue() + " руб.");
    }

    @Override
    public int getItemCount() {
        if (data == null)
            return 0;
        else
            return data.size();
    }

    static class CurrencyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView fullText;

        CurrencyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name_currency);
            fullText = (TextView) itemView.findViewById(R.id.full_text);
        }
    }
}
