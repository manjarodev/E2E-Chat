package com.devbeans.io.chat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0005wxyz{B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010f\u001a\u00020g2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020g0iJ\b\u0010j\u001a\u00020kH\u0007J\b\u0010l\u001a\u00020kH\u0007J\b\u0010m\u001a\u00020kH\u0007J\u0006\u0010n\u001a\u00020kJ\b\u0010o\u001a\u00020kH\u0007J\b\u0010p\u001a\u00020kH\u0007J\b\u0010q\u001a\u00020kH\u0007J\b\u0010r\u001a\u00020kH\u0007J\b\u0010s\u001a\u00020kH\u0007J\b\u0010t\u001a\u00020kH\u0007J\u000e\u0010u\u001a\u00020\u00102\u0006\u0010v\u001a\u00020/R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\'\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u000e\u0010*\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020/X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0012\"\u0004\bI\u0010\u0014R\u000e\u0010J\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001c\u0010L\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0017\"\u0004\bN\u0010\u0019R\u0014\u0010O\u001a\u0004\u0018\u00010P8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00040\u001fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\bR\u0010!\"\u0004\bS\u0010#R\u0011\u0010T\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\bU\u0010\u0012R\"\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00040\u001fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\bW\u0010!\"\u0004\bX\u0010#R\"\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00040\u001fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\bZ\u0010!\"\u0004\b[\u0010#R\u000e\u0010\\\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\"\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00040\u001fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\ba\u0010!\"\u0004\bb\u0010#R\"\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\bd\u0010!\"\u0004\be\u0010#\u00a8\u0006|"}, d2 = {"Lcom/devbeans/io/chat/utils/Constants;", "", "()V", "CAMERA_PERMISSIONS", "", "CHANGE_OWNER", "CHAT_DETAILS_ADD_MEMBER", "CONTACTS_DETAILS_ACTIVITY", "CONVERSATION_ID", "DELIVERED", "DOWNLOADER_ONE_TO_ONE", "END_POINT", "FILE_NOT_EXIST", "FIRST_RUN", "GRANT_PERMISSION", "IVSALT", "", "getIVSALT", "()[B", "setIVSALT", "([B)V", "ImageBucketLink", "getImageBucketLink", "()Ljava/lang/String;", "setImageBucketLink", "(Ljava/lang/String;)V", "LEAVE_GROUP", "MD5", "MEMBERS_COUNT", "MESSAGE", "MESSAGE_TYPE", "", "getMESSAGE_TYPE", "()[Ljava/lang/String;", "setMESSAGE_TYPE", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "NICK_NAME", "NOMEDIA", "NONCE", "getNONCE", "setNONCE", "NOT_DELIVERED", "NO_DATA_FOUND", "ON_SUCCESS", "PCAPITAL", "PERMISSION_CALL_PHONE", "", "PERMISSION_CAMERA", "PERMISSION_GET_ACCOUNTS", "PERMISSION_MEDIA_LOCATION", "PERMISSION_POST_NOTIFICATIONS", "PERMISSION_READ_CALENDAR", "PERMISSION_READ_CALL_LOG", "PERMISSION_READ_CONTACTS", "PERMISSION_READ_MEDIA_AUDIO", "PERMISSION_READ_MEDIA_IMAGES", "PERMISSION_READ_MEDIA_VIDEO", "PERMISSION_READ_PHONE_STATE", "PERMISSION_READ_SMS", "PERMISSION_READ_STORAGE", "PERMISSION_RECORD_AUDIO", "PERMISSION_SEND_SMS", "PERMISSION_WRITE_CALENDAR", "PERMISSION_WRITE_CALL_LOG", "PERMISSION_WRITE_CONTACTS", "PERMISSION_WRITE_STORAGE", "PPATTERN", "PROVIDER", "REQUEST", "RESPONSE", "SALT_SYMMETRIC_PARAM", "getSALT_SYMMETRIC_PARAM", "setSALT_SYMMETRIC_PARAM", "SEEN", "SENT", "TITLE", "getTITLE", "setTITLE", "URI", "Landroid/net/Uri;", "audio", "getAudio", "setAudio", "byte", "getByte", "file", "getFile", "setFile", "image", "getImage", "setImage", "isDialog", "isDialogAppLock", "isThemeSwitch", "isTimerSet", "mimeTypes", "getMimeTypes", "setMimeTypes", "video", "getVideo", "setVideo", "ensureBackgroundThread", "", "callback", "Lkotlin/Function0;", "isMarshmallowPlus", "", "isNougatMR1Plus", "isNougatPlus", "isOnMainThread", "isOreoMr1Plus", "isOreoPlus", "isPiePlus", "isQPlus", "isRPlus", "isSPlus", "shorten", "length", "DISAPPEARING_STRINGS", "KEYS", "LOCK", "SETTINGS", "TYPES", "app_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.Constants INSTANCE = null;
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmField
    public static java.lang.String NICK_NAME;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String NOT_DELIVERED = "0";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SENT = "1";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DELIVERED = "2";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SEEN = "3";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PCAPITAL = "(?=.*[A-Z])";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PPATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,24})";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String END_POINT = "End Point:";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String RESPONSE = " Response: ";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String REQUEST = " Request: ";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String GRANT_PERMISSION = "Grant permissions to use gallery";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FILE_NOT_EXIST = "File does not exist";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String NO_DATA_FOUND = "No data found";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PROVIDER = ".provider";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CONTACTS_DETAILS_ACTIVITY = "ContactDetailActivity blockUser: ";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CHAT_DETAILS_ADD_MEMBER = "Chat Details Activity AddMember: ";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MESSAGE = "onMessage: ";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ON_SUCCESS = "onSuccess: ";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CONVERSATION_ID = "conversation_id=";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MEMBERS_COUNT = "%d of %d";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DOWNLOADER_ONE_TO_ONE = "Downloader One to One";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CHANGE_OWNER = "Change Owner";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String LEAVE_GROUP = "Leave Group";
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmField
    public static android.net.Uri URI;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CAMERA_PERMISSIONS = "android.permission.CAMERA";
    @org.jetbrains.annotations.Nullable
    private static java.lang.String TITLE;
    @org.jetbrains.annotations.NotNull
    private static byte[] SALT_SYMMETRIC_PARAM;
    @org.jetbrains.annotations.NotNull
    private static byte[] NONCE;
    @org.jetbrains.annotations.NotNull
    private static byte[] IVSALT;
    @org.jetbrains.annotations.NotNull
    private static java.lang.String ImageBucketLink = "imageBucketLink";
    @org.jetbrains.annotations.NotNull
    private static java.lang.String[] MESSAGE_TYPE = {"text", "image", "video", "audio", "file"};
    @org.jetbrains.annotations.NotNull
    private static java.lang.String[] mimeTypes = {"application/msword", "application/pdf", "text/plain", "audio/*", "video/mp4", "image/*"};
    @org.jetbrains.annotations.NotNull
    private static java.lang.String[] image = {"image/*", "video/mp4"};
    @org.jetbrains.annotations.NotNull
    private static java.lang.String[] video = {"video/mp4"};
    @org.jetbrains.annotations.NotNull
    private static java.lang.String[] file = {"application/pdf"};
    @org.jetbrains.annotations.NotNull
    private static java.lang.String[] audio = {"audio/*"};
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FIRST_RUN = "FIRST_RUN";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String isDialog = "isDialogShown";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String isDialogAppLock = "isDialogDeviceShown";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String isThemeSwitch = "theme.switch";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String isTimerSet = "auto.lock.timer";
    public static final int PERMISSION_READ_STORAGE = 1;
    public static final int PERMISSION_WRITE_STORAGE = 2;
    public static final int PERMISSION_CAMERA = 3;
    public static final int PERMISSION_RECORD_AUDIO = 4;
    public static final int PERMISSION_READ_CONTACTS = 5;
    public static final int PERMISSION_WRITE_CONTACTS = 6;
    public static final int PERMISSION_READ_CALENDAR = 7;
    public static final int PERMISSION_WRITE_CALENDAR = 8;
    public static final int PERMISSION_CALL_PHONE = 9;
    public static final int PERMISSION_READ_CALL_LOG = 10;
    public static final int PERMISSION_WRITE_CALL_LOG = 11;
    public static final int PERMISSION_GET_ACCOUNTS = 12;
    public static final int PERMISSION_READ_SMS = 13;
    public static final int PERMISSION_SEND_SMS = 14;
    public static final int PERMISSION_READ_PHONE_STATE = 15;
    public static final int PERMISSION_MEDIA_LOCATION = 16;
    public static final int PERMISSION_POST_NOTIFICATIONS = 17;
    public static final int PERMISSION_READ_MEDIA_IMAGES = 18;
    public static final int PERMISSION_READ_MEDIA_VIDEO = 19;
    public static final int PERMISSION_READ_MEDIA_AUDIO = 20;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String NOMEDIA = ".nomedia";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MD5 = "MD5";
    
    private Constants() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTITLE() {
        return null;
    }
    
    public final void setTITLE(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final byte[] getSALT_SYMMETRIC_PARAM() {
        return null;
    }
    
    public final void setSALT_SYMMETRIC_PARAM(@org.jetbrains.annotations.NotNull
    byte[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final byte[] getNONCE() {
        return null;
    }
    
    public final void setNONCE(@org.jetbrains.annotations.NotNull
    byte[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final byte[] getIVSALT() {
        return null;
    }
    
    public final void setIVSALT(@org.jetbrains.annotations.NotNull
    byte[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getImageBucketLink() {
        return null;
    }
    
    public final void setImageBucketLink(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final byte[] shorten(int length) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final byte[] getByte() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] getMESSAGE_TYPE() {
        return null;
    }
    
    public final void setMESSAGE_TYPE(@org.jetbrains.annotations.NotNull
    java.lang.String[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] getMimeTypes() {
        return null;
    }
    
    public final void setMimeTypes(@org.jetbrains.annotations.NotNull
    java.lang.String[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] getImage() {
        return null;
    }
    
    public final void setImage(@org.jetbrains.annotations.NotNull
    java.lang.String[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] getVideo() {
        return null;
    }
    
    public final void setVideo(@org.jetbrains.annotations.NotNull
    java.lang.String[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] getFile() {
        return null;
    }
    
    public final void setFile(@org.jetbrains.annotations.NotNull
    java.lang.String[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] getAudio() {
        return null;
    }
    
    public final void setAudio(@org.jetbrains.annotations.NotNull
    java.lang.String[] p0) {
    }
    
    public final boolean isOnMainThread() {
        return false;
    }
    
    @androidx.annotation.ChecksSdkIntAtLeast(api = android.os.Build.VERSION_CODES.M)
    public final boolean isMarshmallowPlus() {
        return false;
    }
    
    @androidx.annotation.ChecksSdkIntAtLeast(api = android.os.Build.VERSION_CODES.N)
    public final boolean isNougatPlus() {
        return false;
    }
    
    @androidx.annotation.ChecksSdkIntAtLeast(api = android.os.Build.VERSION_CODES.N_MR1)
    public final boolean isNougatMR1Plus() {
        return false;
    }
    
    @androidx.annotation.ChecksSdkIntAtLeast(api = android.os.Build.VERSION_CODES.O)
    public final boolean isOreoPlus() {
        return false;
    }
    
    @androidx.annotation.ChecksSdkIntAtLeast(api = android.os.Build.VERSION_CODES.O_MR1)
    public final boolean isOreoMr1Plus() {
        return false;
    }
    
    @androidx.annotation.ChecksSdkIntAtLeast(api = android.os.Build.VERSION_CODES.P)
    public final boolean isPiePlus() {
        return false;
    }
    
    @androidx.annotation.ChecksSdkIntAtLeast(api = android.os.Build.VERSION_CODES.Q)
    public final boolean isQPlus() {
        return false;
    }
    
    @androidx.annotation.ChecksSdkIntAtLeast(api = android.os.Build.VERSION_CODES.R)
    public final boolean isRPlus() {
        return false;
    }
    
    @androidx.annotation.ChecksSdkIntAtLeast(api = android.os.Build.VERSION_CODES.S)
    public final boolean isSPlus() {
        return false;
    }
    
    public final void ensureBackgroundThread(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b<\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2 = {"Lcom/devbeans/io/chat/utils/Constants$KEYS;", "", "()V", "BLOCK", "", "CHAT_USER_ID", "CONVERSATION_DESCRIPTION", "CONVERSATION_EXPIRY_TIME", "CONVERSATION_ID", "CONVERSATION_IS_CONFIDENTIAL", "CONVERSATION_IS_MEDIA_SHARE_RESTRICT", "CONVERSATION_NAME", "CONVERSATION_OBJ", "DUMMY_IMAGE", "EXPIRY_TIME", "IMAGEBUCKETLINK", "IMAGE_BUCKET_LINK", "INTENT_BUNDLE", "INTENT_CONTACT", "INTENT_CONTACT_FILE", "INTENT_CONVERSATION", "INTENT_CONVERSATION_EXPIRY", "INTENT_DISAPPEARING", "INTENT_DISAPPEAR_TIME", "INTENT_DISAPPEAR_TIME_RESULT", "INTENT_DRAWABLE", "INTENT_FILE", "INTENT_FILE_PATH", "INTENT_FILE_SELECTED", "INTENT_FROM_AUTO_LOCK", "INTENT_FROM_CAMERA", "INTENT_FROM_FORWARD", "INTENT_FROM_REMOVE_VIEW_ACTIVITY", "INTENT_FROM_SPLASH", "INTENT_FROM_WIPE_DATA", "INTENT_IK", "INTENT_IS_FROM_VAULT", "INTENT_MEDIA_PATH", "INTENT_MEDIA_URI", "INTENT_MEMBER_ID", "INTENT_MEMBER_LIST", "INTENT_MEMBER_NAME", "INTENT_NEW_CONVERSATION", "INTENT_NO_CONTACT", "INTENT_PAYLOAD", "INTENT_SELECTED_FILE", "INTENT_SENDER_ID", "INTENT_SIK", "INTENT_SIK_X", "INTENT_TYPE", "INTENT_URI_FROM_VAULT", "INTENT_VIEW_ONCE", "INTENT_VIEW_ONCE_CHAT", "IS_VIEW_ONCE", "MEDIA", "MEDIA_TYPE", "MEMBER", "MEMBERS", "MESSAGE", "REMOVE_MEMBER", "STATUS", "UNBLOCK", "USER_CHAT_ID", "WAS_SHOWING", "app_debug"})
    public static final class KEYS {
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.Constants.KEYS INSTANCE = null;
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_FROM_SPLASH = "com.From.SplashFragment";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String WAS_SHOWING = "com.wasShowing.dialog";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_FROM_AUTO_LOCK = "settings.from.auto.lock";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_FROM_WIPE_DATA = "settings.from.wipe.data";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_DRAWABLE = "wallpaper.drawable";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_FILE = "wallpaper.file";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_SIK = "SIK";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_SIK_X = "SIK.X";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_IK = "IK";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String USER_CHAT_ID = "userChatId";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CHAT_USER_ID = "chatUserId";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONVERSATION_ID = "conversationId";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String IS_VIEW_ONCE = "isViewOnce";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONVERSATION_DESCRIPTION = "description";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONVERSATION_NAME = "name";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONVERSATION_EXPIRY_TIME = "conversationExpiryTime";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONVERSATION_IS_CONFIDENTIAL = "isConfidential";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONVERSATION_IS_MEDIA_SHARE_RESTRICT = "isMediaShareRestrict";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String STATUS = "status";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String MESSAGE = "message";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String IMAGE_BUCKET_LINK = "imageBucketLink";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String MEDIA = "media";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String MEDIA_TYPE = "mediaType";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String MEMBER = "member";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String MEMBERS = "members";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String REMOVE_MEMBER = "Remove member";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_FILE_PATH = "filePath";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_VIEW_ONCE = "intent_view_once";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_VIEW_ONCE_CHAT = "intent_view_once_chat";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_BUNDLE = "intent_bundle";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_NEW_CONVERSATION = "new conversation";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_CONTACT = "contact";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_NO_CONTACT = "no contact";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_CONVERSATION = "conversation";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_FROM_FORWARD = "from_forward";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_URI_FROM_VAULT = "uriFromVault";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_IS_FROM_VAULT = "isFromVault";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_TYPE = "type";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_FROM_REMOVE_VIEW_ACTIVITY = "remove_view_activity";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String DUMMY_IMAGE = "image_test_092.jpg";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String EXPIRY_TIME = "expiryTime";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_MEMBER_ID = "member_id";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_FILE_SELECTED = "file_selected";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_MEMBER_NAME = "member_name";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_MEMBER_LIST = "member_list";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_MEDIA_URI = "uri";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_MEDIA_PATH = "path";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_DISAPPEARING = "disapearing";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_DISAPPEAR_TIME = "dispear_time";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_DISAPPEAR_TIME_RESULT = "dispear_time_result";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_CONVERSATION_EXPIRY = "conversation_expiry_time";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_PAYLOAD = "message.payload";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String BLOCK = "Block";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String UNBLOCK = "Unblock";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String IMAGEBUCKETLINK = "imageBucketLink";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONVERSATION_OBJ = "conversationObj";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_SENDER_ID = "chat.senderId";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_FROM_CAMERA = "chat.camera";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_SELECTED_FILE = "chat.selected.File";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String INTENT_CONTACT_FILE = "chat.contacts.exported";
        
        private KEYS() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/devbeans/io/chat/utils/Constants$DISAPPEARING_STRINGS;", "", "()V", "_10_days", "", "_10_minutes", "_10_seconds", "_12_hours", "_1_day", "_1_hour", "_1_minute", "_2_hours", "_30_minutes", "_30_seconds", "_3_hours", "_5_days", "_5_minutes", "_8_hours", "_burn_on_read", "_d", "", "_days", "_ds", "_f", "_h", "_hours", "_m", "_minutes", "_off", "_s", "_seconds", "_week", "app_debug"})
    public static final class DISAPPEARING_STRINGS {
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.Constants.DISAPPEARING_STRINGS INSTANCE = null;
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _off = "Off";
        public static final int _f = -1;
        public static final int _ds = 0;
        public static final int _s = 1;
        public static final int _m = 2;
        public static final int _h = 3;
        public static final int _d = 4;
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _burn_on_read = "View Once";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _10_seconds = "10 seconds";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _30_seconds = "30 seconds";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _1_minute = "1 minute";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _5_minutes = "5 minutes";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _10_minutes = "10 minutes";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _30_minutes = "30 minutes";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _1_hour = "1 hour";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _2_hours = "2 hours";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _3_hours = "3 hours";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _8_hours = "8 hours";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _12_hours = "12 hours";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _1_day = "1 day";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _5_days = "5 days";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _10_days = "10 days";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _seconds = "seconds";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _minutes = "minutes";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _hours = "hours";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _days = "days";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String _week = "weeks";
        
        private DISAPPEARING_STRINGS() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b@\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2 = {"Lcom/devbeans/io/chat/utils/Constants$TYPES;", "", "()V", "ACK_CON_EX_CHANGE", "", "ACK_DELETE", "ACK_DELIVER", "ACK_EDIT", "ACK_IS_VIEW_ONCE", "ACK_READ", "ADMIN_ASSIGNED", "ADMIN_REMOVED", "ANONYMOUS_GROUP_CONV_CREATED", "AUDIO", "BLOCK", "CHANGE_OWNER", "CONFIRM_ACK_ADMIN_ASSIGNED", "CONFIRM_ACK_ADMIN_REMOVED", "CONFIRM_ACK_BLOCK", "CONFIRM_ACK_BLOCK_UNKNOWN", "CONFIRM_ACK_DELETE", "CONFIRM_ACK_DELIVER", "CONFIRM_ACK_DESTROY_GROUP", "CONFIRM_ACK_EDIT", "CONFIRM_ACK_GROUP_CONV_CREATED", "CONFIRM_ACK_GROUP_DES_CHANGE", "CONFIRM_ACK_GROUP_ICON_CHANGE", "CONFIRM_ACK_GROUP_NAME_CHANGE", "CONFIRM_ACK_IS_CONFIDENTIAL_CHANGE", "CONFIRM_ACK_IS_MEDIA_SHARE_RESTRICT_CHANGE", "CONFIRM_ACK_IS_VIEW_ONCE", "CONFIRM_ACK_KEY_DEFICIENCY", "CONFIRM_ACK_LEAVE_GROUP", "CONFIRM_ACK_MEMBER_ADD", "CONFIRM_ACK_MEMBER_LEAVE", "CONFIRM_ACK_MEMBER_REMOVE", "CONFIRM_ACK_READ", "CONFIRM_ACK_UNBLOCK", "CONFIRM_ACK_VIEW_ONCE", "CONFIRM_ANONYMOUS_GROUP_CONV_CREATED", "CONVERSATION_GROUP", "CONVERSATION_GROUP_ANONYMOUS", "CONVERSATION_ONE_TO_ONE", "DELETE", "DESTROY_GROUP", "EDIT", "EXPIRE_MSG", "EXPIRE_MSG_SELF", "FILE", "GROUP_CONV_CREATED", "GROUP_DES_CHANGE", "GROUP_ICON_CHANGE", "GROUP_IS_CONFIDENTIAL_CHANGE", "GROUP_IS_MEDIA_SHARE_RESTRICT_CHANGE", "GROUP_NAME_CHANGE", "IMAGE", "KEY_DEFICIENCY", "MEDIA", "MEMBER_ADDED", "MEMBER_LEAVE", "MEMBER_REMOVED", "PING", "PONG", "SIR", "TEXT", "UNBLOCK", "VIDEO", "VIEW_ONCE", "app_debug"})
    public static final class TYPES {
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.Constants.TYPES INSTANCE = null;
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String PONG = "pong";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String PING = "ping";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONVERSATION_ONE_TO_ONE = "one-to-one";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONVERSATION_GROUP = "group";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONVERSATION_GROUP_ANONYMOUS = "anonymous";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String MEDIA = "media";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String SIR = "SIR";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String TEXT = "text";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String FILE = "file";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String IMAGE = "image";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String AUDIO = "audio";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String VIDEO = "video";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String EDIT = "edit";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String DELETE = "delete";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String MEMBER_ADDED = "member_added";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String MEMBER_REMOVED = "member_removed";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ADMIN_ASSIGNED = "admin_assigned";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ADMIN_REMOVED = "admin_removed";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String MEMBER_LEAVE = "member_leave";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CHANGE_OWNER = "change_owner";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String EXPIRE_MSG = "conv_expiry";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String EXPIRE_MSG_SELF = "conv_expiry_self";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String GROUP_NAME_CHANGE = "group_name_change";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ANONYMOUS_GROUP_CONV_CREATED = "annonymouns_conv_created";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String VIEW_ONCE = "view_once";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String GROUP_CONV_CREATED = "conv_created";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String GROUP_ICON_CHANGE = "group_icon_change";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String GROUP_DES_CHANGE = "group_description_change";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String GROUP_IS_CONFIDENTIAL_CHANGE = "group_is_confidential_change";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String GROUP_IS_MEDIA_SHARE_RESTRICT_CHANGE = "group_is_media_share_restrict_change";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String DESTROY_GROUP = "destroy_group";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String BLOCK = "block";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String UNBLOCK = "unblock";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_DEFICIENCY = "key_deficiency";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACK_EDIT = "ack_edit";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACK_DELETE = "ack_delete";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACK_READ = "ack_read";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACK_IS_VIEW_ONCE = "ack_is_view_once";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACK_DELIVER = "ack_deliver";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_READ = "confirm_ack_read";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_IS_VIEW_ONCE = "confirm_ack_is_view_once";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_DELIVER = "confirm_ack_deliver";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_EDIT = "confirm_ack_edit";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_DELETE = "confirm_ack_delete";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_MEMBER_ADD = "confirm_ack_member_add";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_MEMBER_REMOVE = "confirm_ack_member_remove";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_MEMBER_LEAVE = "confirm_ack_member_leave";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_ADMIN_ASSIGNED = "confirm_ack_admin_assigned";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_ADMIN_REMOVED = "confirm_ack_admin_removed";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_GROUP_ICON_CHANGE = "confirm_ack_group_icon_change";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_GROUP_NAME_CHANGE = "confirm_ack_group_name_change";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_GROUP_DES_CHANGE = "confirm_ack_group_description_change";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_GROUP_CONV_CREATED = "confirm_ack_conv_created";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ANONYMOUS_GROUP_CONV_CREATED = "confirm_ack_annonymouns_conv_created";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_KEY_DEFICIENCY = "confirm_ack_key_deficiency";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACK_CON_EX_CHANGE = "confirm_ack_conv_expiry";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_LEAVE_GROUP = "confirm_ack_leave_group";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_VIEW_ONCE = "confirm_ack_view_once";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_DESTROY_GROUP = "confirm_ack_destroy_group";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_BLOCK_UNKNOWN = "confirm_block_unknown";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_BLOCK = "confirm_ack_block";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_UNBLOCK = "confirm_ack_unblock";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_IS_CONFIDENTIAL_CHANGE = "confirm_ack_is_confidential_change";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CONFIRM_ACK_IS_MEDIA_SHARE_RESTRICT_CHANGE = "confirm_ack_is_media_share_restrict_change";
        
        private TYPES() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/devbeans/io/chat/utils/Constants$SETTINGS;", "", "()V", "ACTION_AUTO_BACKUP", "", "ACTION_AUTO_DELETE", "ACTION_MAX_ATTEMPTS", "ACTION_RECYCLE_BIN", "app_debug"})
    public static final class SETTINGS {
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.Constants.SETTINGS INSTANCE = null;
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_RECYCLE_BIN = "chat.settings.enable.recyclebin";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_AUTO_DELETE = "chat.settings.delete.notes";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_AUTO_BACKUP = "chat.settings.auto.backup";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ACTION_MAX_ATTEMPTS = "chat.settings.max.attempts";
        
        private SETTINGS() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/devbeans/io/chat/utils/Constants$LOCK;", "", "()V", "KEY_KEEP_LOCK", "", "app_debug"})
    public static final class LOCK {
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.Constants.LOCK INSTANCE = null;
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String KEY_KEEP_LOCK = "chat.keep.lock";
        
        private LOCK() {
            super();
        }
    }
}