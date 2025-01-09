package com.devbeans.io.chat.utils.downloaders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 F2\u00020\u0001:\u0001FB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010 \u001a\u00020!J$\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u001b\u001a\u0004\u0018\u00010\rJ\u0014\u0010&\u001a\u00020!2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020!H\u0002J\u0010\u0010+\u001a\u00020!2\u0006\u0010\"\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020!2\u0006\u0010\"\u001a\u00020,H\u0016J\u0010\u0010.\u001a\u00020!2\u0006\u0010\"\u001a\u00020,H\u0017J\u0010\u0010/\u001a\u00020!2\u0006\u0010\"\u001a\u00020,H\u0016J \u00100\u001a\u00020!2\u0006\u0010\"\u001a\u00020,2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\fH\u0016J\"\u00104\u001a\u00020!2\u0006\u0010\"\u001a\u00020,2\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u00109\u001a\u00020!2\u0006\u0010\"\u001a\u00020,H\u0016J \u0010:\u001a\u00020!2\u0006\u0010\"\u001a\u00020,2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<H\u0016J\u0018\u0010>\u001a\u00020!2\u0006\u0010\"\u001a\u00020,2\u0006\u0010?\u001a\u00020\u0014H\u0016J\u0010\u0010@\u001a\u00020!2\u0006\u0010\"\u001a\u00020,H\u0016J\u0010\u0010A\u001a\u00020!2\u0006\u0010\"\u001a\u00020,H\u0016J&\u0010B\u001a\u00020!2\u0006\u0010\"\u001a\u00020,2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002020D2\u0006\u00103\u001a\u00020\fH\u0016J\u0010\u0010E\u001a\u00020!2\u0006\u0010\"\u001a\u00020,H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR6\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006G"}, d2 = {"Lcom/devbeans/io/chat/utils/downloaders/DownloaderGroup;", "Lcom/tonyodev/fetch2/FetchListener;", "()V", "fileMutableLiveData", "Landroidx/lifecycle/MutableLiveData;", "Ljava/io/File;", "getFileMutableLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setFileMutableLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "hashMap", "Ljava/util/HashMap;", "", "Lcom/devbeans/io/chat/models/Payload;", "Lkotlin/collections/HashMap;", "getHashMap", "()Ljava/util/HashMap;", "setHashMap", "(Ljava/util/HashMap;)V", "isImage", "", "()Z", "setImage", "(Z)V", "listDownloading", "", "Lcom/devbeans/io/chat/models/DownloadMedia;", "payload", "getPayload", "()Lcom/devbeans/io/chat/models/Payload;", "setPayload", "(Lcom/devbeans/io/chat/models/Payload;)V", "clearDownloadingData", "", "download", "path", "", "url", "downloadAll", "listDownloadingMedia", "handleOtherDownload", "file", "initialize", "onAdded", "Lcom/tonyodev/fetch2/Download;", "onCancelled", "onCompleted", "onDeleted", "onDownloadBlockUpdated", "downloadBlock", "Lcom/tonyodev/fetch2core/DownloadBlock;", "i", "onError", "error", "Lcom/tonyodev/fetch2/Error;", "throwable", "", "onPaused", "onProgress", "l", "", "l1", "onQueued", "b", "onRemoved", "onResumed", "onStarted", "list", "", "onWaitingNetwork", "Companion", "app_debug"})
public final class DownloaderGroup implements com.tonyodev.fetch2.FetchListener {
    private java.util.List<com.devbeans.io.chat.models.DownloadMedia> listDownloading;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.io.File> fileMutableLiveData;
    private boolean isImage = false;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Payload payload;
    @org.jetbrains.annotations.NotNull
    private java.util.HashMap<java.lang.Integer, com.devbeans.io.chat.models.Payload> hashMap;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.downloaders.DownloaderGroup.Companion Companion = null;
    private static final java.lang.String TAG = "DownloaderOneToOne";
    @org.jetbrains.annotations.Nullable
    private static com.tonyodev.fetch2.Fetch fetch;
    @org.jetbrains.annotations.Nullable
    private static com.devbeans.io.chat.utils.downloaders.DownloaderGroup downloader;
    
    public DownloaderGroup() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.io.File> getFileMutableLiveData() {
        return null;
    }
    
    public final void setFileMutableLiveData(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.io.File> p0) {
    }
    
    public final boolean isImage() {
        return false;
    }
    
    public final void setImage(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Payload getPayload() {
        return null;
    }
    
    public final void setPayload(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Payload p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.Integer, com.devbeans.io.chat.models.Payload> getHashMap() {
        return null;
    }
    
    public final void setHashMap(@org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.Integer, com.devbeans.io.chat.models.Payload> p0) {
    }
    
    private final void initialize() {
    }
    
    public final void download(@org.jetbrains.annotations.Nullable
    java.lang.String path, @org.jetbrains.annotations.Nullable
    java.lang.String url, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Payload payload) {
    }
    
    public final void clearDownloadingData() {
    }
    
    public final void downloadAll(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.DownloadMedia> listDownloadingMedia) {
    }
    
    @java.lang.Override
    public void onAdded(@org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Download download) {
    }
    
    @java.lang.Override
    public void onCancelled(@org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Download download) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @kotlinx.coroutines.DelicateCoroutinesApi
    @java.lang.Override
    public void onCompleted(@org.jetbrains.annotations.NotNull
    com.tonyodev.fetch2.Download download) {
    }
    
    private final void handleOtherDownload(java.io.File file) {
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
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/devbeans/io/chat/utils/downloaders/DownloaderGroup$Companion;", "", "()V", "TAG", "", "downloader", "Lcom/devbeans/io/chat/utils/downloaders/DownloaderGroup;", "getDownloader", "()Lcom/devbeans/io/chat/utils/downloaders/DownloaderGroup;", "setDownloader", "(Lcom/devbeans/io/chat/utils/downloaders/DownloaderGroup;)V", "fetch", "Lcom/tonyodev/fetch2/Fetch;", "getFetch", "()Lcom/tonyodev/fetch2/Fetch;", "setFetch", "(Lcom/tonyodev/fetch2/Fetch;)V", "instance", "getInstance", "app_debug"})
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
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.utils.downloaders.DownloaderGroup getDownloader() {
            return null;
        }
        
        public final void setDownloader(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.utils.downloaders.DownloaderGroup p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        @kotlin.jvm.Synchronized
        public final synchronized com.devbeans.io.chat.utils.downloaders.DownloaderGroup getInstance() {
            return null;
        }
    }
}