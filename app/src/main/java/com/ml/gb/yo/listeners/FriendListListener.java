package com.ml.gb.yo.listeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.ml.gb.yo.fragment.FriendList;

public class FriendListListener implements AdapterView.OnItemClickListener {

    private FriendList mFriendList;

    public FriendListListener(FriendList friendList) {
        mFriendList = friendList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        long mUserId = mFriendList.getFriendsItems().get(position).getId();
        String mUserName = mFriendList.getFriendsItems().get(position).getName();
        int yoCount = mFriendList.getFriendsItems().get(position).getYoCount();
        mFriendList.sendYo(mUserId);
        Toast.makeText(mFriendList.getActivity(),
                "User name: " + mUserName + " User ID: " + mUserId + " Yo Count: " + yoCount,
                Toast.LENGTH_SHORT).show();
    }
}
