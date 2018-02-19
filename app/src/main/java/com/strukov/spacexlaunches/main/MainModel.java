package com.strukov.spacexlaunches.main;

import android.database.Cursor;

import com.strukov.spacexlaunches.models.Launch;


/**
 * Created by Matthew on 17.02.2018.
 */

public interface MainModel {
    Launch[] getLaunches(String json);
    boolean isLaunchYearExist(String year);
    void insertLaunches(Launch[] launches);
    Cursor getCursorLaunches(String year);
    void onDestroy();
}
