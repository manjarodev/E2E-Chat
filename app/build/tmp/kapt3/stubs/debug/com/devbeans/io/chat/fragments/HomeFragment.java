package com.devbeans.io.chat.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 k2\u00020\u00012\u00020\u0002:\u0001kB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\bH\u0003J*\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\bH\u0002J*\u00106\u001a\u00020,2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u0010;\u001a\u000204H\u0002J\u0012\u0010<\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0012\u0010=\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0012\u0010>\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0010\u0010?\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0002J\u0010\u0010@\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0002J\u0012\u0010A\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0012\u0010B\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0010\u0010C\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0002J \u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020\u00052\u0006\u00101\u001a\u0002022\u0006\u0010;\u001a\u000204H\u0002J\b\u0010F\u001a\u00020,H\u0002J\b\u0010G\u001a\u00020,H\u0003J\u0010\u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020JH\u0016J\u0012\u0010K\u001a\u00020,2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J&\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010L\u001a\u0004\u0018\u00010MH\u0017J\b\u0010T\u001a\u00020,H\u0016J\b\u0010U\u001a\u00020,H\u0016J\b\u0010V\u001a\u00020,H\u0017J8\u0010W\u001a\u00020,2\u0006\u00101\u001a\u0002022\u0006\u0010X\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\b2\u0006\u0010\\\u001a\u00020]H\u0016JP\u0010^\u001a\u00020,2\b\u0010_\u001a\u0004\u0018\u0001022\b\u0010X\u001a\u0004\u0018\u00010\b2\b\u0010Z\u001a\u0004\u0018\u00010\b2\u0006\u0010`\u001a\u00020\u00052\b\u0010[\u001a\u0004\u0018\u00010\b2\u0006\u0010\\\u001a\u00020]2\u0006\u0010a\u001a\u00020O2\u0006\u0010b\u001a\u00020OH\u0016J\b\u0010c\u001a\u00020,H\u0002J$\u0010d\u001a\u00020,2\u0006\u0010e\u001a\u00020f2\b\u00101\u001a\u0004\u0018\u0001022\b\u00105\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010g\u001a\u00020,H\u0002J\b\u0010h\u001a\u00020,H\u0002J\u001a\u0010i\u001a\u00020,2\u0006\u00109\u001a\u00020:2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0018\u0010j\u001a\u00020,2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u000202H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010&\u001a\u0004\u0018\u00010\'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b(\u0010)\u00a8\u0006l"}, d2 = {"Lcom/devbeans/io/chat/fragments/HomeFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/devbeans/io/chat/callBacks/RoomsListCallback;", "()V", "LEAVE_GROUP_LEAVE", "", "LEAVE_GROUP_SHOW_MEMBERS_ACTIVITY", "TAG", "", "kotlin.jvm.PlatformType", "activeContextMenu", "Lcom/devbeans/io/chat/utils/components/menu/ChatContextMenu;", "contactsDao", "Lcom/devbeans/io/chat/roomDB/Dao/ContactsDao;", "getContactsDao", "()Lcom/devbeans/io/chat/roomDB/Dao/ContactsDao;", "contactsDao$delegate", "Lkotlin/Lazy;", "conversationChannelsDao", "Lcom/devbeans/io/chat/roomDB/Dao/ConversationChannelsDao;", "getConversationChannelsDao", "()Lcom/devbeans/io/chat/roomDB/Dao/ConversationChannelsDao;", "conversationChannelsDao$delegate", "conversationsDao", "Lcom/devbeans/io/chat/roomDB/Dao/ConversationsDao;", "getConversationsDao", "()Lcom/devbeans/io/chat/roomDB/Dao/ConversationsDao;", "conversationsDao$delegate", "mAdapter", "Lcom/devbeans/io/chat/adapters/HomeFragmentAdapter;", "mBinding", "Lcom/devbeans/io/chat/databinding/FragmentHomeBinding;", "mMessageReceiver", "Landroid/content/BroadcastReceiver;", "mTouchListener", "Lcom/devbeans/io/chat/adapters/RecyclerCallBack;", "mViewModel", "Lcom/devbeans/io/chat/viewmodels/HomeFragmentViewModel;", "messagesDao", "Lcom/devbeans/io/chat/roomDB/Dao/MessagesDao;", "getMessagesDao", "()Lcom/devbeans/io/chat/roomDB/Dao/MessagesDao;", "messagesDao$delegate", "filter", "", "text", "getBlockClickListener", "Landroid/view/View$OnClickListener;", "option", "conversation", "Lcom/devbeans/io/chat/models/Conversation;", "alert", "Landroidx/appcompat/app/AlertDialog;", "senderId", "handleAddContactDialogButton", "mCreateDialogBinding", "Lcom/devbeans/io/chat/databinding/CustomDailogAddContactBinding;", "user", "Lcom/devbeans/io/chat/models/User;", "mCreateDialog", "handleAddToContact", "handleConversationArchive", "handleConversationClear", "handleConversationDelete", "handleConversationExit", "handleConversationMute", "handleConversationPinned", "handleConversationUnPinned", "leaveGroup", "dialogOption", "listeners", "observers", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onResume", "onRoomClick", "name", "chatId", "id", "color", "isContact", "", "onRoomLongClick", "room", "i", "view", "anchor", "populateRecyclerView", "setLeaveGroupTexts", "dialogBinding", "Lcom/devbeans/io/chat/databinding/CustomBlockDailogBinding;", "setSearchConversations", "setSwipeAble", "showAddContactDialog", "showCustomDialog", "Companion", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment implements com.devbeans.io.chat.callBacks.RoomsListCallback {
    private com.devbeans.io.chat.databinding.FragmentHomeBinding mBinding;
    private com.devbeans.io.chat.viewmodels.HomeFragmentViewModel mViewModel;
    private com.devbeans.io.chat.adapters.HomeFragmentAdapter mAdapter;
    private com.devbeans.io.chat.adapters.RecyclerCallBack mTouchListener;
    private final java.lang.String TAG = null;
    private com.devbeans.io.chat.utils.components.menu.ChatContextMenu activeContextMenu;
    private final int LEAVE_GROUP_SHOW_MEMBERS_ACTIVITY = 0;
    private final int LEAVE_GROUP_LEAVE = 1;
    private final kotlin.Lazy conversationsDao$delegate = null;
    private final kotlin.Lazy messagesDao$delegate = null;
    private final kotlin.Lazy contactsDao$delegate = null;
    private final kotlin.Lazy conversationChannelsDao$delegate = null;
    private final android.content.BroadcastReceiver mMessageReceiver = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.fragments.HomeFragment.Companion Companion = null;
    
    public HomeFragment() {
        super();
    }
    
    private final com.devbeans.io.chat.roomDB.Dao.ConversationsDao getConversationsDao() {
        return null;
    }
    
    private final com.devbeans.io.chat.roomDB.Dao.MessagesDao getMessagesDao() {
        return null;
    }
    
    private final com.devbeans.io.chat.roomDB.Dao.ContactsDao getContactsDao() {
        return null;
    }
    
    private final com.devbeans.io.chat.roomDB.Dao.ConversationChannelsDao getConversationChannelsDao() {
        return null;
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.N)
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void listeners() {
    }
    
    private final void setSwipeAble() {
    }
    
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.N)
    private final void observers() {
    }
    
    private final void setSearchConversations() {
    }
    
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.N)
    private final void filter(java.lang.String text) {
    }
    
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.N)
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    private final void populateRecyclerView() {
    }
    
    @java.lang.Override
    public void onRoomClick(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Conversation conversation, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String chatId, int id, @org.jetbrains.annotations.NotNull
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
    
    private final void handleConversationArchive(com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/devbeans/io/chat/fragments/HomeFragment$Companion;", "", "()V", "newInstance", "Lcom/devbeans/io/chat/fragments/HomeFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.fragments.HomeFragment newInstance() {
            return null;
        }
    }
}