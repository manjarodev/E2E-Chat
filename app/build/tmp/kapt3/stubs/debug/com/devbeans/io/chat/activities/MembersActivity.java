package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001HB\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\bH\u0002J\b\u0010\'\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020$H\u0002J\b\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020$H\u0016J\u0012\u0010+\u001a\u00020$2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J&\u0010.\u001a\u00020$2\f\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u0001002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\bH\u0016J\u0018\u00108\u001a\u00020$2\u0006\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\bH\u0016J\u0010\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020;H\u0017J\b\u0010<\u001a\u00020$H\u0014J*\u0010=\u001a\u00020$2\f\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u0001002\n\u00101\u001a\u0006\u0012\u0002\b\u00030>2\u0006\u00103\u001a\u000204H\u0016J\u0010\u0010?\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010@\u001a\u00020$J\u0016\u0010A\u001a\u00020$2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001e0CH\u0002J\b\u0010D\u001a\u00020$H\u0002J\u0010\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020GH\u0002R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lcom/devbeans/io/chat/activities/MembersActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Lcom/devbeans/io/chat/callBacks/OnLongMemberCallback;", "Lcom/devbeans/io/chat/network/OnNetworkResponse;", "Lcom/devbeans/io/chat/callBacks/OnMembersCallback;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "contactCache", "Ljava/util/HashMap;", "Lcom/devbeans/io/chat/models/Contact;", "conversation_pk", "", "fromOwnerChange", "", "getFromOwnerChange", "()Z", "setFromOwnerChange", "(Z)V", "mBinding", "Lcom/devbeans/io/chat/databinding/ActivityMembersBinding;", "mConversation", "Lcom/devbeans/io/chat/models/Conversation;", "getMConversation", "()Lcom/devbeans/io/chat/models/Conversation;", "setMConversation", "(Lcom/devbeans/io/chat/models/Conversation;)V", "mMember", "Lcom/devbeans/io/chat/models/ConversationMember;", "mMembersAdapter", "Lcom/devbeans/io/chat/adapters/GroupMemberAdapter;", "memberList", "", "changeIndexOfMembers", "", "filter", "text", "getConvoData", "initViews", "listeners", "notifyExpiry", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFailure", "call", "Lretrofit2/Call;", "response", "Lcom/devbeans/io/chat/network/serializers/response/BaseResponse;", "tag", "", "onLongMemberCallback", "member", "name", "onMemberCallback", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "onSuccess", "Lretrofit2/Response;", "ownerLeaveGroup", "populateRecyclerView", "setMembersName", "members", "", "setSearchMembers", "setToolBar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "Companion", "app_debug"})
public final class MembersActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements com.devbeans.io.chat.callBacks.OnLongMemberCallback, com.devbeans.io.chat.network.OnNetworkResponse, com.devbeans.io.chat.callBacks.OnMembersCallback, com.devbeans.io.chat.callBacks.ExpiryCallback {
    private com.devbeans.io.chat.databinding.ActivityMembersBinding mBinding;
    private com.devbeans.io.chat.adapters.GroupMemberAdapter mMembersAdapter;
    private final java.util.List<com.devbeans.io.chat.models.ConversationMember> memberList = null;
    private com.devbeans.io.chat.models.ConversationMember mMember;
    private int conversation_pk = 0;
    private final java.lang.String TAG = null;
    private boolean fromOwnerChange = false;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Conversation mConversation;
    private java.util.HashMap<java.lang.String, com.devbeans.io.chat.models.Contact> contactCache;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.activities.MembersActivity.Companion Companion = null;
    @org.jetbrains.annotations.Nullable
    private static com.devbeans.io.chat.activities.MembersActivity instance;
    
    public MembersActivity() {
        super();
    }
    
    public final boolean getFromOwnerChange() {
        return false;
    }
    
    public final void setFromOwnerChange(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Conversation getMConversation() {
        return null;
    }
    
    public final void setMConversation(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Conversation p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void listeners() {
    }
    
    private final void ownerLeaveGroup(com.devbeans.io.chat.models.ConversationMember mMember) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void getConvoData() {
    }
    
    private final void setSearchMembers() {
    }
    
    private final void filter(java.lang.String text) {
    }
    
    private final void setToolBar(androidx.appcompat.widget.Toolbar toolbar) {
    }
    
    public final void populateRecyclerView() {
    }
    
    private final void setMembersName(java.util.List<com.devbeans.io.chat.models.ConversationMember> members) {
    }
    
    private final void changeIndexOfMembers() {
    }
    
    @androidx.annotation.MainThread
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override
    public void onLongMemberCallback(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.ConversationMember member, @org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    /**
     * Callback for successful network calls.
     * @param call The executed call.
     * @param response The response for the executed call.
     * @param tag An object used for identifying the call.
     * @throws ParseException if any error occurs during parsing the response.
     */
    @kotlin.jvm.Throws(exceptionClasses = {java.text.ParseException.class})
    @java.lang.Override
    public void onSuccess(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    retrofit2.Response<?> response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    @java.lang.Override
    public void onFailure(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.network.serializers.response.BaseResponse response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    @java.lang.Override
    public void onMemberCallback(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.ConversationMember member, @org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    @java.lang.Override
    public void notifyExpiry() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007\u00a2\u0006\u0002\b\tR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/devbeans/io/chat/activities/MembersActivity$Companion;", "", "()V", "instance", "Lcom/devbeans/io/chat/activities/MembersActivity;", "getInstance", "()Lcom/devbeans/io/chat/activities/MembersActivity;", "setInstance", "(Lcom/devbeans/io/chat/activities/MembersActivity;)V", "getInstance1", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.activities.MembersActivity getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.activities.MembersActivity p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        @kotlin.jvm.JvmName(name = "getInstance1")
        public final com.devbeans.io.chat.activities.MembersActivity getInstance1() {
            return null;
        }
    }
}