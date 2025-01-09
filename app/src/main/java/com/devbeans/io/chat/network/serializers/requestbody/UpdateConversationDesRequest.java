package com.devbeans.io.chat.network.serializers.requestbody;

import static com.devbeans.io.chat.utils.Constants.KEYS.CONVERSATION_DESCRIPTION;
import static com.devbeans.io.chat.utils.Constants.KEYS.CONVERSATION_ID;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateConversationDesRequest {

    @SerializedName(CONVERSATION_DESCRIPTION)
    @Expose
    private String description;

    @SerializedName(CONVERSATION_ID)
    @Expose
    private String conversation_id;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String conversation_id) {
        this.conversation_id = conversation_id;
    }

    @Override
    public String toString() {
        return "UpdateConversationDesRequest{" +
                "description='" + description + '\'' +
                ", conversation_id='" + conversation_id + '\'' +
                '}';
    }
}
