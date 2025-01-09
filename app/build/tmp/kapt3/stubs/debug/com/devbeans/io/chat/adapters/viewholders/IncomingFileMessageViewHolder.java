package com.devbeans.io.chat.adapters.viewholders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00022\u0006\u0010I\u001a\u00020JH\u0002J\u0018\u0010K\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00022\u0006\u0010I\u001a\u00020JH\u0002J\u0018\u0010L\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00022\u0006\u0010M\u001a\u00020NH\u0002J\u0010\u0010O\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0002H\u0002J\u0018\u0010P\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00022\u0006\u0010I\u001a\u00020JH\u0002J\u001a\u0010Q\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00022\b\u0010R\u001a\u0004\u0018\u00010SH\u0002J\u001a\u0010T\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00022\b\u0010R\u001a\u0004\u0018\u00010SH\u0002J\u0018\u0010U\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00022\u0006\u0010I\u001a\u00020JH\u0002J\u001a\u0010V\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00022\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J\u0010\u0010W\u001a\u00020G2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010X\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0002H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R\u001c\u00105\u001a\u0004\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010&\"\u0004\bB\u0010(R\u001c\u0010C\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010&\"\u0004\bE\u0010(\u00a8\u0006Y"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/IncomingFileMessageViewHolder;", "Lcom/stfalcon/chatkit/messages/MessageHolders$IncomingTextMessageViewHolder;", "Lcom/devbeans/io/chat/models/Messages;", "itemView", "Landroid/view/View;", "payload", "", "(Landroid/view/View;Ljava/lang/Object;)V", "backgroundLayout", "Landroid/widget/RelativeLayout;", "getBackgroundLayout", "()Landroid/widget/RelativeLayout;", "setBackgroundLayout", "(Landroid/widget/RelativeLayout;)V", "bubbleView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getBubbleView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setBubbleView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "disappearIcon", "Landroid/widget/ImageView;", "getDisappearIcon", "()Landroid/widget/ImageView;", "setDisappearIcon", "(Landroid/widget/ImageView;)V", "downloadButton", "getDownloadButton", "setDownloadButton", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "fileName", "Landroid/widget/TextView;", "getFileName", "()Landroid/widget/TextView;", "setFileName", "(Landroid/widget/TextView;)V", "fileSize", "getFileSize", "setFileSize", "forwardLayout", "Landroid/widget/LinearLayout;", "getForwardLayout", "()Landroid/widget/LinearLayout;", "setForwardLayout", "(Landroid/widget/LinearLayout;)V", "imageView", "getImageView", "setImageView", "messages", "getMessages", "()Lcom/devbeans/io/chat/models/Messages;", "setMessages", "(Lcom/devbeans/io/chat/models/Messages;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "time", "getTime", "setTime", "userName", "getUserName", "setUserName", "handelAnonymousDownload", "", "message", "metaData", "Lcom/devbeans/io/chat/models/MetaData;", "handleAutoDownloads", "handleDownloadClick", "data", "", "handleDownloader", "handleGroupDownload", "handleNickName", "me", "Lcom/devbeans/io/chat/models/ConversationMember;", "handleNickNameGroup", "handleOneToOneDownload", "handleSimpleDownload", "init", "onBind", "app_debug"})
public final class IncomingFileMessageViewHolder extends com.stfalcon.chatkit.messages.MessageHolders.IncomingTextMessageViewHolder<com.devbeans.io.chat.models.Messages> {
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView imageView;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView downloadButton;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView disappearIcon;
    @org.jetbrains.annotations.Nullable
    private android.widget.ProgressBar progressBar;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView time;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView fileName;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView fileSize;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView userName;
    @org.jetbrains.annotations.Nullable
    private java.io.File file;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Messages messages;
    @org.jetbrains.annotations.Nullable
    private android.widget.RelativeLayout backgroundLayout;
    @org.jetbrains.annotations.Nullable
    private androidx.constraintlayout.widget.ConstraintLayout bubbleView;
    @org.jetbrains.annotations.Nullable
    private android.widget.LinearLayout forwardLayout;
    
    public IncomingFileMessageViewHolder(@org.jetbrains.annotations.NotNull
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
    public final android.widget.ImageView getDownloadButton() {
        return null;
    }
    
    public final void setDownloadButton(@org.jetbrains.annotations.Nullable
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
    public final android.widget.TextView getFileName() {
        return null;
    }
    
    public final void setFileName(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getFileSize() {
        return null;
    }
    
    public final void setFileSize(@org.jetbrains.annotations.Nullable
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
    public final java.io.File getFile() {
        return null;
    }
    
    public final void setFile(@org.jetbrains.annotations.Nullable
    java.io.File p0) {
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
    
    @java.lang.Override
    public void onBind(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleDownloader(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleSimpleDownload(com.devbeans.io.chat.models.Messages message, com.devbeans.io.chat.models.MetaData metaData) {
    }
    
    private final void handleDownloadClick(com.devbeans.io.chat.models.Messages message, java.lang.String data) {
    }
    
    private final void handleAutoDownloads(com.devbeans.io.chat.models.Messages message, com.devbeans.io.chat.models.MetaData metaData) {
    }
    
    private final void handelAnonymousDownload(com.devbeans.io.chat.models.Messages message, com.devbeans.io.chat.models.MetaData metaData) {
    }
    
    private final void handleGroupDownload(com.devbeans.io.chat.models.Messages message, com.devbeans.io.chat.models.MetaData metaData) {
    }
    
    private final void handleOneToOneDownload(com.devbeans.io.chat.models.Messages message, com.devbeans.io.chat.models.MetaData metaData) {
    }
    
    private final void handleNickName(com.devbeans.io.chat.models.Messages message, com.devbeans.io.chat.models.ConversationMember me) {
    }
    
    private final void handleNickNameGroup(com.devbeans.io.chat.models.Messages message, com.devbeans.io.chat.models.ConversationMember me) {
    }
    
    private final void init(android.view.View itemView) {
    }
}