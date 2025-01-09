package com.devbeans.io.chat.utils;


import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;

import androidx.annotation.NonNull;
import androidx.loader.content.CursorLoader;

import com.devbeans.io.chat.app.MainApp;
import com.hbisoft.pickit.SDUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class PathUtil {
    private static boolean unknownProviderCalledBefore = false;
    private static String failReason;
    public static final String pCapital = Constants.PCAPITAL;
    public static String imagesPattern = "(^.*\\.(png|jpeg|jpg|JPG|webp|WEBP)$)";
    public static String audioPattern = "(^.*\\.(mp3|wav)$)";
    public static String videoPattern = "(^.*\\.(avi|AVI|wmv|WMV|flv|FLV|mpg|MPG|mp4|MP4|WEBM|webm)$)";
    public static String filesPattern = "(^.*\\.(pdf|docx|doc|xlsx|txt)$)";
    //    public static String passPhrasePattern = "^([A-Za-z\\d!@#$%^&*()_+])(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+])[A-Za-z\\d][A-Za-z\\d!@#$%^&*()_+]{8,16}$";
    public static String pPattern = Constants.PPATTERN;

    //    public static String passPhrasePattern = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+])[A-Za-z\\d][A-Za-z\\d!@#$%^&*()_+]{8,16}$";
    /*
     * Gets the file path of the given Uri.
     */
    @SuppressLint("NewApi")
    public static String getPath(Context context, Uri uri) throws URISyntaxException {
        final boolean needToCheckUri = Build.VERSION.SDK_INT >= 19;
        String selection = null;
        String[] selectionArgs = null;
        // Uri is different in versions after KITKAT (Android 4.4), we need to
        // deal with different Uris.
        if (needToCheckUri && DocumentsContract.isDocumentUri(context.getApplicationContext(), uri)) {
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                return Environment.getExternalStorageDirectory() + "/" + split[1];
            } else if (isDownloadsDocument(uri)) {
                final String id = DocumentsContract.getDocumentId(uri);
                uri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
            } else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];
                if ("image".equals(type)) {
                    uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                selection = "_id=?";
                selectionArgs = new String[]{split[1]};
            }
        }
        return handleReturn(context, uri, selection, selectionArgs);
    }

    private static String handleReturn(Context context, Uri uri, String selection, String[] selectionArgs) {
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            String[] projection = {MediaStore.Images.Media.DATA};
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                if (cursor.moveToFirst()) {
                    return cursor.getString(column_index);
                }
            } catch (Exception e) {
            }
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }


    public static String getPath(Context context, Uri uri, int APILevel, boolean enableProc) {
        String returnedPath;
        if (APILevel >= 19) {
            String docId = null;
            // This is only used when a file is selected from a sub-directory inside the Downloads folder
            // and when the Uri returned has the msf: prefix
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    docId = DocumentsContract.getDocumentId(uri);
                }
            } catch (Exception e) {
                // Ignore
            }
            // Drive file was selected
            if (isOneDrive(uri) || isDropBox(uri) || isGoogleDrive(uri)) {
//                isDriveFile = true;
//                downloadFile(uri);
            }
            // File was selected from Downloads provider
            else if (docId != null && docId.startsWith("msf")) {
                String fileName = getFilePath(context, uri);
                try {
                    File file = new File(Environment.getExternalStorageDirectory().toString() + "/Download/" + fileName);
                    // If the file exists in the Downloads directory
                    // we can return the path directly
                    if (file.exists()) {

                        return file.getAbsolutePath();
//                        pickiTCallbacks.PickiTonCompleteListener(file.getAbsolutePath(), false, false, true, "");

                    }
                    // The file is in a sub-directory in Downloads
                    // We will first try to make use of the /proc/ protocol
                    // if /proc/ doesn't work, or if there is any issue trying to get access to the file, it gets copied to the applications directory
                    else {
                        if (enableProc) {
                            try (
                                    ParcelFileDescriptor parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
                            ) {

                                int fd = parcelFileDescriptor.getFd();
                                int pid = android.os.Process.myPid();
                                String mediaFile = "/proc/" + pid + "/fd/" + fd;
                                File file1 = new File(mediaFile);
                                if (file1.exists() && file1.canRead() && file1.canWrite()) {

                                    return file1.getAbsolutePath();
//                                    pickiTCallbacks.PickiTonCompleteListener(file1.getAbsolutePath(), false, false, true, "");
                                } else {

//                                    isMsfDownload = true;
//                                    downloadFile(uri);
                                }
                            } catch (Exception e) {

//                                isMsfDownload = true;
//                                downloadFile(uri);
                            }
                        } else {

//                            isMsfDownload = true;
//                            downloadFile(uri);
                        }
                    }
                } catch (Exception e) {
//                    isMsfDownload = true;
//                    downloadFile(uri);
                }

            }
            // Local file was selected
            else {
                returnedPath = getRealPathFromURI_API19_(context, uri);
                //Get the file extension
                final MimeTypeMap mime = MimeTypeMap.getSingleton();
                String subStringExtension = String.valueOf(returnedPath).substring(String.valueOf(returnedPath).lastIndexOf(".") + 1);
                String extensionFromMime = mime.getExtensionFromMimeType(context.getContentResolver().getType(uri));

                // Path is null
                if (returnedPath == null || returnedPath.equals("")) {
                    // This can be caused by two situations
                    // 1. The file was selected from a third party app and the data column returned null (for example EZ File Explorer)
                    // Some file providers (like EZ File Explorer) will return a URI as shown below:
                    // content://es.fileexplorer.filebrowser.ezfilemanager.externalstorage.documents/document/primary%3AFolderName%2FNameOfFile.mp4
                    // When you try to read the _data column, it will return null, without trowing an exception
                    // In this case the file need to copied/created a new file in the temporary folder
                    // 2. There was an error
                    // In this case call PickiTonCompleteListener and get/provide the reason why it failed

                    //We first check if it was called before, avoiding multiple calls
                    if (!unknownProviderCalledBefore) {
                        unknownProviderCalledBefore = true;
                        if (uri.getScheme() != null && uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
                            //Then we check if the _data colomn returned null
                            if (failReason != null && failReason.equals("dataReturnedNull")) {
//                                isFromUnknownProvider = true;
                                //Copy the file to the temporary folder
//                                downloadFile(uri);
                                return null;
                            } else if (failReason != null && failReason.contains("column '_data' does not exist")) {
//                                isFromUnknownProvider = true;
                                //Copy the file to the temporary folder
//                                downloadFile(uri);
                                return null;
                            } else if (failReason != null && failReason.equals("uri")) {
//                                isFromUnknownProvider = true;
                                //Copy the file to the temporary folder
//                                downloadFile(uri);
                                return null;
                            }
                        }
                    }
                    //Else an error occurred, get/set the reason for the error
//                    pickiTCallbacks.PickiTonCompleteListener(returnedPath, false, false, false, Utils.errorReason());
                }
                // Path is not null
                else {
                    // This can be caused by two situations
                    // 1. The file was selected from an unknown provider (for example a file that was downloaded from a third party app)
                    // 2. getExtensionFromMimeType returned an unknown mime type for example "audio/mp4"
                    //
                    // When this is case we will copy/write the file to the temp folder, same as when a file is selected from Google Drive etc.
                    // We provide a name by getting the text after the last "/"
                    // Remember if the extension can't be found, it will not be added, but you will still be able to use the file
                    //Todo: Add checks for unknown file extensions

                    if (!subStringExtension.equals("jpeg") && !subStringExtension.equals(extensionFromMime) && uri.getScheme() != null && uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
                        // First check if the file is available
                        // With issue #48 the file is available
                        try {
                            File checkIfExist = new File(returnedPath);
                            if (checkIfExist.exists()) {

//                                pickiTCallbacks.PickiTonCompleteListener(returnedPath, false, false, true, "");
                                //TODO: return path
                                return checkIfExist.getAbsolutePath();
                            }
                        } catch (Exception e) {
                            //Ignore
                        }
//                        isFromUnknownProvider = true;
//                        downloadFile(uri);
                        return null;
                    }

                    // Path can be returned, no need to make a "copy"
//                    if (wasMultipleFileSelected){
//                        multiplePaths.add(returnedPath);
//                    }else {

                    //TODO Return
                    return returnedPath;
//                        pickiTCallbacks.PickiTonCompleteListener(returnedPath, false, false, true, "");
//                    }
                }
                return returnedPath;
            }
            return null;
        } else {
            //Todo: Test API <19
            returnedPath = getRealPathFromURI_BelowAPI19(context, uri);


            //TODO Return
            return returnedPath;
//            pickiTCallbacks.PickiTonCompleteListener(returnedPath, false, false, true, "");
        }

    }

    @SuppressWarnings("TryFinallyCanBeTryWithResources")
    public static String getFilePath(Context context, Uri uri) {
        Cursor cursor = null;
        final String[] projection = {MediaStore.Files.FileColumns.DISPLAY_NAME};
        try {
            cursor = context.getContentResolver().query(uri, projection, null, null,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DISPLAY_NAME);
                return cursor.getString(index);
            }
        } catch (Exception e) {
            failReason = e.getMessage();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    static String getRealPathFromURI_BelowAPI19(Context context, Uri contentUri) {
        String[] proj = {MediaStore.Video.Media.DATA};
        android.content.CursorLoader loader = new android.content.CursorLoader(context, contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }

    @SuppressLint("NewApi")
    static String getRealPathFromURI_API19_(final Context context, final Uri uri) {

        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {

            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    if (split.length > 1) {
                        return Environment.getExternalStorageDirectory() + "/" + split[1];
                    } else {
                        return Environment.getExternalStorageDirectory() + "/";
                    }
                } else {
                    // Some devices does not allow access to the SD Card using the UID, for example /storage/6551-1152/folder/video.mp4
                    // Instead, we first have to get the name of the SD Card, for example /storage/sdcard1/folder/video.mp4

                    // We first have to check if the device allows this access
                    if (new File("storage" + "/" + docId.replace(":", "/")).exists()) {
                        return "/storage/" + docId.replace(":", "/");
                    }
                    // If the file is not available, we have to get the name of the SD Card, have a look at SDUtils
                    String[] availableExternalStorages = SDUtil.getStorageDirectories(context);
                    String root = "";
                    for (String s : availableExternalStorages) {
                        if (split[1].startsWith("/")) {
                            root = s + split[1];
                        } else {
                            root = s + "/" + split[1];
                        }
                    }
                    if (root.contains(type)) {
                        return "storage" + "/" + docId.replace(":", "/");
                    } else {
                        if (root.startsWith("/storage/") || root.startsWith("storage/")) {
                            return root;
                        } else if (root.startsWith("/")) {
                            return "/storage" + root;
                        } else {
                            return "/storage/" + root;
                        }
                    }
                }

            } else if (isRawDownloadsDocument(uri)) {
                String fileName = getFilePath(context, uri);
                String subFolderName = getSubFolders(uri);

                if (fileName != null) {
                    return Environment.getExternalStorageDirectory().toString() + "/Download/" + subFolderName + fileName;
                }
                String id = DocumentsContract.getDocumentId(uri);

                final Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
                return getDataColumn(context, contentUri, null, null);
            } else if (isDownloadsDocument(uri)) {
                String fileName = getFilePath(context, uri);

                if (fileName != null) {
                    return Environment.getExternalStorageDirectory().toString() + "/Download/" + fileName;
                }
                String id = DocumentsContract.getDocumentId(uri);
                if (id.startsWith("raw:")) {
                    id = id.replaceFirst("raw:", "");
                    File file = new File(id);
                    if (file.exists())
                        return id;
                }
                if (id.startsWith("raw%3A%2F")) {
                    id = id.replaceFirst("raw%3A%2F", "");
                    File file = new File(id);
                    if (file.exists())
                        return id;
                }
                final Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
                return getDataColumn(context, contentUri, null, null);
            } else if (isMediaDocument(uri)) {
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
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{
                        split[1]
                };

                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            if (isGooglePhotosUri(uri)) {
                return uri.getLastPathSegment();
            }
            if (getDataColumn(context, uri, null, null) == null) {
                failReason = "dataReturnedNull";
            }
            return getDataColumn(context, uri, null, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }

    private static String getSubFolders(Uri uri) {
        String replaceChars = String.valueOf(uri).replace("%2F", "/").replace("%20", " ").replace("%3A", ":");
        String[] bits = replaceChars.split("/");
        String sub5 = bits[bits.length - 2];
        String sub4 = bits[bits.length - 3];
        String sub3 = bits[bits.length - 4];
        String sub2 = bits[bits.length - 5];
        String sub1 = bits[bits.length - 6];
        if (sub1.equals("Download")) {
            return sub2 + "/" + sub3 + "/" + sub4 + "/" + sub5 + "/";
        } else if (sub2.equals("Download")) {
            return sub3 + "/" + sub4 + "/" + sub5 + "/";
        } else if (sub3.equals("Download")) {
            return sub4 + "/" + sub5 + "/";
        } else if (sub4.equals("Download")) {
            return sub5 + "/";
        } else {
            return "";
        }
    }

    private static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};
        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } catch (Exception e) {
            failReason = e.getMessage();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    private static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    private static boolean isRawDownloadsDocument(Uri uri) {
        String uriToString = String.valueOf(uri);
        return uriToString.contains("com.android.providers.downloads.documents/document/raw");
    }


    // Check different providers
    private static boolean isDropBox(Uri uri) {
        return String.valueOf(uri).toLowerCase().contains("content://com.dropbox.");
    }

    private static boolean isGoogleDrive(Uri uri) {
        return String.valueOf(uri).toLowerCase().contains("com.google.android.apps");
    }

    private static boolean isOneDrive(Uri uri) {
        return String.valueOf(uri).toLowerCase().contains("com.microsoft.skydrive.content");
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

    public static String getRealPathFromURI_API19(Context context, Uri uri) {
        String filePath = "";
        String wholeID = DocumentsContract.getDocumentId(uri);
        // Split at colon, use second item in the array
        String id = wholeID.split(":")[1];
        String[] column = {MediaStore.Images.Media.DATA};
        // where id is equal to
        String sel = MediaStore.Images.Media._ID + "=?";
        Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                column, sel, new String[]{id}, null);
        int columnIndex = cursor.getColumnIndex(column[0]);
        if (cursor.moveToFirst()) {
            filePath = cursor.getString(columnIndex);
        }
        cursor.close();
        return filePath;
    }

    public static String getMediaType(String fileName) {
        Pattern patternImages = Pattern.compile(imagesPattern);
        Pattern patternAudio = Pattern.compile(audioPattern);
        Pattern patternVideo = Pattern.compile(videoPattern);
        Pattern patternFiles = Pattern.compile(filesPattern);
        if (patternImages.matcher(fileName).matches()) {
            return "image";
        } else if (patternAudio.matcher(fileName).matches()) {
            return "audio";
        } else if (patternVideo.matcher(fileName).matches()) {
            return "video";
        } else if (patternFiles.matcher(fileName).matches()) {
            return "file";
        } else {
            return null;
        }
    }

    public static String getMediaPath(String fileName) {
        Pattern patternImages = Pattern.compile(imagesPattern);
        Pattern patternAudio = Pattern.compile(audioPattern);
        Pattern patternVideo = Pattern.compile(videoPattern);
        Pattern patternFiles = Pattern.compile(filesPattern);
        if (patternImages.matcher(fileName).matches()) {
            return MainApp.Companion.getImagesPath();
        } else if (patternAudio.matcher(fileName).matches()) {
            return MainApp.Companion.getAudioPath();
        } else if (patternVideo.matcher(fileName).matches()) {
            return MainApp.Companion.getVideoPath();
        } else if (patternFiles.matcher(fileName).matches()) {
            return MainApp.Companion.getFilesPath();
        } else {
            return null;
        }
    }

    public static boolean isValidPassPhrase(String source) {
        return Pattern.compile(pPattern).matcher(source).matches();
    }

    public static boolean isPassPhraseCapital(String source) {
        return Pattern.compile(pCapital).matcher(source).matches();
    }

    public static boolean isValidPass(String str) {
        char ch;
        boolean isCapital = false;
        boolean isDigit = false;
        boolean isSpecial = false;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                isCapital = true;
            }
            if (Character.isDigit(ch)) {
                isDigit = true;
            }
            if (!Character.isAlphabetic(ch) && !Character.isSpaceChar(ch) && !Character.isDigit(ch)) {
                isSpecial = true;
            }
        }
        return isCapital && isDigit && isSpecial;
    }

    @SuppressLint("NewApi")
    public static String getRealPathFromURI_API11to18(Context context, Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        String result = null;
        CursorLoader cursorLoader = new CursorLoader(
                context,
                contentUri, proj, null, null, null);
        Cursor cursor = cursorLoader.loadInBackground();
        if (cursor != null) {
            int column_index =
                    cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            result = cursor.getString(column_index);
        }
        return result;
    }

    public static String getRealPathFromURI_BelowAPI11(Context context, Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
        int column_index
                = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    public static File fileFromContentUri(Context context, Uri contentUri) throws IOException {
        // Preparing Temp file name
        File destFile = new File(contentUri.getPath());
        String finalName = destFile.getName();
        String extension = getMimeType(context, contentUri);
        String outputPath = PathUtil.getMediaPath(finalName);
//        String fileName = generateOutputFileName(extension, System.currentTimeMillis());
//        String fileName = outputPath + "/" + finalName;
        // Creating Temp file
        File tempFile = new File(outputPath, finalName);
        Utills.INSTANCE.handleFileDelete("PathUtils", tempFile.createNewFile());

        try (
                FileOutputStream oStream = new FileOutputStream(tempFile);
                InputStream inputStream = context.getContentResolver().openInputStream(contentUri);
        ) {

            copy(inputStream, oStream);
            oStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempFile;
    }

    private static String generateOutputFileName(@NonNull String contentType, long timestamp) {
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
//        String           extension     = mimeTypeMap.getExtensionFromMimeType(contentType);
        String extension = contentType;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
        String base = "chat-" + dateFormatter.format(timestamp);

        return base + "." + extension;
    }

    public static String getMimeType(Context context, Uri uri) {
        String extension;
        //Check uri format to avoid null
        if (uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
            //If scheme is a content
            final MimeTypeMap mime = MimeTypeMap.getSingleton();
            extension = mime.getExtensionFromMimeType(context.getContentResolver().getType(uri));
        } else {
            //If scheme is a File
            //This will replace white spaces with %20 and also other special characters. This will avoid returning null values on file name with spaces and special characters.
            extension = MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
        }
        return extension;
    }

    public static long copy(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[64 * 1024];
        int read;
        long total = 0;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
            total += read;
        }
        in.close();
        out.close();
        return total;
    }
}