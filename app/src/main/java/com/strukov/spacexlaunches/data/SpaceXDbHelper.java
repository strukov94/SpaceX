package com.strukov.spacexlaunches.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.strukov.spacexlaunches.data.SpaceXContract.*;

/**
 * Created by Matthew on 19.02.2018.
 */

public class SpaceXDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "spacex.db";
    private static final int DATABASE_VERSION = 1;

    public SpaceXDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_LAUNCHES_TABLE = "CREATE TABLE " + LaunchesEntry.TABLE_NAME + " (" +
                LaunchesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LaunchesEntry.YEAR + " INTEGER NOT NULL, " +
                LaunchesEntry.DATE + " INTEGER NOT NULL, " +
                LaunchesEntry.ROCKET_NAME + " TEXT NOT NULL, " +
                LaunchesEntry.DETAILS + " TEXT, " +
                LaunchesEntry.IMAGE + " TEXT NOT NULL UNIQUE, " +
                LaunchesEntry.IMAGE_URL + " TEXT NOT NULL, " +
                LaunchesEntry.ARTICLE_LINK + " TEXT NOT NULL, " +
                LaunchesEntry.VIDEO_LINK + " TEXT NOT NULL)";

        sqLiteDatabase.execSQL(CREATE_LAUNCHES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + LaunchesEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
