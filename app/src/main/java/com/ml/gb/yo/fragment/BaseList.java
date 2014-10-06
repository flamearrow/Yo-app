package com.ml.gb.yo.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by ccen on 9/28/14.
 */
public abstract class BaseList extends ListFragment {
    private ListView listView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // set List layout/style to predefined yo style

        // initialize listView
        listView = getListView();
        listView.setOnItemClickListener(getItemClickListener());
        setListAdapter(createListAdapter());
        // without this, items won't be focusable and thus can change color
        getListView().setItemsCanFocus(true);

    }

    abstract ListAdapter createListAdapter();

    abstract AdapterView.OnItemClickListener getItemClickListener();
}
