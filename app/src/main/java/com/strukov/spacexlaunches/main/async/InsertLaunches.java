package com.strukov.spacexlaunches.main.async;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.strukov.spacexlaunches.data.SpaceXDbHelper;
import com.strukov.spacexlaunches.models.Launch;


import static com.strukov.spacexlaunches.data.SpaceXContract.*;

/**
 * Created by Matthew on 19.02.2018.
 */

public class InsertLaunches extends AsyncTask<Launch, Void, Void> {
    private SpaceXDbHelper mDb;

    public InsertLaunches(SpaceXDbHelper db) {
        mDb = db;
    }

    @Override
    protected Void doInBackground(Launch... arrayLists) {
        SQLiteDatabase database = mDb.getWritableDatabase();

        database.beginTransaction();

        try{
            for (Launch launch : arrayLists) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(LaunchesEntry.YEAR, launch.getLaunchYear());
                contentValues.put(LaunchesEntry.DATE, launch.getLaunchDateUnix());
                contentValues.put(LaunchesEntry.ROCKET_NAME, launch.getRocket().getRocketName());
                contentValues.put(LaunchesEntry.DETAILS, launch.getDetails());
                contentValues.put(LaunchesEntry.ARTICLE_LINK, launch.getLinks().getArticleLink());
                contentValues.put(LaunchesEntry.VIDEO_LINK, launch.getLinks().getVideoLink());
                contentValues.put(LaunchesEntry.IMAGE, launch.getFlightNumber());
                contentValues.put(LaunchesEntry.IMAGE_URL, launch.getLinks().getMissionPatch());
                database.insert(LaunchesEntry.TABLE_NAME, null, contentValues);
            }
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        database.close();

        return null;
    }
}
