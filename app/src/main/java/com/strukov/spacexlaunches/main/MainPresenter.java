package com.strukov.spacexlaunches.main;

/**
 * Created by Matthew on 17.02.2018.
 */

public interface MainPresenter {
    void onCreate(MainActivity view);
    void onDestroy();
    void onReceive(String json);
    boolean updateLaunches(String year);
    boolean isExistLaunch(String year);
}
