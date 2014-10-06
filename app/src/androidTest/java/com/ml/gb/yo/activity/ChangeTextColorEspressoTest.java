package com.ml.gb.yo.activity;

import android.graphics.Color;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.ml.gb.yo.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.closeSoftKeyboard;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;

/**
 * Created by ccen on 9/30/14.
 */
public class ChangeTextColorEspressoTest
        extends ActivityInstrumentationTestCase2<ChangeTextColorActivity> {

    private ChangeTextColorActivity act;

    public ChangeTextColorEspressoTest() {
        super(ChangeTextColorActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        act = getActivity();
    }

    public void testChangeTextColorShort() {
        onView(withId(R.id.editText))
                .perform(typeText("green"), closeSoftKeyboard());
        onView(withId(R.id.setTextButton)).perform(click());
        TextView tv = (TextView) act.findViewById(R.id.changeTextColorTV);
        assertEquals(Color.GREEN, tv.getTextColors().getDefaultColor());
    }


    public void testChangeTextColorMiddle() {
        onView(withId(R.id.editText))
                .perform(typeText("mid length,yellow"),
                        closeSoftKeyboard());
        onView(withId(R.id.setTextButton)).perform(click());
        TextView tv = (TextView) act.findViewById(R.id.changeTextColorTV);
        assertEquals(Color.YELLOW, tv.getTextColors().getDefaultColor());
    }


    public void testChangeTextColorLong() {
        onView(withId(R.id.editText))
                .perform(typeText(
                                "this is a message that's really long, it should be yellow and "
                                        + "should be truncated to length 30. This is a little "
                                        + "shitty tail that makes it longer "
                                        + "than 30 characters long."),
                        closeSoftKeyboard());
        onView(withId(R.id.setTextButton)).perform(click());
        TextView tv = (TextView) act.findViewById(R.id.changeTextColorTV);
        assertEquals(Color.RED, tv.getTextColors().getDefaultColor());
        assertEquals(tv.getText().length(), 30);
    }
}
