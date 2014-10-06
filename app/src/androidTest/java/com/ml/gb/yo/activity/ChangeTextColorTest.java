package com.ml.gb.yo.activity;

import android.graphics.Color;
import android.test.AndroidTestCase;

import com.ml.gb.yo.toyView.ChangeTextColorTextView;

/**
 * Created by ccen on 9/29/14.
 */
public class ChangeTextColorTest extends AndroidTestCase {
    private ChangeTextColorTextView ctv;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // this will be created on a non-ui thread
        ctv = new ChangeTextColorTextView(getContext());
    }

    public void testColorChangeWorks() {
        ctv.setTextBounded("12345");
        assertEquals(Color.GREEN, ctv.getTextColors().getDefaultColor());
        ctv.setTextBounded("123451234512345");
        assertEquals(Color.YELLOW, ctv.getTextColors().getDefaultColor());
        ctv.setTextBounded("123451234512345123451234512345123451234512345");
        assertEquals(Color.RED
                , ctv.getTextColors().getDefaultColor());
    }
}
