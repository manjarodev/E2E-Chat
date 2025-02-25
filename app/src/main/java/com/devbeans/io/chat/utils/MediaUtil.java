package com.devbeans.io.chat.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.text.TextUtils;
import android.transition.Slide;
import android.webkit.MimeTypeMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;

import com.devbeans.io.chat.models.Attachment;
import com.devbeans.io.chat.models.VideoSize;
import com.devbeans.io.chat.utils.logging.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

public class MediaUtil {

    private static final String TAG = MediaUtil.class.getSimpleName();

    public static final String IMAGE_PNG = "image/png";
    public static final String IMAGE_JPEG = "image/jpeg";
    public static final String IMAGE_HEIC = "image/heic";
    public static final String IMAGE_HEIF = "image/heif";
    public static final String IMAGE_WEBP = "image/webp";
    public static final String IMAGE_GIF = "image/gif";
    public static final String AUDIO_AAC = "audio/aac";
    public static final String AUDIO_UNSPECIFIED = "audio/*";
    public static final String VIDEO_MP4 = "video/mp4";
    public static final String VIDEO_UNSPECIFIED = "video/*";
    public static final String VCARD = "text/x-vcard";
    public static final String LONG_TEXT = "text/x-signal-plain";
    public static final String VIEW_ONCE = "application/x-signal-view-once";
    public static final String UNKNOWN = "*/*";
    public static final String OCTET = "application/octet-stream";

    public static SlideType getSlideTypeFromContentType(@NonNull String contentType) {
        if (isGif(contentType)) {
            return SlideType.GIF;
        } else if (isImageType(contentType)) {
            return SlideType.IMAGE;
        } else if (isVideoType(contentType)) {
            return SlideType.VIDEO;
        } else if (isAudioType(contentType)) {
            return SlideType.AUDIO;
        } else if (isMms(contentType)) {
            return SlideType.MMS;
        } else if (isLongTextType(contentType)) {
            return SlideType.LONG_TEXT;
        } else if (isViewOnceType(contentType)) {
            return SlideType.VIEW_ONCE;
        } else {
            return SlideType.DOCUMENT;
        }
    }

    public static @NonNull
    Slide getSlideForAttachment(Context context, Attachment attachment) {
//        if (attachment.isSticker()) {
//            return new StickerSlide(context, attachment);
//        }

        switch (getSlideTypeFromContentType(attachment.getContentType())) {
//            case GIF       : return new GifSlide(context, attachment);
//            case IMAGE     : return new ImageSlide(context, attachment);
//            case VIDEO     : return new VideoSlide(context, attachment);
//            case AUDIO     : return new AudioSlide(context, attachment);
//            case MMS       : return new MmsSlide(context, attachment);
//            case LONG_TEXT : return new TextSlide(context, attachment);
//            case VIEW_ONCE : return new ViewOnceSlide(context, attachment);
//            case DOCUMENT  : return new DocumentSlide(context, attachment);
            default:
                throw new AssertionError();
        }
    }

    public static @Nullable
    String getMimeType(@NonNull Context context, @Nullable Uri uri) {
        if (uri == null) return null;

//        if (PartAuthority.isLocalUri(uri)) {
//            return PartAuthority.getAttachmentContentType(context, uri);
//        }

        String type = context.getContentResolver().getType(uri);
        if (type == null || isOctetStream(type)) {
            final String extension = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension.toLowerCase());
        }

