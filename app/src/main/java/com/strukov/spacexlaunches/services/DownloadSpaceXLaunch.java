package com.strukov.spacexlaunches.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

import com.strukov.spacexlaunches.constants.Constants;
import com.strukov.spacexlaunches.utils.NetworkUtils;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Matthew on 17.02.2018.
 */

public class DownloadSpaceXLaunch extends IntentService {
    public DownloadSpaceXLaunch() {
        super("DownloadSpaceXLaunch");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        URL url;
        String year = intent != null ? intent.getStringExtra(Constants.LAUNCH_YEAR) : "2018";
        try {
            url = new URL("https://api.spacexdata.com/v2/launches?launch_year=" + year);
            String json = NetworkUtils.getJson(url);

            Intent jsonIntent = new Intent(Constants.BROADCAST_ACTION)
                    .putExtra(Constants.EXTENDED_JSON, json);
            LocalBroadcastManager.getInstance(this).sendBroadcast(jsonIntent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
