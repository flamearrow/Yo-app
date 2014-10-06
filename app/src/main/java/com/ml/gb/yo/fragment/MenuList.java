package com.ml.gb.yo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import com.ml.gb.yo.R;
import com.ml.gb.yo.listAdapter.RoundRobinColorListAdaptor;
import com.ml.gb.yo.listeners.ToastNameListener;

/**
 * whoami, configs, yos
 */
public class MenuList extends BaseList {

    private String[] menuItems = {"MY NAME", "FIND FRIENDS", "EDIT PROFILE", "YO'S ###", "BACK",
            "1", "2", "3"};

    @Override
    ListAdapter createListAdapter() {
        return new RoundRobinColorListAdaptor(menuItems, getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // need to update YO's count here
    }

    @Override
    AdapterView.OnItemClickListener getItemClickListener() {
        return new ToastNameListener(getActivity());
    }
}