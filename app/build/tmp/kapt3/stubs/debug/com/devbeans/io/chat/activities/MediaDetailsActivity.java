package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0019H\u0016J\u0010\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0019H\u0016J\u0010\u0010\'\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0019H\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u001eH\u0002J\u0010\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\bH\u0002J\u0010\u0010,\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010-\u001a\u00020\u001e2\b\u0010.\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010/\u001a\u00020\bH\u0002J\b\u00100\u001a\u00020\bH\u0002J\b\u00101\u001a\u00020\bH\u0002J\b\u00102\u001a\u00020\bH\u0016J\b\u00103\u001a\u00020\bH\u0002J\b\u00104\u001a\u00020\bH\u0016J\u0012\u00105\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u000107H\u0014J\u0010\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020\bH\u0014J\u0010\u0010<\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0019H\u0016J\u0010\u0010=\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0019H\u0016J\u0010\u0010>\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0019H\u0016J\u0010\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0019H\u0002J\u0010\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u0006H\u0002J\u0010\u0010H\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u001bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\r\u0012\t\u0012\u00070\u001e\u00a2\u0006\u0002\b\u001f0\u001dX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010 R\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006J"}, d2 = {"Lcom/devbeans/io/chat/activities/MediaDetailsActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Lcom/devbeans/io/chat/callBacks/OnMediaSelectCallback;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "count", "", "getRoomData", "", "getGetRoomData", "()Lkotlin/Unit;", "mAdapter", "Lcom/devbeans/io/chat/adapters/MediaDetailsAdapter;", "mBinding", "Lcom/devbeans/io/chat/databinding/ActivityMediaDetailsBinding;", "getMBinding", "()Lcom/devbeans/io/chat/databinding/ActivityMediaDetailsBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/ActivityMediaDetailsBinding;)V", "mConversation", "Lcom/devbeans/io/chat/models/Conversation;", "mCreateDialog", "Landroidx/appcompat/app/AlertDialog;", "mediaList", "", "Lcom/devbeans/io/chat/models/Payload;", "selectionMode", "", "titles", "", "", "Llombok/NonNull;", "[Ljava/lang/String;", "touchableList", "Ljava/util/ArrayList;", "Landroid/view/View;", "addDoc", "payload", "addLink", "addMedia", "deleteLastMessageIfMatches", "messageId", "deleteMessageChatActivity", "deleteSelectedMedia", "getCount", "getMediaType", "type", "initViews", "initializeMedia", "listeners", "notifyExpiry", "observers", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "removeDoc", "removeLink", "removeMedia", "setToolBar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "setupViewPager", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "shareSingleMediaPayload", "showCustomDialog", "i", "stopPager", "selection", "app_debug"})
public final class MediaDetailsActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements com.devbeans.io.chat.callBacks.OnMediaSelectCallback, com.devbeans.io.chat.callBacks.ExpiryCallback {
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.databinding.ActivityMediaDetailsBinding mBinding;
    private com.devbeans.io.chat.adapters.MediaDetailsAdapter mAdapter;
    private com.devbeans.io.chat.models.Conversation mConversation;
    private androidx.appcompat.app.AlertDialog mCreateDialog;
    private int count = 0;
    private java.util.ArrayList<android.view.View> touchableList;
    private java.util.List<com.devbeans.io.chat.models.Payload> mediaList;
    private boolean selectionMode = false;
    private final java.lang.String[] titles = null;
    
    public MediaDetailsActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.databinding.ActivityMediaDetailsBinding getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.databinding.ActivityMediaDetailsBinding p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initializeMedia() {
    }
    
    private final void listeners() {
    }
    
    /**
     * This function is used to share a single media payload. It first determines the type of the media.
     * Then, it checks if the corresponding file exists. If it does, an intent is created to share the media.
     * @param payload: The media payload to be shared
     */
    private final void shareSingleMediaPayload(com.devbeans.io.chat.models.Payload payload) {
    }
    
    /**
     * This function determines the media type of a payload.
     * If the payload type is not one of the known types (image, video, audio, file),
     * it defaults to "file".
     * @param type: The type of the payload
     * @return The determined media type
     */
    private final java.lang.String getMediaType(java.lang.String type) {
        return null;
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    private final void showCustomDialog(int i) {
    }
    
    /**
     * This function is used to delete the selected media messages from a conversation.
     * It deletes both the message record from the database and the associated media file if it exists.
     */
    private final void deleteSelectedMedia() {
    }
    
    private final void deleteMessageChatActivity(java.lang.String messageId) {
    }
    
    /**
     * If the last message of the conversation matches with the provided messageId,
     * it updates the conversation to not have a last message.
     * @param messageId: The messageId to compare with the last message of the conversation
     */
    private final void deleteLastMessageIfMatches(java.lang.String messageId) {
    }
    
    private final void observers() {
    }
    
    private final kotlin.Unit getGetRoomData() {
        return null;
    }
    
    /**
     * Function to initialize the views used in this activity.
     * Sets up the tab layout with custom text views and defines behavior on tab selection.
     * If a conversation is present, updates the toolbar name accordingly.
     * Also manages the visibility of share and delete icons.
     */
    private final void initViews() {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void setToolBar(androidx.appcompat.widget.Toolbar toolbar) {
    }
    
    private final void setupViewPager(androidx.viewpager2.widget.ViewPager2 viewPager2) {
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    /**
     * Callback methods which are to be used when longClick is initiated
     * in [MediaFragment] , [DocsFragment] , [LinksFragment]
     */
    @java.lang.Override
    public void addMedia(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload) {
    }
    
    /**
     * Callback methods which are to be used when longClick is initiated
     * in [MediaFragment] , [DocsFragment] , [LinksFragment]
     */
    @java.lang.Override
    public void removeMedia(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload) {
    }
    
    @java.lang.Override
    public void addDoc(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload) {
    }
    
    @java.lang.Override
    public void removeDoc(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload) {
    }
    
    @java.lang.Override
    public void addLink(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload) {
    }
    
    @java.lang.Override
    public void removeLink(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload) {
    }
    
    /**
     * Callback methods which are to be used when longClick is initiated
     * in [MediaFragment] , [DocsFragment] , [LinksFragment]
     */
    @java.lang.Override
    public void stopPager(boolean selection) {
    }
    
    @java.lang.Override
    public void getCount(int count) {
    }
    
    @java.lang.Override
    public void notifyExpiry() {
    }
}