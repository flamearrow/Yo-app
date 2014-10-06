package com.ml.gb.yo.activity;

import android.graphics.Color;
import android.test.ActivityInstrumentationTestCase2;
import android.test.InstrumentationTestCase;
import android.test.UiThreadTest;

import com.ml.gb.yo.R;
import com.ml.gb.yo.toyView.ChangeTextColorTextView;

/**
 * Created by ccen on 9/29/14.
 */
public class ChangeTextColorInstrumentTest
        extends ActivityInstrumentationTestCase2<ChangeTextColorActivity> {

    ChangeTextColorTextView ctv;

    public ChangeTextColorInstrumentTest() {
        super(ChangeTextColorActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // now the activity should already be up
        ctv = (ChangeTextColorTextView) getActivity().findViewById(R.id.changeTextColorTV);
    }

    // force it on Ui thread
    @UiThreadTest
    public void testColorChangeWorks() {
        // we might still get npe here since ctv is initialized in non-ui thread
        // and this piece of code is running on ui thread
        // Espresso could avoid that
        ctv.setTextBounded("12345");
        assertEquals(Color.GREEN, ctv.getTextColors().getDefaultColor());
        ctv.setTextBounded("123451234512345");
        assertEquals(Color.YELLOW, ctv.getTextColors().getDefaultColor());
        ctv.setTextBounded("123451234512345123451234512345123451234512345");
        assertEquals(Color.RED
                , ctv.getTextColors().getDefaultColor());
    }
}
