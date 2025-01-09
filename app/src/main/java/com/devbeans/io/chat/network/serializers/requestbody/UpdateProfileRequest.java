package com.devbeans.io.chat.network.serializers.requestbody;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateProfileRequest {

    @SerializedName("chatNickName")
    @Expose
    private String nickName;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "UpdateProfileRequest{" +
                "nickName='" + nickName + '\'' +
                '}';
    }
}
