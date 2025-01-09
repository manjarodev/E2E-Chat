package com.devbeans.io.chat.ffmpeg;

import java.lang.System;

/**
 * Statistics for running executions.
 *
 * @author Taner Sener
 * @since v2.1
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002BG\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000fJ\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010!\"\u0004\b\'\u0010#\u00a8\u0006-"}, d2 = {"Lcom/devbeans/io/chat/ffmpeg/Statistics;", "", "()V", "executionId", "", "videoFrameNumber", "", "videoFps", "", "videoQuality", "size", "time", "bitrate", "", "speed", "(JIFFJIDD)V", "getBitrate", "()D", "setBitrate", "(D)V", "getExecutionId", "()J", "setExecutionId", "(J)V", "getSize", "setSize", "getSpeed", "setSpeed", "getTime", "()I", "setTime", "(I)V", "getVideoFps", "()F", "setVideoFps", "(F)V", "getVideoFrameNumber", "setVideoFrameNumber", "getVideoQuality", "setVideoQuality", "toString", "", "update", "", "newStatistics", "app_debug"})
public final class Statistics {
    private long executionId;
    private int videoFrameNumber;
    private float videoFps;
    private float videoQuality;
    private long size;
    private int time;
    private double bitrate;
    private double speed;
    
    public final long getExecutionId() {
        return 0L;
    }
    
    public final void setExecutionId(long p0) {
    }
    
    public final int getVideoFrameNumber() {
        return 0;
    }
    
    public final void setVideoFrameNumber(int p0) {
    }
    
    public final float getVideoFps() {
        return 0.0F;
    }
    
    public final void setVideoFps(float p0) {
    }
    
    public final float getVideoQuality() {
        return 0.0F;
    }
    
    public final void setVideoQuality(float p0) {
    }
    
    public final long getSize() {
        return 0L;
    }
    
    public final void setSize(long p0) {
    }
    
    public final int getTime() {
        return 0;
    }
    
    public final void setTime(int p0) {
    }
    
    public final double getBitrate() {
        return 0.0;
    }
    
    public final void setBitrate(double p0) {
    }
    
    public final double getSpeed() {
        return 0.0;
    }
    
    public final void setSpeed(double p0) {
    }
    
    public Statistics() {
        super();
    }
    
    public Statistics(long executionId, int videoFrameNumber, float videoFps, float videoQuality, long size, int time, double bitrate, double speed) {
        super();
    }
    
    public final void update(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.ffmpeg.Statistics newStatistics) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
}