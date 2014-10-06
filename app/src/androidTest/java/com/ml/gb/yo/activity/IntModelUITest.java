package com.ml.gb.yo.activity;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityTestCase;
import android.test.ActivityUnitTestCase;
import android.test.InstrumentationTestCase;
import android.test.UiThreadTest;

import com.ml.gb.yo.activity.CounterActivity;
import com.ml.gb.yo.modle.IntModel;

/**
 * Created by ccen on 9/29/14.
 */
public class IntModelUITest extends ActivityUnitTestCase<CounterActivity> {
    public IntModelUITest() {
        super(CounterActivity.class);
    }
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @UiThreadTest
    public void testIntModel() {
        Instrumentation instr = getInstrumentation();
        startActivity(new Intent(instr.getTargetContext(), CounterActivity.class), null, null);
        CounterActivity act = getActivity();
        act.getModel().increment();
        assertEquals(1, act.getModel().getInt());
        Bundle state = new Bundle();
        instr.callActivityOnSaveInstanceState(act, state);
        instr.callActivityOnCreate(act, state);
        assertEquals(1, act.getModel().getInt());
    }
}
