package com.devbeans.io.chat.models;


import com.google.gson.annotations.SerializedName;

public class SettingsModel {

    @SerializedName("icon")
    private int icon;
    @SerializedName("heading")
    private String heading;
    @SerializedName("message")
    private String message;


    public SettingsModel() {

    }

    public SettingsModel(int icon, String heading, String message) {
        this.icon = icon;
        this.heading = heading;
        this.message = message;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
