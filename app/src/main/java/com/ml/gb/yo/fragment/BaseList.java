package com.ml.gb.yo.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ml.gb.yo.widget.YoColor;

/**
 * Base list fragment for configuring list adaptors, itemclick listeners for all lists
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
        getListView().setBackgroundColor(YoColor.PURPLE);
        setListAdapter(createListAdapter());
        // without this, items won't be focusable or change color
        getListView().setItemsCanFocus(true);
    }

    abstract ListAdapter createListAdapter();

    abstract AdapterView.OnItemClickListener getItemClickListener();

}
