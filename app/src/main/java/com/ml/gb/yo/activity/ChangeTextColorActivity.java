package com.ml.gb.yo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ml.gb.yo.R;
import com.ml.gb.yo.toyView.ChangeTextColorTextView;

/**
 * Created by ccen on 9/29/14.
 */
public class ChangeTextColorActivity extends Activity {
    ChangeTextColorTextView tv;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_text_color_layout);
        tv = (ChangeTextColorTextView) findViewById(R.id.changeTextColorTV);
        et = (EditText) findViewById(R.id.editText);

    }

    public void setText(CharSequence text) {
        tv.setTextBounded(text);
    }

    public void setTextFromField(View view) {
        tv.setTextBounded(et.getText());
    }
}
