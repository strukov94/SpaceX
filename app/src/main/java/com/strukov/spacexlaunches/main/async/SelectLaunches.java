package com.strukov.spacexlaunches.main.async;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.strukov.spacexlaunches.data.SpaceXDbHelper;

/**
 * Created by Matthew on 19.02.2018.
 */

public class SelectLaunches extends AsyncTask<String, Void, Cursor> {

    private SpaceXDbHelper mDb;

    public SelectLaunches(SpaceXDbHelper db) {
        mDb = db;
    }

    @Override
    protected Cursor doInBackground(String... strings) {
        SQLiteDatabase database = mDb.getReadableDatabase();
        return database.rawQuery("SELECT * FROM launches WHERE year =? ORDER BY date DESC", new String[]{strings[0]});
    }

    @Override
    protected void onPostExecute(Cursor cursor) {
        super.onPostExecute(cursor);
    }
}
