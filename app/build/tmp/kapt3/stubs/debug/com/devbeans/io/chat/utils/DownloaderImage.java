package com.devbeans.io.chat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 52\u00020\u0001:\u00015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ(\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011J,\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011J\"\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001aH\u0016J \u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\"\u0010#\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001aH\u0016J \u0010)\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0016J\u0018\u0010-\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0006H\u0016J\u0010\u0010/\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001aH\u0016J\u0010\u00100\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001aH\u0016J&\u00101\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001a2\f\u00102\u001a\b\u0012\u0004\u0012\u00020 032\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u00104\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001aH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/devbeans/io/chat/utils/DownloaderImage;", "Lcom/tonyodev/fetch2/FetchListener;", "()V", "file", "Ljava/io/File;", "isImage", "", "()Z", "setImage", "(Z)V", "listDownloading", "", "Lcom/devbeans/io/chat/models/DownloadMedia;", "clearDownloadingData", "", "download", "path", "", "url", "conversationId", "photo", "downloadImage", "mediaName", "convID", "initialize", "onAdded", "Lcom/tonyodev/fetch2/Download;", "onCancelled", "onCompleted", "onDeleted", "onDownloadBlockUpdated", "downloadBlock", "Lcom/tonyodev/fetch2core/DownloadBlock;", "i", "", "onError", "error", "Lcom/tonyodev/fetch2/Error;", "throwable", "", "onPaused", "onProgress", "l", "", "l1", "onQueued", "b", "onRemoved", "onResumed", "onStarted", "list", "", "onWaitingNetwork", "Companion", "app_debug"})
public final class DownloaderImage implements com.tonyodev.fetch2.FetchListener {
    private boolean isImage = false;
    private java.io.File file;
    private java.util.List<com.devbeans.io.chat.models.DownloadMedia> listDownloading;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.DownloaderImage.Companion Companion = null;
    private static final java.lang.String TAG = null;
    @org.jetbrains.annotations.Nullable
    private static com.tonyodev.fetch2.Fetch fetch;
    private static final java.io.File fileDefault = null;
    @org.jetbrains.annotations.NotNull
    private static androidx.lifecycle.MutableLiveData<java.io.File> fileImageMutableLiveData;
    @org.jetbrains.annotations.Nullable
    private static com.devbeans.io.chat.utils.DownloaderImage downloader;
    
    public DownloaderImage() {
        super();
    }
    
    public final boolean isImage() {
        return false;
    }
    
    public final void setImage(boolean p0) {
    }
    
    private final void initialize() {
    }
    
    public final void downloadImage(@org.jetbrains.annotations.NotNull
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable
    java.lang.String url, @org.jetbrains.annotations.Nullable
    java.lang.String path, @org.jetbrains.annotations.Nullable
    java.lang.String convID) {
    }
    
    public final void clearDownloadingData() {
    }
    
    public final void download(@org.jetbrains.annotations.Nullable
    java.lang.String path, @org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    java.lang.String conversationId, @org.jetbrains.annotations.NotNull
    java.lang.String photo) {
    }
    
    public final void downloadImage(@org.jetbrains.annotations.Nullable
    java.lang.String path, @org.jetbrains.annotations.Nullable
    java.lang.String url, boolean isImage) {
    }
    
    @java.lang.Override
    public void onAdded(@org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Download download) {
    }
    
    @java.lang.Override
    public void onCancelled(@org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Download download) {
    }
    
    @java.lang.Override
    public void onCompleted(@org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Download download) {
    }
    
    @java.lang.Override
    public void onDeleted(@org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Download download) {
    }
    
    @java.lang.Override
    public void onDownloadBlockUpdated(@org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Download download, @org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2core.DownloadBlock downloadBlock, int i) {
    }
    
    @java.lang.Override
    public void onPaused(@org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Download download) {
    }
    
    @java.lang.Override
    public void onProgress(@org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Download download, long l, long l1) {
    }
    
    @java.lang.Override
    public void onQueued(@org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Download download, boolean b) {
    }
    
    @java.lang.Override
    public void onRemoved(@org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Download download) {
    }
    
    @java.lang.Override
    public void onResumed(@org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Download download) {
    }
    
    @java.lang.Override
    public void onStarted(@org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Download download, @org.jetbrains.annotations.NotNull
    java.util.List<? extends com.tonyodev.fetch2core.DownloadBlock> list, int i) {
    }
    
    @java.lang.Override
    public void onWaitingNetwork(@org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Download download) {
    }
    
    @java.lang.Override
    public void onError(@org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Download download, @org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Error error, @org.jetbrains.annotations.Nullable
    java.lang.Throwable throwable) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00130\u00130\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\t\u00a8\u0006\u001c"}, d2 = {"Lcom/devbeans/io/chat/utils/DownloaderImage$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "downloader", "Lcom/devbeans/io/chat/utils/DownloaderImage;", "getDownloader", "()Lcom/devbeans/io/chat/utils/DownloaderImage;", "setDownloader", "(Lcom/devbeans/io/chat/utils/DownloaderImage;)V", "fetch", "Lcom/tonyodev/fetch2/Fetch;", "getFetch", "()Lcom/tonyodev/fetch2/Fetch;", "setFetch", "(Lcom/tonyodev/fetch2/Fetch;)V", "fileDefault", "Ljava/io/File;", "fileImageMutableLiveData", "Landroidx/lifecycle/MutableLiveData;", "getFileImageMutableLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setFileImageMutableLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "instance", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.tonyodev.fetch2.Fetch getFetch() {
            return null;
        }
        
        public final void setFetch(@org.jetbrains.annotations.Nullable
        com.tonyodev.fetch2.Fetch p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.lifecycle.MutableLiveData<java.io.File> getFileImageMutableLiveData() {
            return null;
        }
        
        public final void setFileImageMutableLiveData(@org.jetbrains.annotations.NotNull
        androidx.lifecycle.MutableLiveData<java.io.File> p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.utils.DownloaderImage getDownloader() {
            return null;
        }
        
        public final void setDownloader(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.utils.DownloaderImage p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        @kotlin.jvm.Synchronized
        public final synchronized com.devbeans.io.chat.utils.DownloaderImage getInstance() {
            return null;
        }
    }
}