        return getCorrectedMimeType(type);
    }

    public static @Nullable
    String getExtension(@NonNull Context context, @Nullable Uri uri) {
        return MimeTypeMap.getSingleton()
                .getExtensionFromMimeType(getMimeType(context, uri));
    }

    public static @Nullable
    String getCorrectedMimeType(@Nullable String mimeType) {
        if (mimeType == null) return null;

        switch (mimeType) {
            case "image/jpg":
                return MimeTypeMap.getSingleton().hasMimeType(IMAGE_JPEG)
                        ? IMAGE_JPEG
                        : mimeType;
            default:
                return mimeType;
        }
    }

    public static long getMediaSize(Context context, Uri uri) throws IOException {
//        InputStream in = PartAuthority.getAttachmentStream(context, uri);
        try (
                InputStream in = context.getContentResolver().openInputStream(uri);
        ) {

            if (in == null) throw new IOException("Couldn't obtain input stream.");

            long size = 0;
            byte[] buffer = new byte[4096];
            int read;

            while ((read = in.read(buffer)) != -1) {
                size += read;
            }
            in.close();

            return size;
        }
    }

    public static long getFileSize(Uri fileUri, Context context) {
        Cursor returnCursor = context.getContentResolver().
                query(fileUri, null, null, null, null);
        int sizeIndex = returnCursor.getColumnIndex(OpenableColumns.SIZE);
        returnCursor.moveToFirst();

        long size = returnCursor.getLong(sizeIndex);
        returnCursor.close();

        return size;
    }

    public static long getAttachmentMediaSize(Context context, Uri uri) throws IOException {
//        InputStream in = PartAuthority.getAttachmentStream(context, uri);


        try (
                InputStream in = context.getContentResolver().openInputStream(uri);
        ) {
            if (in == null) throw new IOException("Couldn't obtain input stream.");

            long size = 0;
            byte[] buffer = new byte[4096];
            int read = 0;
            Log.e(TAG, "in " + in);
            while ((read = in.read(buffer)) != -1) {
                size += read;
            }
            in.close();

            return size;
        }
    }



    public static boolean isMms(String contentType) {
        return !TextUtils.isEmpty(contentType) && contentType.trim().equals("application/mms");
    }

    public static boolean isGif(Attachment attachment) {
        return isGif(attachment.getContentType());
    }

    public static boolean isJpeg(Attachment attachment) {
        return isJpegType(attachment.getContentType());
    }

    public static boolean isHeic(Attachment attachment) {
        return isHeicType(attachment.getContentType());
    }

    public static boolean isHeif(Attachment attachment) {
        return isHeifType(attachment.getContentType());
    }

    public static boolean isImage(Attachment attachment) {
        return isImageType(attachment.getContentType());
    }

    public static boolean isAudio(Attachment attachment) {
        return isAudioType(attachment.getContentType());
    }

    public static boolean isVideo(Attachment attachment) {
        return isVideoType(attachment.getContentType());
    }

    public static boolean isVideo(String contentType) {
        return !TextUtils.isEmpty(contentType) && contentType.trim().startsWith("video/");
    }

    public static boolean isImage(String contentType) {
        return !TextUtils.isEmpty(contentType) && ((contentType.startsWith("image/") && !contentType.equals("image/svg+xml")) ||
                contentType.equals(MediaStore.Images.Media.CONTENT_TYPE));
    }

    public static boolean isVcard(String contentType) {
        return !TextUtils.isEmpty(contentType) && contentType.trim().equals(VCARD);
    }

    public static boolean isGif(String contentType) {
        return !TextUtils.isEmpty(contentType) && contentType.trim().equals("image/gif");
    }

    public static boolean isJpegType(String contentType) {
        return !TextUtils.isEmpty(contentType) && contentType.trim().equals(IMAGE_JPEG);
    }

    public static boolean isHeicType(String contentType) {
        return !TextUtils.isEmpty(contentType) && contentType.trim().equals(IMAGE_HEIC);
    }

    public static boolean isHeifType(String contentType) {
        return !TextUtils.isEmpty(contentType) && contentType.trim().equals(IMAGE_HEIF);
    }

    public static boolean isFile(Attachment attachment) {
        return !isGif(attachment) && !isImage(attachment) && !isAudio(attachment) && !isVideo(attachment);
    }

    public static boolean isTextType(String contentType) {
        return (null != contentType) && contentType.startsWith("text/");
    }

//    public static boolean isNonGifVideo(Media media) {
//        return isVideo(media.getMimeType()) && !media.isVideoGif();
//    }

    public static boolean isImageType(String contentType) {
        if (contentType == null) {
            return false;
        }

        return (contentType.startsWith("image/") && !contentType.equals("image/svg+xml")) ||
                contentType.equals(MediaStore.Images.Media.CONTENT_TYPE);
    }

    public static boolean isAudioType(String contentType) {
        if (contentType == null) {
            return false;
        }

        return contentType.startsWith("audio/") ||
                contentType.equals(MediaStore.Audio.Media.CONTENT_TYPE);
    }

    public static boolean isVideoType(String contentType) {
        if (contentType == null) {
            return false;
        }

        return contentType.startsWith("video/") ||
                contentType.equals(MediaStore.Video.Media.CONTENT_TYPE);
    }

    public static boolean isImageOrVideoType(String contentType) {
        return isImageType(contentType) || isVideoType(contentType);
    }

    public static VideoSize getVideoSize(Context context, Uri uri) {

        try (
                MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        ) {
            retriever.setDataSource(context, uri);
            int width = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH) == null ? 0 : Integer.parseInt(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH));
            int height = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT) == null ? 0 : Integer.parseInt(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT));
            long duration = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION) == null ? 0 : Long.parseLong(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
            retriever.release();
            return new VideoSize(width, height, duration);
        }
    }

    public static boolean isStorySupportedType(String contentType) {
        return isImageOrVideoType(contentType) && !isGif(contentType);
    }

    public static boolean isImageVideoOrAudioType(String contentType) {
        return isImageOrVideoType(contentType) || isAudioType(contentType);
    }

    public static boolean isImageAndNotGif(@NonNull String contentType) {
        return isImageType(contentType) && !isGif(contentType);
    }

    public static boolean isLongTextType(String contentType) {
        return (null != contentType) && contentType.equals(LONG_TEXT);
    }

    public static boolean isViewOnceType(String contentType) {
        return (null != contentType) && contentType.equals(VIEW_ONCE);
    }

    public static boolean isOctetStream(@Nullable String contentType) {
        return OCTET.equals(contentType);
    }

    public static boolean hasVideoThumbnail(@NonNull Context context, @Nullable Uri uri) {
        if (uri == null) {
            return false;
        }

//        if (BlobProvider.isAuthority(uri) && MediaUtil.isVideo(BlobProvider.getMimeType(uri)) && Build.VERSION.SDK_INT >= 23) {
//            return true;
//        }

        if (!isSupportedVideoUriScheme(uri.getScheme())) {
            return false;
        }

        if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
            return uri.getLastPathSegment().contains("video");
        } else if (uri.toString().startsWith(MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString())) {
            return true;
        } else if (uri.toString().startsWith("file://") &&
                MediaUtil.isVideo(URLConnection.guessContentTypeFromName(uri.toString()))) {
            return true;
        }
