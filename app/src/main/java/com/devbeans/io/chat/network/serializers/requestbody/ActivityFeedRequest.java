package com.devbeans.io.chat.network.serializers.requestbody;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActivityFeedRequest {
    @SerializedName("device_id")
    @Expose
    private String deviceId;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("state")
    @Expose
    private String state;

    public ActivityFeedRequest(String deviceId, String message, String userName, String state) {
        this.deviceId = deviceId;
        this.message = message;
        this.userName = userName;
        this.state = state;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
