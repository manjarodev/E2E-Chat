package com.devbeans.io.chat.network.serializers.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UploadMediaConversationResponse {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("file")
    @Expose
    private String file;

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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
