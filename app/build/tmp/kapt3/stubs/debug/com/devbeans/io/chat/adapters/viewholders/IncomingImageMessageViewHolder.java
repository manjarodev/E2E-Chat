package com.devbeans.io.chat.adapters.viewholders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0002H\u0002J\u0010\u0010W\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0002H\u0002J\u0018\u0010X\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00022\u0006\u0010Y\u001a\u00020\tH\u0002J\u0010\u0010Z\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0002H\u0002J\u0010\u0010[\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0002H\u0002J\u0010\u0010\\\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0002H\u0002J\u0010\u0010]\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0002H\u0002J\u001a\u0010^\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00022\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J\u0010\u0010a\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0002H\u0002J\u0010\u0010b\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0002H\u0002J\u0010\u0010c\u001a\u00020U2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010d\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0002H\u0016R\u0019\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\u001a\u00104\u001a\u000205X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\"\"\u0004\b<\u0010$R\u001c\u0010=\u001a\u0004\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010IX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u001c\"\u0004\bP\u0010\u001eR\u001c\u0010Q\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u001c\"\u0004\bS\u0010\u001e\u00a8\u0006e"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/IncomingImageMessageViewHolder;", "Lcom/stfalcon/chatkit/messages/MessageHolders$IncomingImageMessageViewHolder;", "Lcom/devbeans/io/chat/models/Messages;", "itemView", "Landroid/view/View;", "payload", "", "(Landroid/view/View;Ljava/lang/Object;)V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "backgroundLayout", "Landroid/widget/RelativeLayout;", "getBackgroundLayout", "()Landroid/widget/RelativeLayout;", "setBackgroundLayout", "(Landroid/widget/RelativeLayout;)V", "bubbleView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getBubbleView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setBubbleView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "dataSize", "Landroid/widget/TextView;", "getDataSize", "()Landroid/widget/TextView;", "setDataSize", "(Landroid/widget/TextView;)V", "disappearIcon", "Landroid/widget/ImageView;", "getDisappearIcon", "()Landroid/widget/ImageView;", "setDisappearIcon", "(Landroid/widget/ImageView;)V", "downloadButton", "Landroid/widget/LinearLayout;", "getDownloadButton", "()Landroid/widget/LinearLayout;", "setDownloadButton", "(Landroid/widget/LinearLayout;)V", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "forwardLayout", "getForwardLayout", "setForwardLayout", "hasFile", "", "getHasFile", "()Z", "setHasFile", "(Z)V", "imageView", "getImageView", "setImageView", "messages", "getMessages", "()Lcom/devbeans/io/chat/models/Messages;", "setMessages", "(Lcom/devbeans/io/chat/models/Messages;)V", "metaData", "Lcom/devbeans/io/chat/models/MetaData;", "getMetaData", "()Lcom/devbeans/io/chat/models/MetaData;", "setMetaData", "(Lcom/devbeans/io/chat/models/MetaData;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "time", "getTime", "setTime", "userName", "getUserName", "setUserName", "handleAnonymousDownloader", "", "message", "handleAutoDownloader", "handleDownloadClick", "data", "handleDownloader", "handleDownloading", "handleGroupDownloader", "handleHasFile", "handleNickName", "me", "Lcom/devbeans/io/chat/models/ConversationMember;", "handleOneToOneDownloader", "handleSimpleDownloader", "init", "onBind", "app_debug"})
public final class IncomingImageMessageViewHolder extends com.stfalcon.chatkit.messages.MessageHolders.IncomingImageMessageViewHolder<com.devbeans.io.chat.models.Messages> {
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView imageView;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView disappearIcon;
    @org.jetbrains.annotations.Nullable
    private android.widget.LinearLayout downloadButton;
    @org.jetbrains.annotations.Nullable
    private android.widget.ProgressBar progressBar;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView time;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView userName;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView dataSize;
    @org.jetbrains.annotations.Nullable
    private java.io.File file;
    private boolean hasFile = false;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.MetaData metaData;
    @org.jetbrains.annotations.Nullable
    private android.widget.RelativeLayout backgroundLayout;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Messages messages;
    @org.jetbrains.annotations.Nullable
    private androidx.constraintlayout.widget.ConstraintLayout bubbleView;
    @org.jetbrains.annotations.Nullable
    private android.widget.LinearLayout forwardLayout;
    private final java.lang.String TAG = null;
    
    public IncomingImageMessageViewHolder(@org.jetbrains.annotations.NotNull
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
    public final android.widget.ProgressBar getProgressBar() {
        return null;
    }
    
    public final void setProgressBar(@org.jetbrains.annotations.Nullable
    android.widget.ProgressBar p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getTime() {
        return null;
    }
    
    public final void setTime(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getUserName() {
        return null;
    }
    
    public final void setUserName(@org.jetbrains.annotations.Nullable
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
    public final com.devbeans.io.chat.models.MetaData getMetaData() {
        return null;
    }
    
    public final void setMetaData(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.MetaData p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.RelativeLayout getBackgroundLayout() {
        return null;
    }
    
    public final void setBackgroundLayout(@org.jetbrains.annotations.Nullable
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Messages getMessages() {
        return null;
    }
    
    public final void setMessages(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Messages p0) {
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
    
    public final java.lang.String getTAG() {
        return null;
    }
    
    @java.lang.Override
    public void onBind(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleDownloading(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleDownloader(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleAutoDownloader(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleAnonymousDownloader(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleGroupDownloader(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleOneToOneDownloader(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleSimpleDownloader(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleDownloadClick(com.devbeans.io.chat.models.Messages message, java.lang.String data) {
    }
    
    private final void handleHasFile(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleNickName(com.devbeans.io.chat.models.Messages message, com.devbeans.io.chat.models.ConversationMember me) {
    }
    
    private final void init(android.view.View itemView) {
    }
}