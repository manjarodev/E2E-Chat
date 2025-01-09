package com.devbeans.io.chat.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
@Entity
public class KeyModel {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
   public int id;
    @SerializedName("fingerprint")
    @Expose
    private String fingerprint;

    @SerializedName("publicKeyPath")
    @Expose
    private String publicKeyPath;
    @SerializedName("privateKeyPath")
    @Expose
    private String privateKeyPath;

    @SerializedName("identifier")
    @Expose
    private byte[] identifer;



    public byte[] getIdentifer() {
        return identifer;
    }

    public void setIdentifer(byte[] identifer) {
        this.identifer = identifer;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getPublicKeyPath() {
        return publicKeyPath;
    }

    public void setPublicKeyPath(String publicKeyPath) {
        this.publicKeyPath = publicKeyPath;
    }

    public String getPrivateKeyPath() {
        return privateKeyPath;
    }

    public void setPrivateKeyPath(String privateKeyPath) {
        this.privateKeyPath = privateKeyPath;
    }


}
