package com.devbeans.io.chat.models;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Message implements Serializable {

    @SerializedName("senderId")
    private int senderId;

    @SerializedName("conversationId")
    private int conversationId;

    @SerializedName("receiverId")
    private int receiverId;

    @SerializedName("message")
    private String message;

    @SerializedName("isMe")
    private boolean isMe;

    @SerializedName("isPlaying")
    private boolean isPlaying;

    @SerializedName("type")
    private String type;

    public Message() {
    }

    public Message(int senderId, int receiverId, int conversationId, String message) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.conversationId = conversationId;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getConversationId() {
        return conversationId;
    }

    public void setConversationId(int conversationId) {
        this.conversationId = conversationId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isMe() {
        return isMe;
    }

    public void setMe(boolean me) {
        isMe = me;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "senderId=" + senderId +
                ", conversationId=" + conversationId +
                ", message='" + message + '\'' +
                ", isMe=" + isMe +
                '}';
    }
}

