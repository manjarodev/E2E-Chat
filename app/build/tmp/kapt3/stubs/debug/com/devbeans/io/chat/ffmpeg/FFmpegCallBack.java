package com.devbeans.io.chat.ffmpeg;

import java.lang.System;

/**
 * Created by Ashvin Vavaliya on 01,January,2021
 * Simform Solutions Pvt Ltd.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/devbeans/io/chat/ffmpeg/FFmpegCallBack;", "", "cancel", "", "failed", "process", "logMessage", "Lcom/devbeans/io/chat/ffmpeg/LogMessage;", "statisticsProcess", "statistics", "Lcom/devbeans/io/chat/ffmpeg/Statistics;", "success", "app_debug"})
public abstract interface FFmpegCallBack {
    
    public abstract void process(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.ffmpeg.LogMessage logMessage);
    
    public abstract void statisticsProcess(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.ffmpeg.Statistics statistics);
    
    public abstract void success();
    
    public abstract void cancel();
    
    public abstract void failed();
    
    /**
     * Created by Ashvin Vavaliya on 01,January,2021
     * Simform Solutions Pvt Ltd.
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public final class DefaultImpls {
        
        public static void process(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.ffmpeg.FFmpegCallBack $this, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.ffmpeg.LogMessage logMessage) {
        }
        
        public static void statisticsProcess(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.ffmpeg.FFmpegCallBack $this, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.ffmpeg.Statistics statistics) {
        }
        
        public static void success(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.ffmpeg.FFmpegCallBack $this) {
        }
        
        public static void cancel(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.ffmpeg.FFmpegCallBack $this) {
        }
        
        public static void failed(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.ffmpeg.FFmpegCallBack $this) {
        }
    }
}