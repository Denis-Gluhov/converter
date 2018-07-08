package ru.sbertech.currencyconvert.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import ru.sbertech.currencyconvert.R;

public class ConvertValutesFragment extends TabFragment {

    private CustomSpinnerAdapter adapter;
    private EditText editText;
    private TextView textView;

    public static ConvertValutesFragment getInstance(Context context){
        Bundle bundle = new Bundle();
        ConvertValutesFragment fragment = new ConvertValutesFragment();
        fragment.setArguments(bundle);
        fragment.setTitle(context.getString(R.string.text_converter));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_convert_currency, container, false);
        adapter = new CustomSpinnerAdapter(getActivity());

        initSpinner();

        editText = view.findViewById(R.id.source_edit);
        textView = view.findViewById(R.id.final_edit);
        Button button = view.findViewById(R.id.btn_ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setupFragmentComponent() {

    }

    private void initSpinner() {
        Spinner sourceSpinner = view.findViewById(R.id.source_spinner);
        sourceSpinner.setAdapter(adapter);
        sourceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner finalSpinner = view.findViewById(R.id.final_spinner);
        finalSpinner.setAdapter(adapter);
        finalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
