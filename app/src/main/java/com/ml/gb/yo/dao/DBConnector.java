package com.ml.gb.yo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ml.gb.yo.pojo.Friend;

/**
 * Database accessor, note DBConnector should be static for the current user
 * that said this instance should be globally available and be switched when
 * another user logs in
 */
public class DBConnector {

    // DB name
    private static final String DB_PREFIX = "FRIEND_";

    private final String DB_NAME;

    private DBOpenHelper mDBOpenHelper;

    private SQLiteDatabase mDb;

    private long mId;

    public DBConnector(Context context, long userID) {
        mId = userID;
        DB_NAME = DB_PREFIX + mId;
        mDBOpenHelper = new DBOpenHelper(context, DB_NAME, null, 1);
    }

    private class DBOpenHelper extends SQLiteOpenHelper {

        public DBOpenHelper(Context context, String name,
                SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createDB = "CREATE TABLE IF NOT EXISTS " + DB_NAME
                    + " (id INTEGER primary key, name TEXT, count INTEGER);";
            db.execSQL(createDB);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //nothing
        }


    }

    public void open() {
        // create a R/W db
        mDb = mDBOpenHelper.getWritableDatabase();
    }

    public void close() {
        if (mDb != null) {
            mDb.close();
        }
    }


    // get friends for this user, return (id, name, count) ordered by count
    public Cursor getFriends() {
        return mDb.query(DB_NAME, new String[]{"id",
                "name", "count"}, null, null, null, null, "count");

    }

    // insert some debug data to db
    public void populateDebugData() {
        mDb.execSQL("insert or ignore into " + DB_NAME + " values(223342, \"mlgb1\", 123);");
        mDb.execSQL("insert or ignore into " + DB_NAME + " values(323342, \"mlgb2\", 11);");
        mDb.execSQL("insert or ignore into " + DB_NAME + " values(423342, \"mlgb3\", 3);");
        mDb.execSQL("insert or ignore into " + DB_NAME + " values(523342, \"mlgb4\", 5);");
        mDb.execSQL("insert or ignore into " + DB_NAME + " values(623342, \"mlgb5\", 2);");
    }

    // return how many yos the friend has sent to current user
    public int getYoCount(long friendId) {
        Cursor result = mDb
                .query(DB_NAME, new String[]{"count"}, "id=" + friendId, null, null, null, null);
        // Cursor starts before the first row, need to move to first
        result.moveToFirst();
        int ret = result.getInt(0);
        result.close();
        return ret;

    }

    // return all yos the current receives
    // this should be useless
    public int getTotalYoCount() {
        Cursor result = mDb
                .query(DB_NAME, new String[]{"count"}, null, null, null, null, null);
        int ret = 0;
        while (result.moveToNext()) {
            ret += result.getInt(0);
        }
        result.close();
        return ret;
    }

    // delete a friend
    // note this assumes the friend is already removed from server
    public void deleteFriend(long friendId) {
        open();
        mDb.delete(DB_NAME, "id=" + friendId, null);
        close();
    }

    // add a new friend for this user
    // note this assumes the data is already pulled from server
    public void addFriend(long friendId, String friendName, int yoCount) {
        ContentValues newFriend = new ContentValues();
        newFriend.put("id", friendId);
        newFriend.put("name", friendName);
        newFriend.put("count", yoCount);

        open();
        mDb.insert(DB_NAME, null, newFriend);
        close();
    }

    public void addFriend(Friend newFriend) {
        addFriend(newFriend.getId(), newFriend.getName(), newFriend.getYoCount());
    }

    public static final long TEST_USER_ID = 123456;

    public static final String TEST_USER_NAME = "MLGBBGLM";
}
