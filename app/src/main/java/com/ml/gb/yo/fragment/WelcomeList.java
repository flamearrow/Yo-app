package com.ml.gb.yo.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.ml.gb.yo.R;
import com.ml.gb.yo.YoConstants;
import com.ml.gb.yo.dao.DBConnector;
import com.ml.gb.yo.listAdapter.RoundRobinColorListAdaptor;

/**
 * Prompt for signing in /signing up
 */
public class WelcomeList extends BaseList {

    private String[] mWelcomeItems = {"SIGN IN", "SIGN UP"};

    @Override
    ListAdapter createListAdapter() {
        return new RoundRobinColorListAdaptor(mWelcomeItems, getActivity());
    }

    @Override
    AdapterView.OnItemClickListener getItemClickListener() {
        return new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    // SIGN IN
                    case 0:
                        android.support.v4.app.FragmentTransaction
                                transaction = getFragmentManager().beginTransaction();
                        transaction
                                .setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_bottom);
                        // TODO: handle real sign in logic
                        // Now use fake identity
                        BaseList friendList = new FriendList();
                        Bundle userIdentity = new Bundle();
                        userIdentity.putString(YoConstants.USER_NAME, DBConnector.TEST_USER_NAME);
                        userIdentity.putLong(YoConstants.USER_ID, DBConnector.TEST_USER_ID);
                        friendList.setArguments(userIdentity);
                        transaction.replace(R.id.container, friendList);
                        // don't return back, go to home screen instead
                        // transaction.addToBackStack(null);
                        transaction.commit();
                        break;
                    // SIGN UP
                    case 1:
                        Toast.makeText(getActivity(), mWelcomeItems[1], Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };
    }
}
