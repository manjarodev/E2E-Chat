package com.devbeans.io.chat.ffmpeg;

import java.lang.System;

/**
 * Created by Ashvin Vavaliya on 24,November,2020
 * Simform Solutions Pvt Ltd.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0006J\u0016\u0010*\u001a\u00020\u00062\u0006\u0010\'\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0006J\u000e\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020&J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0006J\u0015\u00101\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0002\u00103R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/devbeans/io/chat/ffmpeg/Common;", "", "()V", "AUDIO_FILE_REQUEST_CODE", "", "BITRATE_112", "", "BITRATE_128", "BITRATE_160", "BITRATE_192", "BITRATE_256", "BITRATE_320", "BITRATE_96", "DURATION_FIRST", "DURATION_LONGEST", "DURATION_SHORTEST", "GIF", "IMAGE", "IMAGE_FILE_REQUEST_CODE", "KB", "", "MB", "MP3", "OUT_PUT_DIR", "PERM", "RATIO_1", "RATIO_2", "RATIO_3", "RATIO_4", "RATIO_5", "RATIO_6", "RATIO_7", "TIME_FORMAT", "VIDEO", "VIDEO_FILE_REQUEST_CODE", "format", "Ljava/text/DecimalFormat;", "getFileFromAssets", "Ljava/io/File;", "context", "Landroid/content/Context;", "fileName", "getFilePath", "fileExtension", "getFileSize", "file", "getFrameRate", "", "fileString", "stringForTime", "timeMs", "(Ljava/lang/Long;)Ljava/lang/String;", "app_debug"})
public final class Common {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.ffmpeg.Common INSTANCE = null;
    public static final int PERM = 111;
    public static final int VIDEO_FILE_REQUEST_CODE = 112;
    public static final int IMAGE_FILE_REQUEST_CODE = 113;
    public static final int AUDIO_FILE_REQUEST_CODE = 114;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TIME_FORMAT = "HH:mm:ss";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String OUT_PUT_DIR = "Output";
    private static final java.text.DecimalFormat format = null;
    private static final long MB = 1048576L;
    private static final long KB = 1024L;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String IMAGE = "IMAGE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String VIDEO = "VIDEO";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String GIF = "GIF";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MP3 = "MP3";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String RATIO_1 = "16:9";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String RATIO_2 = "4:3";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String RATIO_3 = "16:10";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String RATIO_4 = "5:4";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String RATIO_5 = "2:21:1";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String RATIO_6 = "2:35:1";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String RATIO_7 = "2:39:1";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BITRATE_96 = "96";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BITRATE_112 = "112";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BITRATE_128 = "128";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BITRATE_160 = "160";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BITRATE_192 = "192";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BITRATE_256 = "256";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BITRATE_320 = "320";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DURATION_LONGEST = "longest";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DURATION_SHORTEST = "shortest";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DURATION_FIRST = "first";
    
    private Common() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String stringForTime(@org.jetbrains.annotations.Nullable
    java.lang.Long timeMs) {
        return null;
    }
    
    public final void getFrameRate(@org.jetbrains.annotations.NotNull
    java.lang.String fileString) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFileSize(@org.jetbrains.annotations.NotNull
    java.io.File file) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFilePath(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String fileExtension) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    public final java.io.File getFileFromAssets(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String fileName) throws java.io.IOException {
        return null;
    }
}