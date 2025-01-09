package com.devbeans.io.chat.network.serializers.requestbody;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeaveOwnerGroupRequest {

    @SerializedName("userChatId")
    @Expose
    private String userChatId;

    @SerializedName("replacedId")
    @Expose
    private String replacedId;


    public String getUserChatId() {
        return userChatId;
    }

    public void setUserChatId(String userChatId) {
        this.userChatId = userChatId;
    }

    public String getReplacedId() {
        return replacedId;
    }

    public void setReplacedId(String replacedId) {
        this.replacedId = replacedId;
    }


    @Override
    public String toString() {
        return "LeaveOwnerGroupRequest{" +
                "userChatId='" + userChatId + '\'' +
                ", replacedId='" + replacedId + '\'' +
                '}';
    }
}
