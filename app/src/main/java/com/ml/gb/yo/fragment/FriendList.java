package com.ml.gb.yo.fragment;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import com.ml.gb.yo.R;
import com.ml.gb.yo.YoConstants;
import com.ml.gb.yo.listAdapter.RoundRobinColorListAdaptor;
import com.ml.gb.yo.listeners.FriendListListener;
import com.ml.gb.yo.listeners.ToastNameListener;

import java.util.LinkedList;
import java.util.List;

/**
 * Display all friend, click on a friend to send yos to friends
 * a plus button at bottom to add friend
 */
public class FriendList extends BaseList {

    private List<String> mFriendsItems;

    private String mUserName;

    private int mUserId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle param = getArguments();
        mUserName = param.getString(YoConstants.USER_NAME);
        mUserId = param.getInt(YoConstants.USER_ID);
        populateFriendsItems();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.friend_list, container, false);
    }

    private void populateFriendsItems() {
        mFriendsItems = new LinkedList<String>();
        // TODO: should instead get from DB
        mFriendsItems.add("m");
        mFriendsItems.add("l");
        mFriendsItems.add("g");
        mFriendsItems.add("b");
        mFriendsItems.add(mUserName);
        mFriendsItems.add("" + mUserId);
        mFriendsItems.add(YoConstants.PLUS);
    }


    @Override
    ListAdapter createListAdapter() {
        return new RoundRobinColorListAdaptor(mFriendsItems, getActivity());
    }

    @Override
    AdapterView.OnItemClickListener getItemClickListener() {
        return new FriendListListener(this);
    }

    private class loadFriendLists extends AsyncTask<Long, Object, Cursor> {

        @Override
        protected Cursor doInBackground(Long... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            super.onPostExecute(cursor);
        }
    }
}
