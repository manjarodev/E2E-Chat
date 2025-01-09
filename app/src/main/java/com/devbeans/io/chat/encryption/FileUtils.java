
package com.devbeans.io.chat.encryption;

import com.devbeans.io.chat.utils.logging.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileUtils {

    public static void saveFile(byte[] encodedBytes, String path) {
        boolean check = false;
        try {
            File file = new File(path);
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
                bos.write(encodedBytes);
                bos.flush();
            }
            check = true;

        } catch (FileNotFoundException e) {
            check = false;
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }
//        return check;
    }

    public static byte[] readFile(String filePath) {
        byte[] contents;
        File file = new File(filePath);
        int size = (int) file.length();
        contents = new byte[size];
        try (
                BufferedInputStream buf = new BufferedInputStream(
                        new FileInputStream(file));
        ) {

            try {
                int readBytes = buf.read(contents);
                Log.w(Log.tag(FileUtils.class), "Read values" + readBytes);
                buf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents;
    }

//    @NonNull
//    public static File createTempFile(Context context, byte[] decrypted) throws IOException {
//        File tempFile = File.createTempFile(Constants.TEMP_FILE_NAME, Constants.FILE_EXT, new File(Constants.DIR_NAME));
//        tempFile.deleteOnExit();
//        FileOutputStream fos = new FileOutputStream(tempFile);
//        fos.write(decrypted);
//        fos.close();
//        return tempFile;
//    }

//    public static FileDescriptor getTempFileDescriptor(Context context, byte[] decrypted) throws IOException {
//        File tempFile = FileUtils.createTempFile(context, decrypted);
//        FileInputStream fis = new FileInputStream(tempFile);
//        return fis.getFD();
//    }

//    public static final String getDirPath(Context context) {
//        return context.getDir(DIR_NAME, Context.MODE_PRIVATE).getAbsolutePath();
//    }

//    public static final String getFilePath(Context context) {
//        return getDirPath(context) + File.separator + FILE_NAME;
//    }

//    public static final void deleteDownloadedFile(Context context) {
//        File file = new File(Constants.DIR_NAME + File.separator + Constants.FILE_NAME);
//        if (null != file && file.exists()) {
//            if (file.delete()) Log.i("FileUtils", "File Deleted.");
//        }
//    }


}
