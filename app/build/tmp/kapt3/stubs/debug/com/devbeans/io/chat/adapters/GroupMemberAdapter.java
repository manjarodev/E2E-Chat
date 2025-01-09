package com.devbeans.io.chat.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u001e\u0010:\u001a\u00020;2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u001e0<2\u0006\u0010=\u001a\u000205H\u0003J\u0014\u0010>\u001a\u00020;2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u001a\u0010?\u001a\u00020\u00122\b\u0010@\u001a\u0004\u0018\u00010\u00132\u0006\u0010A\u001a\u00020\u001eH\u0002J\b\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u000205H\u0016J \u0010E\u001a\u00020;2\u0006\u0010F\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u001e2\u0006\u0010=\u001a\u000205H\u0002J\u0018\u0010G\u001a\u00020;2\u0006\u0010F\u001a\u00020\u00022\u0006\u0010=\u001a\u000205H\u0002J\u0010\u0010H\u001a\u00020;2\u0006\u0010H\u001a\u00020\tH\u0007J\b\u0010I\u001a\u00020;H\u0002J\u001a\u0010J\u001a\u00020;2\u0006\u0010F\u001a\u00020\u00022\b\b\u0001\u0010=\u001a\u000205H\u0016J\u0018\u0010K\u001a\u00020\u00022\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u000205H\u0016J\u001c\u0010*\u001a\u00020;2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010%\u001a\u00020\tR\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010!\"\u0004\b$\u0010#R\u001a\u0010%\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R \u0010\'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006O"}, d2 = {"Lcom/devbeans/io/chat/adapters/GroupMemberAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/devbeans/io/chat/adapters/viewholders/GroupMemberViewHolder;", "Landroid/widget/Filterable;", "conversation", "Lcom/devbeans/io/chat/models/Conversation;", "context", "Landroid/content/Context;", "isChatDetails", "", "onLongMemberCallback", "Lcom/devbeans/io/chat/callBacks/OnLongMemberCallback;", "onMembersCallback", "Lcom/devbeans/io/chat/callBacks/OnMembersCallback;", "(Lcom/devbeans/io/chat/models/Conversation;Landroid/content/Context;ZLcom/devbeans/io/chat/callBacks/OnLongMemberCallback;Lcom/devbeans/io/chat/callBacks/OnMembersCallback;)V", "changeOwner", "contactCache", "Ljava/util/HashMap;", "", "Lcom/devbeans/io/chat/models/Contact;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getConversation", "()Lcom/devbeans/io/chat/models/Conversation;", "setConversation", "(Lcom/devbeans/io/chat/models/Conversation;)V", "filteredMemberList", "", "Lcom/devbeans/io/chat/models/ConversationMember;", "haveLoaded", "getHaveLoaded", "()Z", "setHaveLoaded", "(Z)V", "setChatDetails", "isLimited", "setLimited", "memberList", "getMemberList", "()Ljava/util/List;", "setMemberList", "(Ljava/util/List;)V", "getOnLongMemberCallback", "()Lcom/devbeans/io/chat/callBacks/OnLongMemberCallback;", "setOnLongMemberCallback", "(Lcom/devbeans/io/chat/callBacks/OnLongMemberCallback;)V", "getOnMembersCallback", "()Lcom/devbeans/io/chat/callBacks/OnMembersCallback;", "setOnMembersCallback", "(Lcom/devbeans/io/chat/callBacks/OnMembersCallback;)V", "selected_pos", "", "getSelected_pos", "()I", "setSelected_pos", "(I)V", "deselectOtherMember", "", "", "position", "filteredList", "getChatName", "contact", "member", "getFilter", "Landroid/widget/Filter;", "getItemCount", "handleCheckOffClick", "holder", "handleOwnerChangeData", "isChangeOwner", "loadContactsIntoCache", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_debug"})
public final class GroupMemberAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.devbeans.io.chat.adapters.viewholders.GroupMemberViewHolder> implements android.widget.Filterable {
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.models.Conversation conversation;
    @org.jetbrains.annotations.NotNull
    private android.content.Context context;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.devbeans.io.chat.models.ConversationMember> memberList;
    private java.util.List<com.devbeans.io.chat.models.ConversationMember> filteredMemberList;
    private java.util.HashMap<java.lang.String, com.devbeans.io.chat.models.Contact> contactCache;
    private boolean isLimited = false;
    private boolean isChatDetails = false;
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.callBacks.OnLongMemberCallback onLongMemberCallback;
    @org.jetbrains.annotations.NotNull
    private com.devbeans.io.chat.callBacks.OnMembersCallback onMembersCallback;
    private boolean changeOwner = false;
    private int selected_pos = -1;
    private boolean haveLoaded = false;
    
    public GroupMemberAdapter(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Conversation conversation, @org.jetbrains.annotations.NotNull
    android.content.Context context, boolean isChatDetails, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.OnLongMemberCallback onLongMemberCallback, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.OnMembersCallback onMembersCallback) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.models.Conversation getConversation() {
        return null;
    }
    
    public final void setConversation(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Conversation p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.devbeans.io.chat.models.ConversationMember> getMemberList() {
        return null;
    }
    
    public final void setMemberList(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.ConversationMember> p0) {
    }
    
    public final boolean isLimited() {
        return false;
    }
    
    public final void setLimited(boolean p0) {
    }
    
    public final boolean isChatDetails() {
        return false;
    }
    
    public final void setChatDetails(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.callBacks.OnLongMemberCallback getOnLongMemberCallback() {
        return null;
    }
    
    public final void setOnLongMemberCallback(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.OnLongMemberCallback p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.callBacks.OnMembersCallback getOnMembersCallback() {
        return null;
    }
    
    public final void setOnMembersCallback(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.OnMembersCallback p0) {
    }
    
    public final int getSelected_pos() {
        return 0;
    }
    
    public final void setSelected_pos(int p0) {
    }
    
    public final boolean getHaveLoaded() {
        return false;
    }
    
    public final void setHaveLoaded(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.devbeans.io.chat.adapters.viewholders.GroupMemberViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    /**
     * Method to bind data to the RecyclerView's ViewHolder.
     *
     * @param holder GroupMemberViewHolder instance to populate with data.
     * @param position Position of the data in the list.
     */
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.adapters.viewholders.GroupMemberViewHolder holder, @android.annotation.SuppressLint(value = {"RecyclerView"})
    int position) {
    }
    
    /**
     * Handle the data setting when owner is being changed.
     *
     * @param holder GroupMemberViewHolder instance to populate with data.
     * @param position Position of the member in the list.
     */
    private final void handleOwnerChangeData(com.devbeans.io.chat.adapters.viewholders.GroupMemberViewHolder holder, int position) {
    }
    
    private final java.lang.String getChatName(com.devbeans.io.chat.models.Contact contact, com.devbeans.io.chat.models.ConversationMember member) {
        return null;
    }
    
    private final void handleCheckOffClick(com.devbeans.io.chat.adapters.viewholders.GroupMemberViewHolder holder, com.devbeans.io.chat.models.ConversationMember member, int position) {
    }
    
    /**
     * Deselects all members except the one at the given position.
     *
     * @param memberList The list of members.
     * @param position The position of the member to remain selected.
     */
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    private final void deselectOtherMember(java.util.List<com.devbeans.io.chat.models.ConversationMember> memberList, int position) {
    }
    
    public final void setMemberList(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.ConversationMember> memberList, boolean isLimited) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void filteredList(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.ConversationMember> filteredList) {
    }
    
    /**
     * This method sets the changeOwner value and, if isChangeOwner is true,
     * removes the member who matches the current chatUserId from memberList.
     * It then notifies that the data set has changed.
     *
     * @param isChangeOwner flag to determine if the owner is to be changed
     */
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void isChangeOwner(boolean isChangeOwner) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.widget.Filter getFilter() {
        return null;
    }
    
    /**
     * Load all contacts into cache.
     *
     * Note: Ideally, this operation should be moved to a ViewModel or another class
     *      responsible for database operations. Adapter should not interact with database directly.
     */
    private final void loadContactsIntoCache() {
    }
}