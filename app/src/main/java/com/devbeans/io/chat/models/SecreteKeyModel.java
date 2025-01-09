package com.devbeans.io.chat.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
@Entity
public class SecreteKeyModel {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("secreteKey")
    @Expose
    private byte[] secreteKey;

    @SerializedName("expiry")
    private long expiry;

    @SerializedName("isExpired")
    private boolean isExpired;


    @SerializedName("identifier")
    private String identifier;

    @SerializedName("conversation_id")
    private String conversation_id;

    public long getExpiry() {
        return this.expiry;
    }

    public void setExpiry(long expiry) {
        this.expiry = expiry;
    }

    public void setIsExpired(boolean isExpired) {
        this.isExpired = isExpired;
    }

    public boolean getIsExpired() {
        return isExpired;
    }

    public byte[] getSecreteKey() {
        return secreteKey;
    }

    public void setSecreteKey(byte[] secreteKey) {
        this.secreteKey = secreteKey;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String conversation_id) {
        this.conversation_id = conversation_id;
    }
}
