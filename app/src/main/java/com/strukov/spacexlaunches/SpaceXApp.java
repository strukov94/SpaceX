package com.strukov.spacexlaunches;

import android.app.Application;
import android.content.Context;

import com.strukov.spacexlaunches.main.MainPresenter;
import com.strukov.spacexlaunches.main.MainPresenterImpl;

/**
 * Created by Matthew on 17.02.2018.
 */

public class SpaceXApp extends Application {
    private static MainPresenter sMainPresenter;

    public static SpaceXApp getApp(Context context) {
        return (SpaceXApp) context.getApplicationContext();
    }

    public MainPresenter getMainPresenter() {
        if (sMainPresenter == null) {
            sMainPresenter = new MainPresenterImpl();

        }
        return sMainPresenter;
    }

    public void releaseMainPresenter() {
        sMainPresenter = null;
    }
}
