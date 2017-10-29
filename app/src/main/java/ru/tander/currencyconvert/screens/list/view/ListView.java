package ru.tander.currencyconvert.screens.list.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.tander.currencyconvert.R;
import ru.tander.currencyconvert.TabFragment;
import ru.tander.currencyconvert.model.Currency;
import ru.tander.currencyconvert.screens.list.presenter.IListPresenter;
import ru.tander.currencyconvert.screens.list.presenter.ListPresenter;

public class ListView extends TabFragment implements IListView {

    private CurrencyListAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private IListPresenter presenter;
    private ProgressDialog progressDialog;

    public static ListView getInstance(Context context){
        Bundle bundle = new Bundle();
        ListView fragment = new ListView();
        fragment.setArguments(bundle);
        fragment.setTitle(context.getString(R.string.text_currency));
        fragment.context = context;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        context = getActivity();
        presenter = new ListPresenter(this);
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_currency, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_list_currency);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new CurrencyListAdapter(context);
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_list);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.onRefreshData();
            }
        });
        return view;
    }

    @Override
    public void dismissRefreshing() {
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showProgressDialog() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(R.string.text_dialog_load));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        if (progressDialog != null)
            progressDialog.dismiss();
    }

    @Override
    public void refreshData(@NonNull List<Currency> data) {
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }
}
