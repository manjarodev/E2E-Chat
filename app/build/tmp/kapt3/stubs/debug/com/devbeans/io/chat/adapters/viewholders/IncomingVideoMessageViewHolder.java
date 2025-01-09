package com.devbeans.io.chat.adapters.viewholders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010O\u001a\u00020PH\u0016J\u0010\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0002H\u0002J\u0010\u0010T\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0002H\u0002J\u0018\u0010U\u001a\u00020R2\u0006\u0010S\u001a\u00020\u00022\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010X\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0002H\u0002J\u0010\u0010Y\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0002H\u0002J\u0010\u0010Z\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0002H\u0002J\u0010\u0010[\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0002H\u0002J\u0010\u0010\\\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0002H\u0002J\u0010\u0010]\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0002H\u0002J\u0010\u0010^\u001a\u00020R2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010_\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0002H\u0016J\u0010\u0010`\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0002H\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R\u001a\u0010/\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u0010\u001fR\u001c\u00108\u001a\u0004\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001d\"\u0004\b?\u0010\u001fR\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0017\"\u0004\bH\u0010\u0019R\u001c\u0010I\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0017\"\u0004\bK\u0010\u0019R\u001c\u0010L\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0017\"\u0004\bN\u0010\u0019\u00a8\u0006a"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/IncomingVideoMessageViewHolder;", "Lcom/stfalcon/chatkit/messages/MessageHolders$IncomingImageMessageViewHolder;", "Lcom/devbeans/io/chat/models/Messages;", "itemView", "Landroid/view/View;", "payload", "", "(Landroid/view/View;Ljava/lang/Object;)V", "backgroundLayout", "Landroid/widget/RelativeLayout;", "getBackgroundLayout", "()Landroid/widget/RelativeLayout;", "setBackgroundLayout", "(Landroid/widget/RelativeLayout;)V", "bubbleView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getBubbleView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setBubbleView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "dataSize", "Landroid/widget/TextView;", "getDataSize", "()Landroid/widget/TextView;", "setDataSize", "(Landroid/widget/TextView;)V", "disappearIcon", "Landroid/widget/ImageView;", "getDisappearIcon", "()Landroid/widget/ImageView;", "setDisappearIcon", "(Landroid/widget/ImageView;)V", "downloadButton", "Landroid/widget/LinearLayout;", "getDownloadButton", "()Landroid/widget/LinearLayout;", "setDownloadButton", "(Landroid/widget/LinearLayout;)V", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "forwardLayout", "getForwardLayout", "setForwardLayout", "hasFile", "", "getHasFile", "()Z", "setHasFile", "(Z)V", "imageView", "getImageView", "setImageView", "messages", "getMessages", "()Lcom/devbeans/io/chat/models/Messages;", "setMessages", "(Lcom/devbeans/io/chat/models/Messages;)V", "playButton", "getPlayButton", "setPlayButton", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "time", "getTime", "setTime", "userNAme", "getUserNAme", "setUserNAme", "videoTime", "getVideoTime", "setVideoTime", "getImageLoader", "Lcom/stfalcon/chatkit/commons/ImageLoader;", "handleAnonymousDownload", "", "message", "handleAutoDownload", "handleDownloadClick", "data", "", "handleDownloader", "handleDownloading", "handleGroupDownload", "handleHasFile", "handleOneToOneDownload", "handleOtherDownload", "init", "onBind", "showVideo", "app_debug"})
public final class IncomingVideoMessageViewHolder extends com.stfalcon.chatkit.messages.MessageHolders.IncomingImageMessageViewHolder<com.devbeans.io.chat.models.Messages> {
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView imageView;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView playButton;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView disappearIcon;
    @org.jetbrains.annotations.Nullable
    private android.widget.LinearLayout downloadButton;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView time;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView userNAme;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView dataSize;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView videoTime;
    @org.jetbrains.annotations.Nullable
    private android.widget.ProgressBar progressBar;
    @org.jetbrains.annotations.Nullable
    private java.io.File file;
    private boolean hasFile = false;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Messages messages;
    @org.jetbrains.annotations.Nullable
    private android.widget.RelativeLayout backgroundLayout;
    @org.jetbrains.annotations.Nullable
    private androidx.constraintlayout.widget.ConstraintLayout bubbleView;
    @org.jetbrains.annotations.Nullable
    private android.widget.LinearLayout forwardLayout;
    
    public IncomingVideoMessageViewHolder(@org.jetbrains.annotations.NotNull
    android.view.View itemView, @org.jetbrains.annotations.Nullable
    java.lang.Object payload) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ImageView getImageView() {
        return null;
    }
    
    public final void setImageView(@org.jetbrains.annotations.Nullable
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ImageView getPlayButton() {
        return null;
    }
    
    public final void setPlayButton(@org.jetbrains.annotations.Nullable
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ImageView getDisappearIcon() {
        return null;
    }
    
    public final void setDisappearIcon(@org.jetbrains.annotations.Nullable
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.LinearLayout getDownloadButton() {
        return null;
    }
    
    public final void setDownloadButton(@org.jetbrains.annotations.Nullable
    android.widget.LinearLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getTime() {
        return null;
    }
    
    public final void setTime(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getUserNAme() {
        return null;
    }
    
    public final void setUserNAme(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getDataSize() {
        return null;
    }
    
    public final void setDataSize(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getVideoTime() {
        return null;
    }
    
    public final void setVideoTime(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ProgressBar getProgressBar() {
        return null;
    }
    
    public final void setProgressBar(@org.jetbrains.annotations.Nullable
    android.widget.ProgressBar p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.io.File getFile() {
        return null;
    }
    
    public final void setFile(@org.jetbrains.annotations.Nullable
    java.io.File p0) {
    }
    
    public final boolean getHasFile() {
        return false;
    }
    
    public final void setHasFile(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Messages getMessages() {
        return null;
    }
    
    public final void setMessages(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Messages p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.RelativeLayout getBackgroundLayout() {
        return null;
    }
    
    public final void setBackgroundLayout(@org.jetbrains.annotations.Nullable
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.constraintlayout.widget.ConstraintLayout getBubbleView() {
        return null;
    }
    
    public final void setBubbleView(@org.jetbrains.annotations.Nullable
    androidx.constraintlayout.widget.ConstraintLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.LinearLayout getForwardLayout() {
        return null;
    }
    
    public final void setForwardLayout(@org.jetbrains.annotations.Nullable
    android.widget.LinearLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.stfalcon.chatkit.commons.ImageLoader getImageLoader() {
        return null;
    }
    
    @java.lang.Override
    public void onBind(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleDownloading(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleHasFile(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleDownloader(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleAutoDownload(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleAnonymousDownload(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleGroupDownload(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleOneToOneDownload(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleDownloadClick(com.devbeans.io.chat.models.Messages message, java.lang.String data) {
    }
    
    private final void handleOtherDownload(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void init(android.view.View itemView) {
    }
    
    private final void showVideo(com.devbeans.io.chat.models.Messages message) {
    }
}