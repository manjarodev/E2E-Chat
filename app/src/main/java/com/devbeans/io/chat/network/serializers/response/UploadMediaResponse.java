package com.devbeans.io.chat.network.serializers.response;

import com.devbeans.io.chat.models.MetaData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UploadMediaResponse{
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("media")
    @Expose
    private String media;
    @SerializedName("metaData")
    @Expose
    private MetaData metaData;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    @Override
    public String toString() {
        return "UploadMediaResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", media='" + media + '\'' +
                ", metaData=" + metaData +
                '}';
    }
}
