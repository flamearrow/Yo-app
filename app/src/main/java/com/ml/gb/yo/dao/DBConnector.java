package com.ml.gb.yo.dao;

import android.database.Cursor;

/**
 * Database accessor, note DBConnector should be static for the current user
 * that said this instance should be globally available and be switched when
 * another user logs in
 */
public class DBConnector {
    private long mId;
    public DBConnector(long currentUserId) {
        mId = currentUserId;
    }
    // get friends for this user
    public Cursor getFriends() {
        return null;
    }

    public int getYoCount(long friendId) {
        return 0;
    }

    public void addFriend(long friendId) {

    }

    public int getTotalYoCount() {
        return 0;
    }
}
