package com.devbeans.io.chat.models;


import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;
import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.commons.models.MessageContentType;

import java.io.Serializable;
import java.util.Date;

public class Messages implements
        IMessage,
        MessageContentType.Image, /*this is for default image messages implementation*/
        MessageContentType,/*and this one is for custom content type (in this case - voice message)*/
        MessageContentType.PayloadCheck,
        Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("text")
    private String text;
    @SerializedName("createdAt")
    private Date createdAt;
    @SerializedName("user")
    private User user;
    @SerializedName("image")
    private Image image;
    @SerializedName("voice")
    private Voice voice;
    @SerializedName("video")
    private Video video;
    @SerializedName("file")
    private File file;
    @SerializedName("filePath")
    private String filePath;
    @SerializedName("isPlaying")
    boolean isPlaying = false;
    @SerializedName("isSelected")
    boolean isSelected = false;

    private Payload payload;

    public Messages(String id, User user, String text) {
        this(id, user, text, new Date());
    }

    public Messages(String id, User user, String text, Date createdAt) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.createdAt = createdAt;
    }

    public Messages() {
    }

    @Override
    public String getId() {
        return payload.getMessageId();
    }

    @Override
    public String getText() {
        return text;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public User getUser() {
        return this.user;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public Payload getPayload() {
        return payload;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    @Override
    public String getImageUrl() {
        return image == null ? null : image.url;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Voice getVoice() {
        return voice;
    }

    public String getStatus() {
        return "Sent";
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    @Nullable
    @Override
    public String getPayloadType() {
        if (payload != null && payload.getType() != null)
            return payload.getType();
        else {
            return "";
        }
    }

    @Override
    public boolean getIsConfidentialType() {
        return payload.isConfidential();
    }

    @Override
    public boolean getIsViewOnceType() {
        return payload.isViewOnce();
    }

    public static class Image implements Serializable {

        private String url;

        public Image(String url) {
            this.url = url;
        }
    }

    public static class Voice implements Serializable {

        private String url;
        private int duration;

        public Voice(String url, int duration) {
            this.url = url;
            this.duration = duration;
        }

        public String getUrl() {
            return url;
        }

        public int getDuration() {
            return duration;
        }
    }

    public static class Video implements Serializable {

        private String url;
        private int duration;

        public Video(String url, int duration) {
            this.url = url;
            this.duration = duration;
        }

        public String getUrl() {
            return url;
        }

        public int getDuration() {
            return duration;
        }
    }

    public static class File implements Serializable {

        private String url;
        private int duration;

        public File(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

    }

    @Override
    public String toString() {
        return "\n\n\nMessages{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", createdAt=" + createdAt +
                ", user=" + user +
                ", image=" + image +
                ", voice=" + voice +
                ", video=" + video +
                ", file=" + file +
                ", filePath='" + filePath + '\'' +
                ", isPlaying=" + isPlaying +
                ", payload=" + payload +
                "} +\n\n\n";
    }
}