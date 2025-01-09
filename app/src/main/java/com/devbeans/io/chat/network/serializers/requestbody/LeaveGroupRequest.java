package com.devbeans.io.chat.network.serializers.requestbody;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeaveGroupRequest {

    @SerializedName("userChatId")
    @Expose
    private String user_chat_id;


    public String getUser_chat_id() {
        return user_chat_id;
    }

    public void setUser_chat_id(String user_chat_id) {
        this.user_chat_id = user_chat_id;
    }
}