//        else if (PartAuthority.isAttachmentUri(uri) && MediaUtil.isVideoType(PartAuthority.getAttachmentContentType(context, uri))) {
//            return true;
//        }
        else {
            return false;
        }
    }

    @WorkerThread
    public static @Nullable
    Bitmap getVideoThumbnail(@NonNull Context context, @Nullable Uri uri, long timeUs) {
        if (uri == null) {
            return null;
        } else if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
            long videoId = Long.parseLong(uri.getLastPathSegment().split(":")[1]);

            return MediaStore.Video.Thumbnails.getThumbnail(context.getContentResolver(),
                    videoId,
                    MediaStore.Images.Thumbnails.MINI_KIND,
                    null);
        } else if (uri.toString().startsWith(MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString())) {
            long videoId = Long.parseLong(uri.getLastPathSegment());

            return MediaStore.Video.Thumbnails.getThumbnail(context.getContentResolver(),
                    videoId,
                    MediaStore.Images.Thumbnails.MINI_KIND,
                    null);
        } else if (uri.toString().startsWith("file://") &&
                MediaUtil.isVideo(URLConnection.guessContentTypeFromName(uri.toString()))) {
            return ThumbnailUtils.createVideoThumbnail(uri.toString().replace("file://", ""),
                    MediaStore.Video.Thumbnails.MINI_KIND);
        }
//        } else if (Build.VERSION.SDK_INT >= 23   &&
//                BlobProvider.isAuthority(uri) &&
//                MediaUtil.isVideo(BlobProvider.getMimeType(uri)))
//        {
//            try {
//                MediaDataSource source = BlobProvider.getInstance().getMediaDataSource(context, uri);
//                return extractFrame(source, timeUs);
//            } catch (IOException e) {
//                Log.w(TAG, "Failed to extract frame for URI: " + uri, e);
//            }
//        } else if (Build.VERSION.SDK_INT >= 23        &&
//                PartAuthority.isAttachmentUri(uri) &&
//                MediaUtil.isVideoType(PartAuthority.getAttachmentContentType(context, uri)))
//        {
//            try {
//                AttachmentId    attachmentId = PartAuthority.requireAttachmentId(uri);
//                MediaDataSource source       = SignalDatabase.attachments().mediaDataSourceFor(attachmentId);
//                return extractFrame(source, timeUs);
//            } catch (IOException e) {
//                Log.w(TAG, "Failed to extract frame for URI: " + uri, e);
//            }
//        }

        return null;
    }

    @RequiresApi(23)
    private static @Nullable
    Bitmap extractFrame(@Nullable MediaDataSource dataSource, long timeUs) throws IOException {
        if (dataSource == null) {
            return null;
        }

        try (
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        ) {


//        MediaMetadataRetrieverUtil.setDataSource(mediaMetadataRetriever, dataSource);
            return mediaMetadataRetriever.getFrameAtTime(timeUs);
        }
    }

    public static @Nullable
    String getDiscreteMimeType(@NonNull String mimeType) {
        final String[] sections = mimeType.split("/", 2);
        return sections.length > 1 ? sections[0] : null;
    }

    public static class ThumbnailData implements AutoCloseable {

        @NonNull
        private final Bitmap bitmap;
        private final float aspectRatio;

        public ThumbnailData(@NonNull Bitmap bitmap) {
            this.bitmap = bitmap;
            this.aspectRatio = (float) bitmap.getWidth() / (float) bitmap.getHeight();
        }

        public @NonNull
        Bitmap getBitmap() {
            return bitmap;
        }

        public float getAspectRatio() {
            return aspectRatio;
        }

//        public InputStream toDataStream() {
//            return BitmapUtil.toCompressedJpeg(bitmap);
//        }

        @Override
        public void close() {
            bitmap.recycle();
        }
    }

    private static boolean isSupportedVideoUriScheme(@Nullable String scheme) {
        return ContentResolver.SCHEME_CONTENT.equals(scheme) ||
                ContentResolver.SCHEME_FILE.equals(scheme);
    }

    public enum SlideType {
        GIF,
        IMAGE,
        VIDEO,
        AUDIO,
        MMS,
        LONG_TEXT,
        VIEW_ONCE,
        DOCUMENT
    }
}