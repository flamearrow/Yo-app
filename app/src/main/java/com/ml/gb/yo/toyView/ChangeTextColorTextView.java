package com.ml.gb.yo.toyView;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by ccen on 9/29/14.
 */
public class ChangeTextColorTextView extends TextView{

    public ChangeTextColorTextView(Context context) {
        super(context);
    }

    public ChangeTextColorTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChangeTextColorTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setTextBounded(CharSequence text) {
        super.setText(text);
        if(text.length() < 10)
            setTextColor(Color.GREEN);
        else if (text.length() < 20)
            setTextColor(Color.YELLOW);
        else {
            if(text.length() > 30)
                text = text.subSequence(0, 30);
            super.setText(text);
            setTextColor(Color.RED);
        }
    }
}
