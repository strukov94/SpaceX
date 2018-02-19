package com.strukov.spacexlaunches.main.async;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.strukov.spacexlaunches.data.SpaceXDbHelper;

/**
 * Created by Matthew on 19.02.2018.
 */

public class CheckLaunch extends AsyncTask<String, Void, Boolean> {
    private SpaceXDbHelper mDb;

    public CheckLaunch(SpaceXDbHelper db) {
        mDb = db;
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        boolean exist = false;
        SQLiteDatabase database = mDb.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM launches WHERE year =? ORDER BY ROWID ASC LIMIT 1", new String[]{strings[0]});
        if (cursor.getCount() > 0) exist = true;
        cursor.close();
        database.close();
        return exist;
    }
}
