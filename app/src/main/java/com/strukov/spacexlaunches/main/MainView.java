package com.strukov.spacexlaunches.main;

import android.database.Cursor;


/**
 * Created by Matthew on 17.02.2018.
 */

public interface MainView {
    void swapAdapter(Cursor launches);
    void onNetworkUnavailable();
}
