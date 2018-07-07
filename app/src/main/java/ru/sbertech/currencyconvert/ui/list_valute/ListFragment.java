package ru.sbertech.currencyconvert.ui.list_valute;

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

import javax.inject.Inject;

import ru.sbertech.currencyconvert.App;
import ru.sbertech.currencyconvert.R;
import ru.sbertech.currencyconvert.ui.TabFragment;
import ru.sbertech.currencyconvert.model.Valute;

public class ListFragment extends TabFragment implements ListContract.View {

    @Inject
    ListContract.Presenter presenter;

    private SwipeRefreshLayout swipeRefreshLayout;
    private CurrencyListAdapter adapter;

    public static ListFragment getInstance(Context context){
        Bundle bundle = new Bundle();
        ListFragment fragment = new ListFragment();
        fragment.setArguments(bundle);
        fragment.setTitle(context.getString(R.string.text_currency));
        return fragment;
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
        swipeRefreshLayout.setOnRefreshListener(() -> presenter.loadData());
        presenter.loadData();
        return view;
    }

    @Override
    protected void setupFragmentComponent() {
        App.getInstance().initListFragmentComponent(this).inject(this);
    }

    @Override
    public void dismissRefreshing() {
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setData(@NonNull List<Valute> data) {
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }
}
