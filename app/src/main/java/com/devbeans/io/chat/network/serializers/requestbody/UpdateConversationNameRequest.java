package com.devbeans.io.chat.network.serializers.requestbody;

import static com.devbeans.io.chat.utils.Constants.KEYS.CONVERSATION_ID;
import static com.devbeans.io.chat.utils.Constants.KEYS.CONVERSATION_NAME;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateConversationNameRequest {

    @SerializedName(CONVERSATION_ID)
    @Expose
    private String conversation_id;

    @SerializedName(CONVERSATION_NAME)
    @Expose
    private String name;


    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String conversation_id) {
        this.conversation_id = conversation_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UpdateConversationNameRequest{" +
                "conversation_id='" + conversation_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
