package com.ml.gb.yo.fragment;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListAdapter;

/**
 * Display all friend, click on a friend to send yos to friends
 * a plus button at bottom to add friend
 */
public class FriendList extends BaseList {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    ListAdapter createListAdapter() {
        return null;
    }

    @Override
    AdapterView.OnItemClickListener getItemClickListener() {
        return null;
    }
}
