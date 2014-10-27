package com.ml.gb.yo.listeners;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.ml.gb.yo.R;
import com.ml.gb.yo.YoConstants;
import com.ml.gb.yo.fragment.BaseList;
import com.ml.gb.yo.fragment.FriendList;
import com.ml.gb.yo.fragment.MenuList;

/**
 * Created by ccen on 10/26/14.
 */
public class FriendListListener implements AdapterView.OnItemClickListener {

    private FriendList mFriendList;

    public FriendListListener(FriendList friendList) {
        mFriendList = friendList;
    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int addFriendIndex = parent.getCount() - 1;
        if (position == addFriendIndex) {
            Toast.makeText(mFriendList.getActivity(), "add new Friends", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mFriendList.getActivity(), "mlgb!", Toast.LENGTH_SHORT).show();
        }
    }
}
