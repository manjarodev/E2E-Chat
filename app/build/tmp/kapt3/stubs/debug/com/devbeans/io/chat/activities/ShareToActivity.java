package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001c\u001a\u00020\u000bH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010$\u001a\u00020\u00172\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0&H\u0002J\u0010\u0010\'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\bH\u0002J\u001e\u0010)\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u001e\u0010+\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H\u0002J\u001e\u0010,\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H\u0002J\b\u0010-\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u0017H\u0002J\b\u0010/\u001a\u00020\u0017H\u0002J\b\u00100\u001a\u00020\u0017H\u0016J\b\u00101\u001a\u00020\u0017H\u0002J$\u00102\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\u001bH\u0016J\u0012\u00106\u001a\u00020\u00172\b\u00107\u001a\u0004\u0018\u000108H\u0014J\u0010\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020;H\u0017J\b\u0010<\u001a\u00020\u0017H\u0014J8\u0010=\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\u0006\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020\u000bH\u0016J\b\u0010C\u001a\u00020\u0017H\u0002J\b\u0010D\u001a\u00020\u0017H\u0002J\u0016\u0010E\u001a\u00020\u00172\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H\u0002J\b\u0010F\u001a\u00020\u0017H\u0002J\u0010\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u00020\u0017H\u0002J\b\u0010K\u001a\u00020\u0017H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006L"}, d2 = {"Lcom/devbeans/io/chat/activities/ShareToActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Lcom/devbeans/io/chat/callBacks/ShareRoomsListCallback;", "Lcom/devbeans/io/chat/callBacks/ShareContactsCallback;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "chatRoomToSend", "", "Lcom/devbeans/io/chat/models/Conversation;", "conversation", "isFromVault", "", "listOfContact", "Lcom/devbeans/io/chat/models/Contact;", "mAdapter", "Lcom/devbeans/io/chat/adapters/ShareToAdapter;", "mBinding", "Lcom/devbeans/io/chat/databinding/ActivityShareToBinding;", "mShareAdapter", "Lcom/devbeans/io/chat/adapters/ShareContactAdapter;", "payload", "Lcom/devbeans/io/chat/models/Payload;", "roomData", "", "getRoomData", "()Lkotlin/Unit;", "selectedTime", "", "checkContactsUI", "checkConversation", "contact", "checkRecentChatsUI", "filterContacts", "text", "", "filterRecentChat", "getChatRooms", "conversations", "", "handleOneToOneWithBlock", "c", "handleRecentUis", "filteredList", "handleUi", "handleUis", "hideContactsUI", "hideRecentChatsUI", "initViews", "notifyExpiry", "observers", "onContactClick", "viewHolder", "Lcom/devbeans/io/chat/adapters/viewholders/ShareContactViewHolder;", "position", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "onShareRoomClick", "name", "chatId", "id", "color", "isContact", "populateRecyclerView", "setContactToShow", "setContactsForRecycler", "setSearchConversations", "setToolBar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "showContactsUI", "showRecentChatsUI", "app_debug"})
public final class ShareToActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements com.devbeans.io.chat.callBacks.ShareRoomsListCallback, com.devbeans.io.chat.callBacks.ShareContactsCallback, com.devbeans.io.chat.callBacks.ExpiryCallback {
    private java.util.List<com.devbeans.io.chat.models.Contact> listOfContact;
    private boolean isFromVault = false;
    private com.devbeans.io.chat.databinding.ActivityShareToBinding mBinding;
    private com.devbeans.io.chat.models.Payload payload;
    private com.devbeans.io.chat.models.Conversation conversation;
    private com.devbeans.io.chat.adapters.ShareToAdapter mAdapter;
    private com.devbeans.io.chat.adapters.ShareContactAdapter mShareAdapter;
    private final java.util.List<com.devbeans.io.chat.models.Conversation> chatRoomToSend = null;
    private int selectedTime = 1800000;
    
    public ShareToActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void hideContactsUI() {
    }
    
    private final void showContactsUI() {
    }
    
    private final void hideRecentChatsUI() {
    }
    
    private final boolean checkRecentChatsUI() {
        return false;
    }
    
    private final void showRecentChatsUI() {
    }
    
    private final void observers() {
    }
    
    private final void getChatRooms(java.util.List<com.devbeans.io.chat.models.Conversation> conversations) {
    }
    
    private final void handleOneToOneWithBlock(com.devbeans.io.chat.models.Conversation c) {
    }
    
    private final void setContactToShow() {
    }
    
    private final void setContactsForRecycler(java.util.List<com.devbeans.io.chat.models.Contact> listOfContact) {
    }
    
    private final kotlin.Unit getRoomData() {
        return null;
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void setToolBar(androidx.appcompat.widget.Toolbar toolbar) {
    }
    
    private final void populateRecyclerView() {
    }
    
    private final void setSearchConversations() {
    }
    
    private final void filterContacts(java.lang.String text) {
    }
    
    private final void handleUis(java.lang.String text, java.util.List<com.devbeans.io.chat.models.Contact> filteredList) {
    }
    
    private final void handleUi(java.lang.String text, java.util.List<com.devbeans.io.chat.models.Contact> filteredList) {
    }
    
    private final boolean checkContactsUI() {
        return false;
    }
    
    private final void filterRecentChat(java.lang.String text) {
    }
    
    private final void handleRecentUis(java.lang.String text, java.util.List<com.devbeans.io.chat.models.Conversation> filteredList) {
    }
    
    @androidx.annotation.MainThread
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    private final com.devbeans.io.chat.models.Conversation checkConversation(com.devbeans.io.chat.models.Contact contact) {
        return null;
    }
    
    @java.lang.Override
    public void onShareRoomClick(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Conversation conversation, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String chatId, int id, @org.jetbrains.annotations.NotNull
    java.lang.String color, boolean isContact) {
    }
    
    @java.lang.Override
    public void onContactClick(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Contact contact, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.adapters.viewholders.ShareContactViewHolder viewHolder, int position) {
    }
    
    @java.lang.Override
    public void notifyExpiry() {
    }
}