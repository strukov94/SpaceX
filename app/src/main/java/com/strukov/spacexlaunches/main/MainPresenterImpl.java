package com.strukov.spacexlaunches.main;

import android.content.Intent;
import android.database.Cursor;

import com.strukov.spacexlaunches.SpaceXApp;
import com.strukov.spacexlaunches.constants.Constants;
import com.strukov.spacexlaunches.services.DownloadImages;
import com.strukov.spacexlaunches.services.DownloadSpaceXLaunch;
import com.strukov.spacexlaunches.utils.NetworkUtils;

/**
 * Created by Matthew on 17.02.2018.
 */

public class MainPresenterImpl implements MainPresenter {
    private MainActivity mView;
    private MainModelImpl mModel;
    private boolean isReceive = true;
    private Cursor mCursor;
    private String mYear;

    @Override
    public void onCreate(MainActivity view) {
        mView = view;
        mModel = new MainModelImpl(SpaceXApp.getApp(mView));
    }

    private void startDownloadService(String year) {
        Intent intent = new Intent(mView, DownloadSpaceXLaunch.class);
        intent.putExtra(Constants.LAUNCH_YEAR, year);
        mView.startService(intent);
    }

    private void startDownloadImagesService(String json) {
        Intent intent = new Intent(mView, DownloadImages.class);
        intent.putExtra(Constants.LAUNCH_IMAGES, json);
        mView.startService(intent);
    }

    @Override
    public boolean isExistLaunch(String year) {
        return mModel.isLaunchYearExist(year);
    }

    @Override
    public boolean updateLaunches(String year) {
        if (mCursor != null && mYear.equals(year)) {
            mView.swapAdapter(mCursor);
            return true;
        }

        mYear = year;

        if (isReceive) {
            isReceive = false;
            if (!isExistLaunch(year)) {
                return isNetworkAvailable(year);
            } else {
                if (year.equals("2018")) {
                    if (NetworkUtils.isNetworkAvailable(mView)) {
                        startDownloadService(year);
                        return true;
                    }
                }
                isReceive = true;
                mCursor = mModel.getCursorLaunches(year);
                mView.swapAdapter(mCursor);
            }
        }
        return true;
    }

    private boolean isNetworkAvailable(String year) {
        if (NetworkUtils.isNetworkAvailable(mView)) {
            startDownloadService(year);
            return true;
        } else {
            mView.onNetworkUnavailable();
            mCursor = null;
            isReceive = true;
            return false;
        }
    }

    @Override
    public void onReceive(String json) {
        mModel.insertLaunches(mModel.getLaunches(json));
        startDownloadImagesService(json);
        mCursor = mModel.getCursorLaunches(mYear);
        mView.swapAdapter(mCursor);
        isReceive = true;
    }

    @Override
    public void onDestroy() {
        mModel.onDestroy();
    }
}
