package ru.tander.currencyconvert.screens.convert.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import ru.tander.currencyconvert.R;
import ru.tander.currencyconvert.TabFragment;
import ru.tander.currencyconvert.model.Currency;
import ru.tander.currencyconvert.presenter.IPresenter;
import ru.tander.currencyconvert.presenter.Presenter;

public class ConvertView extends TabFragment implements IConvertView {

    private List<Currency> data;
    private CustomSpinnerAdapter adapter;
    private IPresenter presenter;

    public static ConvertView getInstance(Context context){
        Bundle bundle = new Bundle();
        ConvertView fragment = new ConvertView();
        fragment.setArguments(bundle);
        fragment.setTitle(context.getString(R.string.text_converter));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_convert_currency, container, false);
        adapter = new CustomSpinnerAdapter(getActivity());

        presenter = new Presenter(this);

        initSpinner();
        final EditText editText = (EditText) view.findViewById(R.id.source_edit);
        final TextView textView = (TextView) view.findViewById(R.id.final_edit);
        Button button = (Button) view.findViewById(R.id.btn_ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(presenter.convert(editText.getText().toString()));
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    private void initSpinner() {
        Spinner sourceSpinner = (Spinner) view.findViewById(R.id.source_spinner);
        sourceSpinner.setAdapter(adapter);
        sourceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                presenter.setValueSource(data.get(position).getValue());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner finalSpinner = (Spinner) view.findViewById(R.id.final_spinner);
        finalSpinner.setAdapter(adapter);
        finalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                presenter.setValueFinal(data.get(position).getValue());
                presenter.setNominal(data.get(position).getNominal());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void refreshData(@NonNull List<Currency> data) {
        this.data = data;
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }
}
