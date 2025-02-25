package com.devbeans.io.chat.models;


import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

//import org.thoughtcrime.securesms.audio.AudioHash;
//import org.thoughtcrime.securesms.blurhash.BlurHash;
//import org.thoughtcrime.securesms.database.AttachmentDatabase;
//import org.thoughtcrime.securesms.database.AttachmentDatabase.TransformProperties;
//import org.thoughtcrime.securesms.stickers.StickerLocator;

public abstract class Attachment {

    @NonNull
    @SerializedName("contentType")
    private final String contentType;
    @SerializedName("transferState")
    private final int transferState;
    @SerializedName("size")
    private final long size;

    @Nullable
    @SerializedName("fileName")
    private final String fileName;

    @SerializedName("cdnNumber")
    private final int cdnNumber;

    @Nullable
    @SerializedName("location")
    private final String location;

    @Nullable
    @SerializedName("key")
    private final String key;

    @Nullable
    @SerializedName("relay")
    private final String relay;

    @Nullable
    @SerializedName("digest")
    private final byte[] digest;

    @Nullable
    @SerializedName("fastPreflightId")
    private final String fastPreflightId;

    @SerializedName("voiceNote")
    private final boolean voiceNote;
    @SerializedName("borderless")
    private final boolean borderless;
    @SerializedName("videoGif")
    private final boolean videoGif;
    @SerializedName("width")
    private final int width;
    @SerializedName("height")
    private final int height;
    @SerializedName("quote")
    private final boolean quote;
    @SerializedName("uploadTimestamp")
    private final long uploadTimestamp;

    @Nullable
    @SerializedName("caption")
    private final String caption;

//    @Nullable
//    private final StickerLocator stickerLocator;
//
//    @Nullable
//    private final BlurHash blurHash;
//
//    @Nullable
//    private final AudioHash audioHash;
//
//    @NonNull
//    private final TransformProperties transformProperties;

    public Attachment(@NonNull String contentType, int transferState, long size, @Nullable String fileName, int cdnNumber, @Nullable String location, @Nullable String key, @Nullable String relay, @Nullable byte[] digest, @Nullable String fastPreflightId, boolean voiceNote, boolean borderless, boolean videoGif, int width, int height, boolean quote, long uploadTimestamp, @Nullable String caption
//                      @Nullable StickerLocator stickerLocator,
//                      @Nullable BlurHash blurHash,
//                      @Nullable AudioHash audioHash,
//                      @Nullable TransformProperties transformProperties)
    ) {
        this.contentType = contentType;
        this.transferState = transferState;
        this.size = size;
        this.fileName = fileName;
        this.cdnNumber = cdnNumber;
        this.location = location;
        this.key = key;
        this.relay = relay;
        this.digest = digest;
        this.fastPreflightId = fastPreflightId;
        this.voiceNote = voiceNote;
        this.borderless = borderless;
        this.videoGif = videoGif;
        this.width = width;
        this.height = height;
        this.quote = quote;
        this.uploadTimestamp = uploadTimestamp;
//        this.stickerLocator      = stickerLocator;
        this.caption = caption;
//        this.blurHash            = blurHash;
//        this.audioHash           = audioHash;
//        this.transformProperties = transformProperties != null ? transformProperties : TransformProperties.empty();
    }

    @Nullable
    public abstract Uri getUri();

    public abstract @Nullable
    Uri getPublicUri();

    public int getTransferState() {
        return transferState;
    }

//    public boolean isInProgress() {
//        return transferState != AttachmentDatabase.TRANSFER_PROGRESS_DONE &&
//                transferState != AttachmentDatabase.TRANSFER_PROGRESS_FAILED;
//    }

    public long getSize() {
        return size;
    }

    @Nullable
    public String getFileName() {
        return fileName;
    }

    @NonNull
    public String getContentType() {
        return contentType;
    }

    public int getCdnNumber() {
        return cdnNumber;
    }

    @Nullable
    public String getLocation() {
        return location;
    }

    @Nullable
    public String getKey() {
        return key;
    }

    @Nullable
    public String getRelay() {
        return relay;
    }

    @Nullable
    public byte[] getDigest() {
        return digest;
    }

    @Nullable
    public String getFastPreflightId() {
        return fastPreflightId;
    }

    public boolean isVoiceNote() {
        return voiceNote;
    }

    public boolean isBorderless() {
        return borderless;
    }

    public boolean isVideoGif() {
        return videoGif;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isQuote() {
        return quote;
    }

    public long getUploadTimestamp() {
        return uploadTimestamp;
    }

//    public boolean isSticker() {
//        return stickerLocator != null;
//    }

//    public @Nullable StickerLocator getSticker() {
//        return stickerLocator;
//    }
//
//    public @Nullable BlurHash getBlurHash() {
//        return blurHash;
//    }
//
//    public @Nullable AudioHash getAudioHash() {
//        return audioHash;
//    }

    public @Nullable
    String getCaption() {
        return caption;
    }

//    public @NonNull TransformProperties getTransformProperties() {
//        return transformProperties;
//    }
}
