package com.ml.gb.yo.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.ml.gb.yo.R;

/**
 * whoami, configs, yos
 */
public class MenuList extends BaseList {

    private String[] menuItems = {"MY NAME", "FIND FRIENDS", "EDIT PROFILE", "YO'S ###", "BACK",
            "1", "2", "3"};

    @Override
    ListAdapter createListAdapter() {
        return new MenuAdaptor(menuItems, getActivity());
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
        return new AdapterView.OnItemClickListener() {
            Toast mToast = Toast.makeText(getActivity(), "", Toast.LENGTH_LONG);

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mToast.setText(menuItems[position]);
                mToast.show();
            }
        };
    }
}

class MenuAdaptor extends BaseAdapter {

    private String[] mItems;

    private Context mContext;


    private static int[] ITEM_COLORS = {Color.BLUE, Color.CYAN, Color.MAGENTA, Color.RED,
            Color.LTGRAY};


    public MenuAdaptor(String[] items, Context context) {
        mItems = items;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mItems.length;
    }

    @Override
    public Object getItem(int position) {
        return mItems[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.base_list_item, parent, false);
        }
        convertView.setBackgroundColor(ITEM_COLORS[position % ITEM_COLORS.length]);
        ((TextView) convertView).setText(mItems[position]);
        return convertView;
    }
}