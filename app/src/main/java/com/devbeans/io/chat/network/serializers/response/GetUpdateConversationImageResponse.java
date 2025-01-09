package com.devbeans.io.chat.network.serializers.response;

import com.devbeans.io.chat.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetUpdateConversationImageResponse {
    @SerializedName(Constants.KEYS.STATUS)
    @Expose
    private String status;
    @SerializedName(Constants.KEYS.MESSAGE)
    @Expose
    private String message;
    @SerializedName(Constants.KEYS.IMAGE_BUCKET_LINK)
    @Expose
    private String image_bucket_link;


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

    public String getImage_bucket_link() {
        return image_bucket_link;
    }

    public void setImage_bucket_link(String image_bucket_link) {
        this.image_bucket_link = image_bucket_link;
    }


    @Override
    public String toString() {
        return "GetUpdateConversationImageResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", imageBucketLink='" + image_bucket_link + '\'' +
                '}';
    }
}
