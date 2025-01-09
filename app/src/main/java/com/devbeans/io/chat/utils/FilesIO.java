package com.devbeans.io.chat.utils;


import android.os.Environment;

import com.devbeans.io.chat.app.MainApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilesIO {
    private static final String appInternalFolderPath = Environment.getExternalStorageDirectory() + "/Android/data/" + MainApp.Companion.getAppContext().getPackageName();

    public static String getAppInternalFolderPath() {
        File dir = new File(appInternalFolderPath);
        if (!dir.exists()) {
            boolean created = dir.mkdir();
            Utills.INSTANCE.handleFileDelete("FileIO", created);
        }
        return appInternalFolderPath;
    }

    public static File writeFile(File file, String data) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            try {
                if (fos != null) {
                    fos.write(data.getBytes());
                    fos.write("\n".getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }


}
