package com.ml.gb.yo.fragment;

import android.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.ml.gb.yo.R;
import com.ml.gb.yo.listAdapter.RoundRobinColorListAdaptor;
import com.ml.gb.yo.listeners.ToastNameListener;

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
                        transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_bottom);
                        transaction.replace(R.id.container, new MenuList());
                        // don't return back, go to home screen instead
//                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;
                    case 1:
                        Toast.makeText(getActivity(), mWelcomeItems[1], Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };
    }
}
