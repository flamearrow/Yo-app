package com.ml.gb.yo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import com.ml.gb.yo.R;
import com.ml.gb.yo.YoConstants;
import com.ml.gb.yo.listAdapter.RoundRobinColorListAdaptor;
import com.ml.gb.yo.listeners.ToastNameListener;

import java.util.LinkedList;
import java.util.List;

/**
 * whoami, configs, yos
 */
public class MenuList extends BaseList {

    private String mName;

    private int mYoCount;

    private List<String> mMenuItems;

    public MenuList(String myName, int yoCount) {
        mName = myName;
        mYoCount = yoCount;
        mMenuItems = new LinkedList<String>();
        mMenuItems.add(myName);
        mMenuItems.add(YoConstants.FIND_FRIEND);
        mMenuItems.add(YoConstants.EDIT_PROFILE);
        mMenuItems.add(YoConstants.YO_COUNT + yoCount);
        mMenuItems.add(YoConstants.BACK);
    }

    @Override
    ListAdapter createListAdapter() {
        return new RoundRobinColorListAdaptor(mMenuItems, getActivity());
    }

    @Override
    AdapterView.OnItemClickListener getItemClickListener() {
        return new ToastNameListener(getActivity());
    }
}