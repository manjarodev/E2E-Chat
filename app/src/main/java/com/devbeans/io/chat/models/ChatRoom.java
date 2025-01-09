package com.devbeans.io.chat.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Data;

@Data
//**********************************************
public class ChatRoom implements Serializable
//**********************************************
{
    @SerializedName("img")
    int img;
    @SerializedName("chatName")
    String chatName;
    @SerializedName("lastMessage")
    String lastMessage;
    @SerializedName("lastMessageTime")
    String lastMessageTime;

    boolean isArchived;

    public ChatRoom() {
    }

    public ChatRoom(int img, String chatName, String lastMessage, String lastMessageTime, boolean isArchived) {
        this.img = img;
        this.chatName = chatName;
        this.lastMessage = lastMessage;
        this.lastMessageTime = lastMessageTime;
        this.isArchived = isArchived;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getLastMessageTime() {
        return lastMessageTime;
    }

    public void setLastMessageTime(String lastMessageTime) {
        this.lastMessageTime = lastMessageTime;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }
}
