package com.ml.gb.yo.listeners;

import android.view.View;
import android.widget.EditText;

import com.ml.gb.yo.YoConstants;
import com.ml.gb.yo.fragment.FriendList;
import com.ml.gb.yo.pojo.Friend;

import java.util.Random;

/**
 * The OnFocusChangedListener for plus '+' button in friend list
 */
public class AddFriendOnFocusChangedListener implements View.OnFocusChangeListener {
    private EditText mEt;
    private FriendList mFl;
    public AddFriendOnFocusChangedListener(EditText et, FriendList fl) {
        mEt = et;
        mFl = fl;

    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        // + clicked
        if(hasFocus) {
            mEt.setText(YoConstants.EMPTY_STRING);
        }
        else{
            String newFriendName = mEt.getText().toString();
            if(newFriendName.equals(YoConstants.EMPTY_STRING)) {
                mEt.setText(YoConstants.PLUS);
            } else {
                // TODO: this is debug data, need to pull read data from server
                Random rand = new Random();
                // hopefully they don't collide...
                long id = rand.nextInt(1000000);
                int yoCount = rand.nextInt(50);
                Friend newFriend = new Friend(id, newFriendName, yoCount);
                mFl.appendFriend(newFriend);
            }
        }
    }
}
