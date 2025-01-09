package com.devbeans.io.chat.ffmpeg;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJK\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002\u00a2\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ6\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/devbeans/io/chat/ffmpeg/FFmpegOperations;", "", "()V", "tag", "", "kotlin.jvm.PlatformType", "compressAudio", "", "inputPath", "outputPath", "callback", "Lcom/devbeans/io/chat/ffmpeg/FFmpegOperations$FFmpegOperationsCallback;", "compressFile", "query", "", "startTime", "endTime", "mediaType", "([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/devbeans/io/chat/ffmpeg/FFmpegOperations$FFmpegOperationsCallback;)V", "compressImage", "compressImageWithRotate", "cutVideoWithCompress", "uri", "Landroid/net/Uri;", "metaDataRemoved", "", "filePath", "FFmpegOperationsCallback", "app_debug"})
public final class FFmpegOperations {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.ffmpeg.FFmpegOperations INSTANCE = null;
    private static final java.lang.String tag = null;
    
    private FFmpegOperations() {
        super();
    }
    
    public final void cutVideoWithCompress(@org.jetbrains.annotations.NotNull
    java.lang.String inputPath, @org.jetbrains.annotations.NotNull
    java.lang.String startTime, @org.jetbrains.annotations.NotNull
    java.lang.String endTime, @org.jetbrains.annotations.NotNull
    java.lang.String outputPath, @org.jetbrains.annotations.NotNull
    android.net.Uri uri, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.ffmpeg.FFmpegOperations.FFmpegOperationsCallback callback) {
    }
    
    private final void compressFile(java.lang.String[] query, java.lang.String inputPath, java.lang.String outputPath, java.lang.String startTime, java.lang.String endTime, java.lang.String mediaType, com.devbeans.io.chat.ffmpeg.FFmpegOperations.FFmpegOperationsCallback callback) {
    }
    
    public final void compressImage(@org.jetbrains.annotations.NotNull
    java.lang.String inputPath, @org.jetbrains.annotations.NotNull
    java.lang.String outputPath, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.ffmpeg.FFmpegOperations.FFmpegOperationsCallback callback) {
    }
    
    public final void compressImageWithRotate(@org.jetbrains.annotations.NotNull
    java.lang.String inputPath, @org.jetbrains.annotations.NotNull
    java.lang.String outputPath, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.ffmpeg.FFmpegOperations.FFmpegOperationsCallback callback) {
    }
    
    public final void compressAudio(@org.jetbrains.annotations.NotNull
    java.lang.String inputPath, @org.jetbrains.annotations.NotNull
    java.lang.String outputPath, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.ffmpeg.FFmpegOperations.FFmpegOperationsCallback callback) {
    }
    
    private final boolean metaDataRemoved(java.lang.String filePath) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/devbeans/io/chat/ffmpeg/FFmpegOperations$FFmpegOperationsCallback;", "", "onSuccessCompress", "", "app_debug"})
    public static abstract interface FFmpegOperationsCallback {
        
        public abstract void onSuccessCompress();
    }
}