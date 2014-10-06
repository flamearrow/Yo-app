package com.ml.gb.yo.activity;

import android.util.Log;

import com.ml.gb.yo.modle.IntModel;

import junit.framework.TestCase;

/**
 * Created by ccen on 9/29/14.
 */
public class IntModelTest extends TestCase {

    private IntModel m;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        m = new IntModel();
    }

    public void testIncrement() {
        Log.d("test running on thread: ", Thread.currentThread().getName());
        m.reset();
        assertEquals(0, m.getInt());
//        m.increment();
//        assertEquals(1, m.getInt());
//        m.increment();
//        assertEquals(2, m.getInt());
    }

}
