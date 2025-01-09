package com.devbeans.io.chat.utils.metadata;

import android.util.Log;

import com.devbeans.io.chat.app.MainApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExifTool {

    public static final String TAG = ExifTool.class.getSimpleName();
    private static ExifTool instance = null;
    private final String exifPath = MainApp.Companion.getAppContext().getFilesDir().getAbsolutePath().concat("/exiftool/exiftool");

    public static ExifTool with() {
        if (instance == null) {
            instance = new ExifTool();
        }
        return instance;
    }


    public boolean removeTags(String sourcePath) throws IOException, InterruptedException {
        String[] cmd = {
                "perl",
                exifPath,
                "-all= ",
                "-overwrite_original_in_place",
                sourcePath
        };

        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        processBuilder.redirectErrorStream(true);
        String processedCommand = processBuilder.command().toString();
//        Log.e(TAG, "onCreate: Command::  " + processedCommand);
        Process process = processBuilder.start();
        int exitCode = process.waitFor();
        Log.e(TAG, "onCreate: ExitCode::  " + exitCode);

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            Log.e(TAG, "onCreate: Output::  " + s);
        }

        return exitCode == 0;


    }
}
