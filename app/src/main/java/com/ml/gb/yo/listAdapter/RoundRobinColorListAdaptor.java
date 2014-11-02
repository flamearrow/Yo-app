package com.ml.gb.yo.listAdapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ml.gb.yo.R;
import com.ml.gb.yo.YoConstants;

import java.util.List;

/**
 * A list adaptor to display a list of String items in different background color.
 */
public class RoundRobinColorListAdaptor extends BaseAdapter {

    private String[] mItems;

    private Context mContext;


    private static int[] ITEM_COLORS = {Color.BLUE, Color.CYAN, Color.MAGENTA, Color.RED,
            Color.LTGRAY};


    public RoundRobinColorListAdaptor(String[] items, Context context) {
        mItems = items;
        mContext = context;
    }

    public RoundRobinColorListAdaptor(List<String> items, Context context) {
        updateItems(items);
        mContext = context;
    }

    public void updateItems(List<String> items) {
        String[] sItems = new String[items.size()];
        for (int i = 0; i < items.size(); i++) {
            sItems[i] = items.get(i);
        }
        mItems = sItems;
        // refresh the list
        notifyDataSetChanged();
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
