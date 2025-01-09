package com.devbeans.io.chat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Key {
    @SerializedName("acknowledged")
    @Expose
    private Boolean acknowledged;
    @SerializedName("modifiedCount")
    @Expose
    private Integer modifiedCount;
    @SerializedName("upsertedId")
    @Expose
    private Object upsertedId;
    @SerializedName("upsertedCount")
    @Expose
    private Integer upsertedCount;
    @SerializedName("matchedCount")
    @Expose
    private Integer matchedCount;

    public Boolean getAcknowledged() {
        return acknowledged;
    }

    public void setAcknowledged(Boolean acknowledged) {
        this.acknowledged = acknowledged;
    }

    public Integer getModifiedCount() {
        return modifiedCount;
    }

    public void setModifiedCount(Integer modifiedCount) {
        this.modifiedCount = modifiedCount;
    }

    public Object getUpsertedId() {
        return upsertedId;
    }

    public void setUpsertedId(Object upsertedId) {
        this.upsertedId = upsertedId;
    }

    public Integer getUpsertedCount() {
        return upsertedCount;
    }

    public void setUpsertedCount(Integer upsertedCount) {
        this.upsertedCount = upsertedCount;
    }

    public Integer getMatchedCount() {
        return matchedCount;
    }

    public void setMatchedCount(Integer matchedCount) {
        this.matchedCount = matchedCount;
    }
}
