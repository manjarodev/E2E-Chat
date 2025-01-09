package com.devbeans.io.chat.utils;

import android.util.Log;

import com.devbeans.io.chat.R;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Pattern;

/**
 * Created by Basit on 10/7/2022.
 */

public class Logger {

    public static String EXCEPTION = "EXCEPTION";
    public static Pattern DELIMITER = Pattern.compile("XYZ.123");

    public static void log(final String TAG, final String MSG) {
        if (TAG != null && MSG != null) {
        }
    }

    public static void log(final String MSG) {
        if (MSG != null) {
            Log.d("com.dryvecars.dryve", MSG);
            //Log.d(MainApplication.getAppContext().getString(R.string.app_name), MSG);
        }
    }

    public static void log(final String TAG, final Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        log(TAG, sw.toString());
    }

    public static void log(final String TAG, final Throwable e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        log(TAG, sw.toString());
    }


    public static long fileSize() {
        File file = new File(getFilePath());
        if (file.exists()) {
            long sizeInBytes = file.length();
            long sizeInMb = sizeInBytes / (1024 * 1024);
            return sizeInMb;
        }
        return 0;
    }

    public static String getFilePath() {
        return FilesIO.getAppInternalFolderPath() + "/" + Utills.INSTANCE.getString(R.string.app_name) + "_logs.txt";
    }

    public static void clearLogs() {
        String directory = FilesIO.getAppInternalFolderPath();
        File file = new File(directory, Utills.INSTANCE.getString(R.string.app_name) + "_logs.txt");
        Utills.INSTANCE.handleFileDelete("Logger", file.delete());
    }

    public static String readException(Exception e) {
        if (e != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return sw.toString();
        } else {
            return "Error not found";
        }
    }

    public static String readException(Throwable e) {
        if (e != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return sw.toString();
        } else {
            return "Error Not Found";
        }
    }
}
