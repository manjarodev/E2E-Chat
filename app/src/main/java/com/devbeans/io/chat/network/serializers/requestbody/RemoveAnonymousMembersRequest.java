package com.devbeans.io.chat.network.serializers.requestbody;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RemoveAnonymousMembersRequest {
    @SerializedName("member")
    @Expose
    private String members = null;

    @SerializedName("userChatId")
    @Expose
    private String userChatId;


    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getUserChatId() {
        return userChatId;
    }

    public void setUserChatId(String userChatId) {
        this.userChatId = userChatId;
    }
}
