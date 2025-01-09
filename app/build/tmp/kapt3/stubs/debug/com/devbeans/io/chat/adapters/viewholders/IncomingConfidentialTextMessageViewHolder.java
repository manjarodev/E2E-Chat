package com.devbeans.io.chat.adapters.viewholders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J \u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00022\u0006\u0010H\u001a\u00020IH\u0002J \u0010J\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00022\u0006\u0010H\u001a\u00020IH\u0002J \u0010K\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00022\u0006\u0010H\u001a\u00020IH\u0002J \u0010L\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00022\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010M\u001a\u00020D2\u0006\u0010G\u001a\u00020\u0002H\u0002J \u0010N\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00022\u0006\u0010H\u001a\u00020IH\u0002J\"\u0010O\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020\u00022\u0006\u0010H\u001a\u00020IH\u0002J \u0010P\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00022\u0006\u0010H\u001a\u00020IH\u0002J\u001a\u0010Q\u001a\u00020D2\u0006\u0010G\u001a\u00020\u00022\b\u0010R\u001a\u0004\u0018\u00010SH\u0002J\u0010\u0010T\u001a\u00020D2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010U\u001a\u00020D2\u0006\u0010G\u001a\u00020\u0002H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010#\"\u0004\b3\u0010%R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010#\"\u0004\b<\u0010%R\u001c\u0010=\u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010#\"\u0004\b?\u0010%R\u001c\u0010@\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0017\"\u0004\bB\u0010\u0019\u00a8\u0006V"}, d2 = {"Lcom/devbeans/io/chat/adapters/viewholders/IncomingConfidentialTextMessageViewHolder;", "Lcom/stfalcon/chatkit/messages/MessageHolders$IncomingTextMessageViewHolder;", "Lcom/devbeans/io/chat/models/Messages;", "itemView", "Landroid/view/View;", "payload", "", "(Landroid/view/View;Ljava/lang/Object;)V", "backgroundLayout", "Landroid/widget/RelativeLayout;", "getBackgroundLayout", "()Landroid/widget/RelativeLayout;", "setBackgroundLayout", "(Landroid/widget/RelativeLayout;)V", "bubbleView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getBubbleView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setBubbleView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "disappearIcon", "Landroid/widget/ImageView;", "getDisappearIcon", "()Landroid/widget/ImageView;", "setDisappearIcon", "(Landroid/widget/ImageView;)V", "downloadButton", "Landroid/widget/LinearLayout;", "getDownloadButton", "()Landroid/widget/LinearLayout;", "setDownloadButton", "(Landroid/widget/LinearLayout;)V", "edited", "Landroid/widget/TextView;", "getEdited", "()Landroid/widget/TextView;", "setEdited", "(Landroid/widget/TextView;)V", "hasFile", "", "getHasFile", "()Z", "setHasFile", "(Z)V", "messages", "getMessages", "()Lcom/devbeans/io/chat/models/Messages;", "setMessages", "(Lcom/devbeans/io/chat/models/Messages;)V", "name", "getName", "setName", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "textMessage", "getTextMessage", "setTextMessage", "tvTime", "getTvTime", "setTvTime", "viewOnceIcon", "getViewOnceIcon", "setViewOnceIcon", "handeAnonymousDownload", "", "file", "Ljava/io/File;", "message", "data", "", "handleAutoDownload", "handleDownloadMedia", "handleDownloader", "handleEditedDeleted", "handleGroupDownload", "handleMedia", "handleOneToOneDownload", "handlePayloadName", "me", "Lcom/devbeans/io/chat/models/ConversationMember;", "init", "onBind", "app_debug"})
public final class IncomingConfidentialTextMessageViewHolder extends com.stfalcon.chatkit.messages.MessageHolders.IncomingTextMessageViewHolder<com.devbeans.io.chat.models.Messages> {
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView textMessage;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView tvTime;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView name;
    @org.jetbrains.annotations.Nullable
    private android.widget.TextView edited;
    @org.jetbrains.annotations.Nullable
    private android.widget.RelativeLayout backgroundLayout;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Messages messages;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView disappearIcon;
    @org.jetbrains.annotations.Nullable
    private android.widget.ImageView viewOnceIcon;
    @org.jetbrains.annotations.Nullable
    private androidx.constraintlayout.widget.ConstraintLayout bubbleView;
    @org.jetbrains.annotations.Nullable
    private android.widget.LinearLayout downloadButton;
    @org.jetbrains.annotations.Nullable
    private android.widget.ProgressBar progressBar;
    private boolean hasFile = false;
    
    public IncomingConfidentialTextMessageViewHolder(@org.jetbrains.annotations.NotNull
    android.view.View itemView, @org.jetbrains.annotations.Nullable
    java.lang.Object payload) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getTextMessage() {
        return null;
    }
    
    public final void setTextMessage(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getTvTime() {
        return null;
    }
    
    public final void setTvTime(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.TextView getEdited() {
        return null;
    }
    
    public final void setEdited(@org.jetbrains.annotations.Nullable
    android.widget.TextView p0) {
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
    public final android.widget.ImageView getDisappearIcon() {
        return null;
    }
    
    public final void setDisappearIcon(@org.jetbrains.annotations.Nullable
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.widget.ImageView getViewOnceIcon() {
        return null;
    }
    
    public final void setViewOnceIcon(@org.jetbrains.annotations.Nullable
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.constraintlayout.widget.ConstraintLayout getBubbleView() {
        return null;
    }
    
    public final void setBubbleView(@org.jetbrains.annotations.Nullable
    androidx.constraintlayout.widget.ConstraintLayout p0) {
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
    
    public final boolean getHasFile() {
        return false;
    }
    
    public final void setHasFile(boolean p0) {
    }
    
    @java.lang.Override
    public void onBind(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void handleMedia(java.io.File file, com.devbeans.io.chat.models.Messages message, java.lang.String data) {
    }
    
    private final void handleDownloadMedia(java.io.File file, com.devbeans.io.chat.models.Messages message, java.lang.String data) {
    }
    
    private final void handleDownloader(java.io.File file, com.devbeans.io.chat.models.Messages message, java.lang.String data) {
    }
    
    private final void handleAutoDownload(java.io.File file, com.devbeans.io.chat.models.Messages message, java.lang.String data) {
    }
    
    private final void handeAnonymousDownload(java.io.File file, com.devbeans.io.chat.models.Messages message, java.lang.String data) {
    }
    
    private final void handleGroupDownload(java.io.File file, com.devbeans.io.chat.models.Messages message, java.lang.String data) {
    }
    
    private final void handleOneToOneDownload(java.io.File file, com.devbeans.io.chat.models.Messages message, java.lang.String data) {
    }
    
    private final void handlePayloadName(com.devbeans.io.chat.models.Messages message, com.devbeans.io.chat.models.ConversationMember me) {
    }
    
    private final void handleEditedDeleted(com.devbeans.io.chat.models.Messages message) {
    }
    
    private final void init(android.view.View itemView) {
    }
}