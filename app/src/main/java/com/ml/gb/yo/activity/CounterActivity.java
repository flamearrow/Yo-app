package com.ml.gb.yo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ml.gb.yo.R;
import com.ml.gb.yo.modle.IntModel;

/**
 * Created by ccen on 9/29/14.
 */
public class CounterActivity extends Activity {
    public static String VALUE = "value";
    private IntModel m;
    // package level access on purpose
    IntModel getModel() {
        return m;
    }
    private TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter_layout);
        if(m == null) {
            m = new IntModel();
        }

        if(savedInstanceState != null && savedInstanceState.containsKey(VALUE)) {
            m.setInt(savedInstanceState.getInt(VALUE));
        }
        if(t == null) {
            t = (TextView) findViewById(R.id.countText);
        }
        t.setText(""+m.getInt());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(VALUE, m.getInt());
        super.onSaveInstanceState(outState);
    }

    public void increment(View view) {
        m.increment();
        t.setText(""+m.getInt());
    }
}
