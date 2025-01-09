package com.devbeans.io.chat.network.serializers.requestbody;

import static com.devbeans.io.chat.utils.Constants.KEYS.CONVERSATION_ID;
import static com.devbeans.io.chat.utils.Constants.KEYS.EXPIRY_TIME;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateConversationExpiry {

    @SerializedName(CONVERSATION_ID)
    @Expose
    String conversation_id;

    @SerializedName(EXPIRY_TIME)
    @Expose
    long expiry_time;

    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String conversation_id) {
        this.conversation_id = conversation_id;
    }

    public long getExpiry_time() {
        return expiry_time;
    }

    public void setExpiry_time(long expiry_time) {
        this.expiry_time = expiry_time;
    }


    @Override
    public String toString() {
        return "UpdateConversationExpiry{" +
                "conversation_id='" + conversation_id + '\'' +
                ", conversationExpiryTime=" + expiry_time +
                '}';
    }
}
