package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J*\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010!\u001a\u00020\u0018H\u0002J\u0012\u0010\"\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010#\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010&\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\'\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010(\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0018H\u0002J\b\u0010,\u001a\u00020\u001cH\u0016J\b\u0010-\u001a\u00020\u001cH\u0003J\u0012\u0010.\u001a\u00020\u001c2\b\u0010/\u001a\u0004\u0018\u000100H\u0015J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0017J\b\u00105\u001a\u00020\u001cH\u0016J@\u00106\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u00107\u001a\u0004\u0018\u00010\u001a2\b\u00108\u001a\u0004\u0018\u00010\u001a2\u0006\u00109\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u00010\u001a2\u0006\u0010;\u001a\u000202H\u0016JP\u0010<\u001a\u00020\u001c2\b\u0010=\u001a\u0004\u0018\u00010\u00162\b\u00107\u001a\u0004\u0018\u00010\u001a2\b\u00109\u001a\u0004\u0018\u00010\u001a2\u0006\u0010>\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u00010\u001a2\u0006\u0010;\u001a\u0002022\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0016J\b\u0010B\u001a\u00020\u001cH\u0002J$\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020E2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010F\u001a\u00020\u001cH\u0002J\u0010\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020IH\u0002J\u001a\u0010J\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0018\u0010K\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006L"}, d2 = {"Lcom/devbeans/io/chat/activities/ArchiveActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Lcom/devbeans/io/chat/callBacks/ArchiveRoomsListCallback;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "LEAVE_GROUP_LEAVE", "", "LEAVE_GROUP_SHOW_MEMBERS_ACTIVITY", "activeContextMenu", "Lcom/devbeans/io/chat/utils/components/menu/ChatContextMenu;", "mAdapter", "Lcom/devbeans/io/chat/adapters/ArchiveAdapters;", "mBinding", "Lcom/devbeans/io/chat/databinding/ActivityArchiveBinding;", "mTouchListener", "Lcom/devbeans/io/chat/adapters/RecyclerCallBack;", "mViewModel", "Lcom/devbeans/io/chat/viewmodels/ArchiveActivityViewModel;", "getBlockClickListener", "Landroid/view/View$OnClickListener;", "option", "conversation", "Lcom/devbeans/io/chat/models/Conversation;", "alert", "Landroidx/appcompat/app/AlertDialog;", "senderId", "", "handleAddContactDialogButton", "", "mCreateDialogBinding", "Lcom/devbeans/io/chat/databinding/CustomDailogAddContactBinding;", "user", "Lcom/devbeans/io/chat/models/User;", "mCreateDialog", "handleAddToContact", "handleConversationClear", "handleConversationDelete", "handleConversationExit", "handleConversationMute", "handleConversationPinned", "handleConversationUnArchive", "handleConversationUnPinned", "leaveGroup", "dialogOption", "notifyExpiry", "observers", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onResume", "onRoomClick", "name", "chatId", "id", "color", "isContact", "onRoomLongClick", "room", "i", "view", "Landroid/view/View;", "anchor", "populateRecyclerView", "setLeaveGroupTexts", "dialogBinding", "Lcom/devbeans/io/chat/databinding/CustomBlockDailogBinding;", "setSwipeAble", "setToolBar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "showAddContactDialog", "showCustomDialog", "app_debug"})
public final class ArchiveActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements com.devbeans.io.chat.callBacks.ArchiveRoomsListCallback, com.devbeans.io.chat.callBacks.ExpiryCallback {
    private com.devbeans.io.chat.databinding.ActivityArchiveBinding mBinding;
    private com.devbeans.io.chat.adapters.RecyclerCallBack mTouchListener;
    private com.devbeans.io.chat.viewmodels.ArchiveActivityViewModel mViewModel;
    private com.devbeans.io.chat.adapters.ArchiveAdapters mAdapter;
    private com.devbeans.io.chat.utils.components.menu.ChatContextMenu activeContextMenu;
    private final int LEAVE_GROUP_SHOW_MEMBERS_ACTIVITY = 0;
    private final int LEAVE_GROUP_LEAVE = 1;
    
    public ArchiveActivity() {
        super();
    }
    
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.N)
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.N)
    private final void observers() {
    }
    
    private final void setSwipeAble() {
    }
    
    private final void populateRecyclerView() {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    private final void setToolBar(androidx.appcompat.widget.Toolbar toolbar) {
    }
    
    @androidx.annotation.MainThread
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override
    public void onRoomClick(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Conversation conversation, @org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.String chatId, int id, @org.jetbrains.annotations.Nullable
    java.lang.String color, boolean isContact) {
    }
    
    @java.lang.Override
    public void onRoomLongClick(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Conversation room, @org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.String id, int i, @org.jetbrains.annotations.Nullable
    java.lang.String color, boolean isContact, @org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.NotNull
    android.view.View anchor) {
    }
    
    private final void handleConversationExit(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void showCustomDialog(int option, com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final android.view.View.OnClickListener getBlockClickListener(int option, com.devbeans.io.chat.models.Conversation conversation, androidx.appcompat.app.AlertDialog alert, java.lang.String senderId) {
        return null;
    }
    
    private final void setLeaveGroupTexts(com.devbeans.io.chat.databinding.CustomBlockDailogBinding dialogBinding, com.devbeans.io.chat.models.Conversation conversation, java.lang.String senderId) {
    }
    
    private final void leaveGroup(int dialogOption, com.devbeans.io.chat.models.Conversation conversation, androidx.appcompat.app.AlertDialog mCreateDialog) {
    }
    
    private final void handleAddToContact(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    /**
     * Displays a custom dialog to add a contact.
     *
     * @param user the user to add as a contact
     * @param conversation the conversation the user belongs to
     */
    private final void showAddContactDialog(com.devbeans.io.chat.models.User user, com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    /**
     * This function handles the button click for adding a contact.
     * It creates a new contact object with the user details entered by the user.
     * If the contact already exists in the database, it updates it.
     * If not, it adds a new contact.
     * It also updates the conversation name to the user's name.
     */
    private final void handleAddContactDialogButton(com.devbeans.io.chat.databinding.CustomDailogAddContactBinding mCreateDialogBinding, com.devbeans.io.chat.models.User user, com.devbeans.io.chat.models.Conversation conversation, androidx.appcompat.app.AlertDialog mCreateDialog) {
    }
    
    private final void handleConversationDelete(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleConversationClear(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleConversationUnPinned(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleConversationPinned(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleConversationMute(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void handleConversationUnArchive(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    @java.lang.Override
    public void notifyExpiry() {
    }
}