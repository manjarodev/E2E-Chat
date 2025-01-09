package com.devbeans.io.chat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EncryptedPayload {
    @SerializedName("data")
    @Expose
    private String data;

    @SerializedName("fake")
    @Expose
    private String fake;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFake() {
        return fake;
    }

    public void setFake(String fake) {
        this.fake = fake;
    }
}
