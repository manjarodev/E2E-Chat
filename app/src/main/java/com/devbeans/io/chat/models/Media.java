package com.devbeans.io.chat.models;


import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Optional;

/**
 * Represents a piece of media that the user has on their device.
 */
public class Media implements Parcelable {

    public static final String ALL_MEDIA_BUCKET_ID = "org.thoughtcrime.securesms.ALL_MEDIA";

    @SerializedName("uri")
    private final Uri uri;
    @SerializedName("mimeType")
    private final String mimeType;
    @SerializedName("date")
    private final long date;
    @SerializedName("width")
    private final int width;
    @SerializedName("height")
    private final int height;
    @SerializedName("size")
    private final long size;
    @SerializedName("duration")
    private final long duration;
    @SerializedName("borderless")
    private final boolean borderless;
    @SerializedName("videoGif")
    private final boolean videoGif;

    @SerializedName("bucketId")
    private Optional<String> bucketId;
    @SerializedName("caption")
    private Optional<String> caption;
//    private Optional<AttachmentDatabase.TransformProperties> transformProperties;

    public Media(@NonNull Uri uri,
                 @NonNull String mimeType,
                 long date,
                 int width,
                 int height,
                 long size,
                 long duration,
                 boolean borderless,
                 boolean videoGif,
                 Optional<String> bucketId,
                 Optional<String> caption) {
        this.uri = uri;
        this.mimeType = mimeType;
        this.date = date;
        this.width = width;
        this.height = height;
        this.size = size;
        this.duration = duration;
        this.borderless = borderless;
        this.videoGif = videoGif;
        this.bucketId = bucketId;
        this.caption = caption;

//        this.transformProperties = transformProperties;
    }

    protected Media(Parcel in) {
        uri = in.readParcelable(Uri.class.getClassLoader());
        mimeType = in.readString();
        date = in.readLong();
        width = in.readInt();
        height = in.readInt();
        size = in.readLong();
        duration = in.readLong();
        borderless = in.readInt() == 1;
        videoGif = in.readInt() == 1;
//        bucketId   = Optional.ofNullable(in.readString());
//        caption    = Optional.ofNullable(in.readString());
        try {
            String json = in.readString();
//            transformProperties = json == null ? Optional.empty() : Optional.ofNullable(JsonUtil.fromJson(json, AttachmentDatabase.TransformProperties.class));
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public Uri getUri() {
        return uri;
    }

    public String getMimeType() {
        return mimeType;
    }

    public long getDate() {
        return date;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public long getSize() {
        return size;
    }

    public long getDuration() {
        return duration;
    }

    public boolean isBorderless() {
        return borderless;
    }

    public boolean isVideoGif() {
        return videoGif;
    }

    public Optional<String> getBucketId() {
        return bucketId;
    }

    public Optional<String> getCaption() {
        return caption;
    }

//    public void setCaption(String caption) {
//        this.caption = Optional.ofNullable(caption);
//    }

//    public Optional<AttachmentDatabase.TransformProperties> getTransformProperties() {
//        return transformProperties;
//    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(uri, flags);
        dest.writeString(mimeType);
        dest.writeLong(date);
        dest.writeInt(width);
        dest.writeInt(height);
        dest.writeLong(size);
        dest.writeLong(duration);
        dest.writeInt(borderless ? 1 : 0);
        dest.writeInt(videoGif ? 1 : 0);
//        dest.writeString(bucketId.orElse(null));
//        dest.writeString(caption.orElse(null));
//        dest.writeString(transformProperties.map(JsonUtil::toJson).orElse(null));
    }

    public static final Creator<Media> CREATOR = new Creator<Media>() {
        @Override
        public Media createFromParcel(Parcel in) {
            return new Media(in);
        }

        @Override
        public Media[] newArray(int size) {
            return new Media[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Media media = (Media) o;

        return uri.equals(media.uri);
    }

    @Override
    public int hashCode() {
        return uri.hashCode();
    }

    public static @NonNull
    Media withMimeType(@NonNull Media media, @NonNull String newMimeType) {
        return new Media(media.getUri(),
                newMimeType,
                media.getDate(),
                media.getWidth(),
                media.getHeight(),
                media.getSize(),
                media.getDuration(),
                media.isBorderless(),
                media.isVideoGif(),
                media.getBucketId(),
                media.getCaption());
//                media.getTransformProperties());
    }
}
