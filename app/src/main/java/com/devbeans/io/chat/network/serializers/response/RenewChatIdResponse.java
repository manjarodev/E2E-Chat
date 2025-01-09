package com.devbeans.io.chat.network.serializers.response;

import com.devbeans.io.chat.models.Key;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RenewChatIdResponse {

    @SerializedName("code")
    @Expose
    String code;
    @SerializedName("key")
    @Expose
    Key key;


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }
}
