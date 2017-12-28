package ru.sbertech.currencyconvert.list_valute;

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

import ru.sbertech.currencyconvert.R;
import ru.sbertech.currencyconvert.TabFragment;

public class ListFragment extends TabFragment implements IListView {

    private CurrencyListAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private IListPresenter presenter;
    private ProgressDialog progressDialog;

    public static ListFragment getInstance(Context context){
        Bundle bundle = new Bundle();
        ListFragment fragment = new ListFragment();
        fragment.setArguments(bundle);
        fragment.setTitle(context.getString(R.string.text_currency));
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_currency, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_list_currency);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CurrencyListAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_list);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.onRefreshData();
            }
        });
        presenter = new ListPresenter(this);
        return view;
    }

    @Override
    public void dismissRefreshing() {
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showProgressDialog() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(getActivity().getString(R.string.text_dialog_load));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        if (progressDialog != null)
            progressDialog.dismiss();
    }

    @Override
    public void refreshData(@NonNull List<CurrencyOld> data) {
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }
}
