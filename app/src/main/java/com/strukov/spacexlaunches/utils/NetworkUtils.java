package com.strukov.spacexlaunches.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Matthew on 17.02.2018.
 */

public class NetworkUtils {

    public static void responseError(int code){
            Log.v("RESPONSE_ERROR", String.format("Error code: %d", code));
    }

    public static String getJson(URL url) {
        HttpsURLConnection connection = null;
        Scanner scanner = null;
        InputStream in = null;
        String json = null;

        try {
            connection = (HttpsURLConnection) url.openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpsURLConnection.HTTP_OK) {
                responseError(responseCode);
            }

            in = connection.getInputStream();
            scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            if (scanner.hasNext()) json = scanner.next();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) scanner.close();
            if (connection != null) connection.disconnect();
            if (in != null) try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return json;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) return false;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
