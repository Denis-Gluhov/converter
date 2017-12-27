package ru.sbertech.currencyconvert.screens.convert.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import ru.sbertech.currencyconvert.R;
import ru.sbertech.currencyconvert.TabFragment;
import ru.sbertech.currencyconvert.model.CurrencyOld;
import ru.sbertech.currencyconvert.screens.convert.presenter.ConvertPresenter;
import ru.sbertech.currencyconvert.screens.convert.presenter.IConvertPresenter;

public class ConvertView extends TabFragment implements IConvertView {

    private CustomSpinnerAdapter adapter;
    private IConvertPresenter presenter;
    private EditText editText;
    private TextView textView;

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

        presenter = new ConvertPresenter(this);

        initSpinner();

        editText = (EditText) view.findViewById(R.id.source_edit);
        textView = (TextView) view.findViewById(R.id.final_edit);
        Button button = (Button) view.findViewById(R.id.btn_ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setValueBaseCurrency(editText.getText().toString());
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initSpinner() {
        Spinner sourceSpinner = (Spinner) view.findViewById(R.id.source_spinner);
        sourceSpinner.setAdapter(adapter);
        sourceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                presenter.setBaseCurrency(position);
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
                presenter.setFinalCurrency(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void showMessage(@NonNull String message) {
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setMessage(message)
                .setPositiveButton(getActivity().getString(R.string.text_ok), null)
                .setCancelable(false)
                .create();
        dialog.show();
    }

    @Override
    public void refreshData(@NonNull List<CurrencyOld> data) {
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setResult(String value) {
        textView.setText(value);
    }
}
