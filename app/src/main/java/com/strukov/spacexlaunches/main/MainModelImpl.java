package com.strukov.spacexlaunches.main;

import android.content.Context;
import android.database.Cursor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.strukov.spacexlaunches.data.SpaceXDbHelper;
import com.strukov.spacexlaunches.main.async.CheckLaunch;
import com.strukov.spacexlaunches.main.async.InsertLaunches;
import com.strukov.spacexlaunches.main.async.SelectLaunches;
import com.strukov.spacexlaunches.models.Launch;

import java.util.concurrent.ExecutionException;

/**
 * Created by Matthew on 17.02.2018.
 */

public class MainModelImpl implements MainModel {
    private Context mContext;
    private SpaceXDbHelper mDb;

    MainModelImpl(Context context) {
        mContext = context;
        mDb = new SpaceXDbHelper(mContext);
    }

    @Override
    public Launch[] getLaunches(String json) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.fromJson(json, Launch[].class);
    }

    @Override
    public boolean isLaunchYearExist(String year) {
        try {
            return new CheckLaunch(mDb).execute(year).get();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void insertLaunches(Launch[] launches) {
        new InsertLaunches(mDb).execute(launches);
    }

    @Override
    public Cursor getCursorLaunches(String year) {
        try {
            return new SelectLaunches(mDb).execute(year).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onDestroy() {
        mDb.close();
    }
}