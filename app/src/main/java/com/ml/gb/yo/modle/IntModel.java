package com.ml.gb.yo.modle;

/**
 * Created by ccen on 9/29/14.
 */
public class IntModel {
    private int mInt;
    public IntModel() {
        mInt = 0;
    }

    public int getInt() {
        return mInt;
    }

    public void setInt(int i) {
        mInt = i;
    }

    public void increment() {
        mInt++;
    }

    public void reset() {
        mInt = 0;
    }

}
