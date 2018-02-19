package com.strukov.spacexlaunches.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.strukov.spacexlaunches.constants.Constants;
import com.strukov.spacexlaunches.models.Launch;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Matthew on 19.02.2018.
 */

public class DownloadImages extends IntentService {

    public DownloadImages() {
        super("DownloadImages");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String json = intent.getStringExtra(Constants.LAUNCH_IMAGES);
        try {
            saveImages(json, getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveImages(String json, Context context) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Launch[] launches = gson.fromJson(json, Launch[].class);

        for(Launch launch : launches) {
            URL url = new URL(launch.getLinks().getMissionPatch());
            InputStream in = url.openStream();

            File directory = context.getDir("images", Context.MODE_PRIVATE);
            File path = new File(directory, String.valueOf(launch.getFlightNumber()) + ".png");

            FileOutputStream outputStream = new FileOutputStream(path);
            Bitmap bitmap = BitmapFactory.decodeStream(in);

            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

            outputStream.write(in.read());
            outputStream.close();
            in.close();
        }
    }
}
