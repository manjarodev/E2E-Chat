package com.devbeans.io.chat.network.serializers.requestbody;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EnrollmentRequest {

    @SerializedName("license_id")
    @Expose
    private String licenseId;

    @SerializedName("device_id")
    @Expose
    private String deviceId;

    @SerializedName("device_name")
    @Expose
    private String deviceName;
    public EnrollmentRequest(String licenseId, String deviceId, String deviceName) {
        this.licenseId = licenseId;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
