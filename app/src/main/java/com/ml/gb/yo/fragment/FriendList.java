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
import com.ml.gb.yo.dao.DBConnector;
import com.ml.gb.yo.listAdapter.RoundRobinColorListAdaptor;
import com.ml.gb.yo.listeners.FriendListListener;
import com.ml.gb.yo.pojo.Friend;

import java.util.LinkedList;
import java.util.List;

/**
 * Display all friend, click on a friend to send yos to friends
 * a plus button at bottom to add friend
 */
public class FriendList extends BaseList {

    private List<Friend> mFriendsItems = new LinkedList<Friend>();

    private String mUserName;

    private long mUserId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle param = getArguments();
        mUserName = param.getString(YoConstants.USER_NAME);
        mUserId = param.getLong(YoConstants.USER_ID);
        populateFriendsItems();
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().findViewById(R.id.menuButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.FragmentTransaction
                        transaction = getFragmentManager().beginTransaction();
                transaction
                        .setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_up);
                transaction.replace(R.id.container, new MenuList(mUserName, getYoCount()));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.friend_list, container, false);
    }

    private void populateFriendsItems() {
        Long[] params = {mUserId};
        new GetFriendsTask().execute(params);
    }

    private class GetFriendsTask extends AsyncTask<Long, Object, Cursor> {

        DBConnector dbc;

        @Override
        protected Cursor doInBackground(Long... params) {
            dbc = new DBConnector(getActivity(), params[0]);
            dbc.open();
            // TODO: remove this after we hook up to server
            dbc.populateDebugData();

            return dbc.getFriends();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            mFriendsItems.clear();
            // now cursor is (id, name, count)
            while (cursor.moveToNext()) {
                Friend newFriend = new Friend(cursor.getLong(0), cursor.getString(1),
                        cursor.getInt(2));
                mFriendsItems.add(newFriend);
            }
            ((RoundRobinColorListAdaptor) getListAdapter()).updateItems(getFriendListItems());
            dbc.close();
        }
    }


    public List<Friend> getFriendsItems() {
        return mFriendsItems;
    }

    @Override
    ListAdapter createListAdapter() {
        return new RoundRobinColorListAdaptor(getFriendListItems(), getActivity());
    }

    @Override
    AdapterView.OnItemClickListener getItemClickListener() {
        return new FriendListListener(this);
    }

    public void sendYo(long friendId) {
        // TODO: send to server

    }

    /**
     * Total Yo count
     */
    private int getYoCount() {
        int ret = 0;
        for (Friend f : mFriendsItems) {
            ret += f.getYoCount();
        }
        return ret;
    }

    /**
     * Convert Friend list into a String list for their names
     */
    private List<String> getFriendListItems() {
        List<String> ret = new LinkedList<String>();
        for (Friend f : mFriendsItems) {
            ret.add(f.getName());
        }
        ret.add(YoConstants.PLUS);
        return ret;
    }
}