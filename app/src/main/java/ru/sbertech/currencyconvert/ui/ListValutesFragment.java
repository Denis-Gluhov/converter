package ru.sbertech.currencyconvert.ui;

import android.arch.lifecycle.ViewModelProviders;
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
import ru.sbertech.currencyconvert.repository.ValuteInfo;

public class ListValutesFragment extends TabFragment {

    private SwipeRefreshLayout swipeRefreshLayout;
    private ValutesListAdapter adapter;

    private ValutesActivityViewModel viewModel;

    public static ListValutesFragment getInstance(Context context){
        Bundle bundle = new Bundle();
        ListValutesFragment fragment = new ListValutesFragment();
        fragment.setArguments(bundle);
        fragment.setTitle(context.getString(R.string.text_currency));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_currency, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_list_currency);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ValutesListAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout = view.findViewById(R.id.refresh_list);
        swipeRefreshLayout.setOnRefreshListener(() -> loadData());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(ValutesActivityViewModel.class);
        loadData();
    }

    private void loadData() {
        swipeRefreshLayout.setRefreshing(true);
        viewModel.getListValutes().observe(this, data -> setData(data));
    }

    private void setData(@NonNull List<ValuteInfo> data) {
        adapter.setData(data);
        adapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    protected void setupFragmentComponent() {

    }
}
