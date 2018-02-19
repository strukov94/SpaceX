package com.strukov.spacexlaunches.data;

import android.provider.BaseColumns;

/**
 * Created by Matthew on 19.02.2018.
 */

public class SpaceXContract {
    public static final class LaunchesEntry implements BaseColumns {
        public static final String TABLE_NAME = "launches";
        public static final String YEAR = "year";
        public static final String DATE = "date";
        public static final String ROCKET_NAME = "rocket_name";
        public static final String IMAGE = "image";
        public static final String IMAGE_URL = "image_url";
        public static final String DETAILS = "details";
        public static final String ARTICLE_LINK = "article_link";
        public static final String VIDEO_LINK = "video_link";
    }
}
