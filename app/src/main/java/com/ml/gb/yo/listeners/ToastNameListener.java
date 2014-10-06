package com.ml.gb.yo.listeners;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Toast the item string upon item click
 */
public class ToastNameListener implements AdapterView.OnItemClickListener {

    private Toast mToast;


    public ToastNameListener(Activity act) {
        mToast = Toast.makeText(act, "", Toast.LENGTH_LONG);
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
        mToast.setText((String) parent.getItemAtPosition(position));
        mToast.show();
    }
}
