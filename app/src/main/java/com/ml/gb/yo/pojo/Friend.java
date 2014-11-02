package com.ml.gb.yo.pojo;

public class Friend {

    private final String mName;

    private final long mId;

    private int mYoCount;

    public Friend(long id, String name, int count) {
        mName = name;
        mId = id;
        mYoCount = count;
    }

    public Friend(long id, String name) {
        this(id, name, 0);
    }

    public long getId() {
        return mId;
    }

    public int getYoCount() {
        return mYoCount;
    }

    public void setYoCount(int yoCount) {
        mYoCount = yoCount;
    }

    public String getName() {
        return mName;
    }
}
