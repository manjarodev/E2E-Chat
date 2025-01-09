package com.devbeans.io.chat.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/devbeans/io/chat/fragments/Data;", "", "()V", "bundle", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "endTimeUs", "", "getEndTimeUs", "()J", "setEndTimeUs", "(J)V", "isDurationEdited", "", "()Z", "setDurationEdited", "(Z)V", "startTimeUs", "getStartTimeUs", "setStartTimeUs", "totalDurationUs", "getTotalDurationUs", "setTotalDurationUs", "Companion", "app_debug"})
public final class Data {
    private boolean isDurationEdited = false;
    private long totalDurationUs = 0L;
    private long startTimeUs = 0L;
    private long endTimeUs = 0L;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.fragments.Data.Companion Companion = null;
    
    public Data() {
        super();
    }
    
    public final boolean isDurationEdited() {
        return false;
    }
    
    public final void setDurationEdited(boolean p0) {
    }
    
    public final long getTotalDurationUs() {
        return 0L;
    }
    
    public final void setTotalDurationUs(long p0) {
    }
    
    public final long getStartTimeUs() {
        return 0L;
    }
    
    public final void setStartTimeUs(long p0) {
    }
    
    public final long getEndTimeUs() {
        return 0L;
    }
    
    public final void setEndTimeUs(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.os.Bundle getBundle() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/devbeans/io/chat/fragments/Data$Companion;", "", "()V", "fromBundle", "Lcom/devbeans/io/chat/fragments/Data;", "bundle", "Landroid/os/Bundle;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.fragments.Data fromBundle(@org.jetbrains.annotations.NotNull
        android.os.Bundle bundle) {
            return null;
        }
    }
}