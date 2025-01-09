package com.devbeans.io.chat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetaData {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("fileLink")
    @Expose
    private String fileLink;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("extention")
    @Expose
    private String extention;
    @SerializedName("sizeUnit")
    @Expose
    private String sizeUnit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public String getSizeUnit() {
        return sizeUnit;
    }

    public void setSizeUnit(String sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "name='" + name + '\'' +
                ", fileLink='" + fileLink + '\'' +
                ", size=" + size +
                ", extention='" + extention + '\'' +
                ", sizeUnit='" + sizeUnit + '\'' +
                '}';
    }
}
