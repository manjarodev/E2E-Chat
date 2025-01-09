package com.devbeans.io.chat.utils;


import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.webkit.MimeTypeMap;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.devbeans.io.chat.app.MainApp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class FilePath {

    /**
     * Method for return file path of Gallery image
     *
     * @param context
     * @param uri
     * @return path of the selected image file from gallery
     */

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String getPath(final Context context, final Uri uri) {
        //check here to KITKAT or new version
        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {

            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            }

            //DownloadsProvider
            else if (isDownloadsDocument(uri)) {

                final String id = DocumentsContract.getDocumentId(uri);
                File file = new File(Environment.getRootDirectory() + "/" + Environment.DIRECTORY_DOWNLOADS);
                Log.e("fileTAG", "getPath: " + file.getAbsolutePath());
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.parseLong(id));

                return getDataColumn(context, contentUri, null, null);
            }

            // MediaProvider
            else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                } else if ("document".equals(type)) {
//                     contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{
                        split[1]
                };

                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        }
        return handleReturn(uri, context);


    }

    private static String handleReturn(Uri uri, Context context) {
        // MediaStore (and general)
        if ("content".equalsIgnoreCase(uri.getScheme())) {

            // Return the remote address
            if (isGooglePhotosUri(uri))
                return uri.getLastPathSegment();

            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }

    /**
     * Get the value of the data column for this Uri. This is useful for
     * MediaStore Uris, and other file-based ContentProviders.
     *
     * @param context       The context.
     * @param uri           The Uri to query.
     * @param selection     (Optional) Filter used in the query.
     * @param selectionArgs (Optional) Selection arguments used in the query.
     * @return The value of the _data column, which is typically a file path.
     */
    public static String getDataColumn(Context context, Uri uri, String selection,
                                       String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {
                column
        };

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Photos.
     */
    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }


    public static String generateOutputFileName(@NonNull String contentType, long timestamp) {
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
//        String           extension     = mimeTypeMap.getExtensionFromMimeType(contentType);
        String extension = contentType;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
        String base = "chat-" + dateFormatter.format(timestamp);


        return base + "." + extension;
    }

    public static String generateOutputFileNames(@NonNull String cFileName, long timestamp) {
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
//        String           extension     = mimeTypeMap.getExtensionFromMimeType(contentType);
//        String extension = contentType;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
        String base = "chat-" + dateFormatter.format(timestamp);

//        if (extension == null) extension = "attach";

        return base + "." + cFileName;
    }

    private String sanitizeOutputFileName(@NonNull String fileName) {
        return new File(fileName).getName();
    }

    private static class CreateMediaUriResult {
        final Uri outputUri;
        final Uri mediaUri;

        private CreateMediaUriResult(Uri outputUri, Uri mediaUri) {
            this.outputUri = outputUri;
            this.mediaUri = mediaUri;
        }
    }

    public static File fileFromContentUri(Context context, Uri contentUri) throws IOException {
        // Preparing Temp file name

        String extension = AndroidUtil.getMimeType(context, contentUri);
        String fileName = generateOutputFileName(extension, System.currentTimeMillis());

        // Creating Temp file on basis of extension
        File tempFile;
        Log.e(FilePath.class.getSimpleName(), "e " + extension);
        //Setting FilePath According to File Extension
        if (extension.equalsIgnoreCase("jpeg") || extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png")) {
            tempFile = new File(MainApp.Companion.getImagesPathSent(), fileName);
        } else if (extension.equalsIgnoreCase("mp3") || extension.equalsIgnoreCase("aac")) {
            tempFile = new File(MainApp.Companion.getAudioPathSent(), fileName);
        } else if (extension.equalsIgnoreCase("mp4")) {
            tempFile = new File(MainApp.Companion.getVideoPathSent(), fileName);
        } else {
            tempFile = new File(MainApp.Companion.getFilesPathSent(), fileName);
        }

        Utills.INSTANCE.handleFileDelete(
                "FilePath",
                tempFile.createNewFile()
        );

        try (
                FileOutputStream oStream = new FileOutputStream(tempFile);
                InputStream inputStream = context.getContentResolver().openInputStream(contentUri);
        ) {
//            MainApp.Companion.getStorage().copy(contentUri.getPath(),tempFile.getPath());


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                ServiceUtil.getClipboardManager(context).clearPrimaryClip();
            }
            StreamUtil.copy(inputStream, oStream);
            oStream.flush();
            return tempFile;
        } catch (Exception e) {
            Log.e(FilePath.class.getSimpleName(), "Exception: " + e.getMessage());
            e.printStackTrace();
            return null;
        }


    }


    /**
     * Creates a temporary file from a given content URI, allowing it to be accessed in a more controlled way.
     *
     * @param context    The application context, used to access the cache directory and content resolver.
     * @param contentUri The content URI representing the file to be copied to the temporary file.
     * @return The temporary file created from the given content URI.
     * @throws IOException If any file operation fails.
     */
    public static File contactFromContentUri(Context context, Uri contentUri) throws IOException {
        // 1. Preparing the temporary file's name based on the content URI's path
        String finalName = new File(contentUri.getPath()).getName();

        // 2. Creating the temporary file in the cache directory
        File tempFile = new File(context.getCacheDir(), finalName);

        // 3. Deleting any previous instance of the temporary file, if it exists
        if (tempFile.exists()) {
            tempFile.delete();
        }

        // 4. Creating a new temporary file
        if (!tempFile.createNewFile()) {
            throw new IOException("Failed to create a new temporary file.");
        }

        // 5. Copying the content from the content URI to the temporary file
        try (InputStream inputStream = context.getContentResolver().openInputStream(contentUri);
             FileOutputStream outputStream = new FileOutputStream(tempFile)) {
            // 6. Utilizing a utility method to copy the input stream to the output stream
            StreamUtil.copy(inputStream, outputStream);
            outputStream.flush();
        } catch (Exception e) {
            // 7. Logging any exception that occurs during the process
            e.printStackTrace();
        }

        // 8. Returning the created temporary file
        return tempFile;
    }


    public static File fileFromContentUriDelete(Context context, Uri contentUri) throws IOException {
        // Preparing Temp file name

        String extension = AndroidUtil.getMimeType(context, contentUri);
        String fileName = generateOutputFileName(extension, System.currentTimeMillis());

        // Creating Temp file on basis of extension
        File tempFile;
        Log.e(FilePath.class.getSimpleName(), "e " + extension);
        //Setting FilePath According to File Extension
        if (extension.equalsIgnoreCase("jpeg") || extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png")) {
            tempFile = new File(MainApp.Companion.getImagesPathConv(), fileName);
        } else if (extension.equalsIgnoreCase("mp3") || extension.equalsIgnoreCase("aac")) {
            tempFile = new File(MainApp.Companion.getAudioPathSent(), fileName);
        } else if (extension.equalsIgnoreCase("mp4")) {
            tempFile = new File(MainApp.Companion.getVideoPathSent(), fileName);
        } else {
            tempFile = new File(MainApp.Companion.getFilesPathSent(), fileName);
        }

        Utills.INSTANCE.handleFileDelete(
                "FilePath",
                tempFile.createNewFile()
        );

        try (
                FileOutputStream oStream = new FileOutputStream(tempFile);
                InputStream inputStream = context.getContentResolver().openInputStream(contentUri);
        ) {
//            MainApp.Companion.getStorage().copy(contentUri.getPath(),tempFile.getPath());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                ServiceUtil.getClipboardManager(context).clearPrimaryClip();
            }
            StreamUtil.copy(inputStream, oStream);
            oStream.flush();
            return tempFile;
        } catch (Exception e) {
            Log.e(FilePath.class.getSimpleName(), "Exception: " + e.getMessage());
            e.printStackTrace();
            return null;
        }


    }

    public static File fileAudioFromContentUri(Context context, String file) throws IOException {
        // Preparing Temp file name
        Uri uri = Uri.fromFile(new File(file));
        String fileName = generateOutputFileName("aac", System.currentTimeMillis());

        // Creating Temp file on basis of extension
        File tempFile;
//        Log.e(FilePath.class.getSimpleName(),"e "+extension);
        //Setting FilePath According to File Extension

        tempFile = new File(MainApp.Companion.getAudioPathSent(), fileName);


        Utills.INSTANCE.handleFileDelete(
                "FilePath",
                tempFile.createNewFile()
        );

        try (
                FileOutputStream oStream = new FileOutputStream(tempFile);
                InputStream inputStream = context.getContentResolver().openInputStream(uri);
        ) {
//            MainApp.Companion.getStorage().copy(contentUri.getPath(),tempFile.getPath());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                ServiceUtil.getClipboardManager(context).clearPrimaryClip();
            }
            StreamUtil.copy(inputStream, oStream);
            oStream.flush();
            return tempFile;
        } catch (Exception e) {
            Log.e(FilePath.class.getSimpleName(), "Exception: " + e.getMessage());
            e.printStackTrace();
            return null;
        }


    }

    public static File fileFromContentUriVault(Context context, Uri contentUri) throws IOException {
        // Preparing Temp file name
        File destFile = new File(contentUri.getPath());
        String finalName = destFile.getName();

        String extension = AndroidUtil.getMimeType(context, contentUri);
        String outputPath = PathUtil.getMediaPath(finalName);
        String fileName = generateOutputFileName(extension, System.currentTimeMillis());
//        String fileName = outputPath + "/" + finalName;

        File tempFile;

        //Setting FilePath According to File Extension
        if (extension.equalsIgnoreCase("jpeg") || extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png")) {
            tempFile = new File(MainApp.Companion.getImagesPathSent(), fileName);
        } else if (extension.equalsIgnoreCase("mp3")) {
            tempFile = new File(MainApp.Companion.getAudioPathSent(), fileName);
        } else if (extension.equalsIgnoreCase("mp4")) {
            tempFile = new File(MainApp.Companion.getVideoPathSent(), fileName);
        } else {
            tempFile = new File(MainApp.Companion.getFilesPathSent(), fileName);
        }

        // Creating Temp file

        Utills.INSTANCE.handleFileDelete(
                "FilePath",
                tempFile.createNewFile()
        );

        try (
                FileOutputStream oStream = new FileOutputStream(tempFile);
                InputStream inputStream = context.getContentResolver().openInputStream(contentUri);
        ) {

            StreamUtil.copy(inputStream, oStream);
            oStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempFile;
    }

    public static File copyFileToInternal(Context context, Uri contentUri) throws IOException {
        // Preparing Temp file name

        String extension = AndroidUtil.getMimeType(context, contentUri);
        String fileName = generateOutputFileName(extension, System.currentTimeMillis());

        // Creating Temp file
        File tempFile = new File(context.getFilesDir(), fileName);
        Utills.INSTANCE.handleFileDelete(
                "FilePath",
                tempFile.createNewFile()
        );

        try (
                FileOutputStream oStream = new FileOutputStream(tempFile);
                InputStream inputStream = context.getContentResolver().openInputStream(contentUri);
        ) {

            StreamUtil.copy(inputStream, oStream);
            oStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempFile;
    }


}