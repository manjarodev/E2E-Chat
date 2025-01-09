package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00d0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 y2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001yB\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\tH\u0002J\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020B2\u0006\u0010F\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020BH\u0002J\b\u0010I\u001a\u00020BH\u0002J\b\u0010J\u001a\u00020BH\u0002J\b\u0010K\u001a\u00020BH\u0002J\b\u0010L\u001a\u00020BH\u0002J\b\u0010M\u001a\u00020BH\u0016J\b\u0010N\u001a\u00020BH\u0002J\"\u0010O\u001a\u00020B2\u0006\u0010P\u001a\u00020:2\u0006\u0010Q\u001a\u00020:2\b\u0010R\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010S\u001a\u00020BH\u0016J0\u0010T\u001a\u00020B2\u0006\u0010@\u001a\u00020\t2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020:2\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020\u000fH\u0016J \u0010Z\u001a\u00020B2\u0006\u0010@\u001a\u00020\t2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020:H\u0016J\u0012\u0010[\u001a\u00020B2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0014J&\u0010^\u001a\u00020B2\f\u0010_\u001a\b\u0012\u0002\b\u0003\u0018\u00010`2\u0006\u0010a\u001a\u00020G2\u0006\u0010b\u001a\u00020cH\u0016J0\u0010d\u001a\u00020B2\u0006\u0010@\u001a\u00020\t2\u0006\u0010e\u001a\u00020f2\u0006\u0010W\u001a\u00020:2\u0006\u0010g\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020\u000fH\u0016J\b\u0010h\u001a\u00020BH\u0014J*\u0010i\u001a\u00020B2\f\u0010_\u001a\b\u0012\u0002\b\u0003\u0018\u00010`2\n\u0010a\u001a\u0006\u0012\u0002\b\u00030j2\u0006\u0010b\u001a\u00020cH\u0016J\u0010\u0010k\u001a\u00020B2\u0006\u0010 \u001a\u00020\u000fH\u0002J\u0010\u0010l\u001a\u00020B2\u0006\u0010 \u001a\u00020\u000fH\u0002J\b\u0010m\u001a\u00020BH\u0002J\u0010\u0010n\u001a\u00020B2\u0006\u0010o\u001a\u00020pH\u0002J\b\u0010q\u001a\u00020BH\u0002J\b\u0010r\u001a\u00020BH\u0002J\b\u0010s\u001a\u00020BH\u0002J\b\u0010t\u001a\u00020BH\u0002J\b\u0010u\u001a\u00020BH\u0004J\b\u0010v\u001a\u00020BH\u0002J\u0010\u0010w\u001a\u00020B2\u0006\u0010x\u001a\u00020DH\u0002R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\rR\u000e\u0010\u001f\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\'\u001a\u0004\u0018\u00010(X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010(X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0004\u0018\u000104X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u00106\"\u0004\b=\u00108\u00a8\u0006z"}, d2 = {"Lcom/devbeans/io/chat/activities/NewMessageActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Lcom/devbeans/io/chat/callBacks/ContactsCallback;", "Lcom/devbeans/io/chat/network/OnNetworkResponse;", "Lcom/devbeans/io/chat/callBacks/MemberAddCallback;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "SelectedGroupMembers", "", "Lcom/devbeans/io/chat/models/Contact;", "getSelectedGroupMembers", "()Ljava/util/List;", "setSelectedGroupMembers", "(Ljava/util/List;)V", "addedByQr", "", "apkFile", "Ljava/io/File;", "contacts", "getContacts", "setContacts", "disappearActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "getDisappearActivityResultLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setDisappearActivityResultLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "groupMembers", "getGroupMembers", "setGroupMembers", "isAnonymous", "isGroup", "isMembersSelected", "()Z", "setMembersSelected", "(Z)V", "mAdapter", "Lcom/devbeans/io/chat/adapters/NewMessageAdapter;", "mAddContact", "Landroidx/appcompat/widget/AppCompatButton;", "mBinding", "Lcom/devbeans/io/chat/databinding/ActivityNewMessageBinding;", "mCancel", "mDialog", "Landroidx/appcompat/app/AlertDialog;", "mFile", "mGroupAdapter", "Lcom/devbeans/io/chat/adapters/NewGroupAdapter;", "mViewModel", "Lcom/devbeans/io/chat/viewmodels/NewMessageViewModel;", "nameEdit", "Lcom/google/android/material/textfield/TextInputEditText;", "getNameEdit", "()Lcom/google/android/material/textfield/TextInputEditText;", "setNameEdit", "(Lcom/google/android/material/textfield/TextInputEditText;)V", "selected_time", "", "userIdEdit", "getUserIdEdit", "setUserIdEdit", "checkConversation", "Lcom/devbeans/io/chat/models/Conversation;", "contact", "filter", "", "text", "", "handleAddContact", "res", "Lcom/devbeans/io/chat/network/serializers/response/BaseResponse;", "handleBtnCreateGroupClick", "handleConfirmCreateClick", "initDialog", "listeners", "moveAssetsToInternal", "notifyExpiry", "observers", "onActivityResult", "requestCode", "resultCode", "data", "onBackPressed", "onCheckBoxClick", "viewHolder", "Lcom/devbeans/io/chat/adapters/viewholders/ContactViewHolder;", "position", "isFromGroupAdapter", "isChecked", "onContactClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFailure", "call", "Lretrofit2/Call;", "response", "tag", "", "onMemberAddClick", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isFromMember", "onResume", "onSuccess", "Lretrofit2/Response;", "populateRecyclerView", "populateRecyclerViewGroup", "setSearchContacts", "setToolBar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "setupActivityResultLauncher", "setupAppContextAndNotifications", "setupDataBindingAndViewModel", "setupUIComponents", "showLoadingDialog", "updateGroupUI", "verifyUser", "userId", "Companion", "app_debug"})
public final class NewMessageActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements com.devbeans.io.chat.callBacks.ContactsCallback, com.devbeans.io.chat.network.OnNetworkResponse, com.devbeans.io.chat.callBacks.MemberAddCallback, com.devbeans.io.chat.callBacks.ExpiryCallback {
    private boolean addedByQr = false;
    private com.devbeans.io.chat.databinding.ActivityNewMessageBinding mBinding;
    private com.devbeans.io.chat.viewmodels.NewMessageViewModel mViewModel;
    private final androidx.appcompat.widget.AppCompatButton mCancel = null;
    private final androidx.appcompat.widget.AppCompatButton mAddContact = null;
    private androidx.appcompat.app.AlertDialog mDialog;
    private com.devbeans.io.chat.adapters.NewMessageAdapter mAdapter;
    private com.devbeans.io.chat.adapters.NewGroupAdapter mGroupAdapter;
    @org.jetbrains.annotations.Nullable
    private com.google.android.material.textfield.TextInputEditText userIdEdit;
    @org.jetbrains.annotations.Nullable
    private com.google.android.material.textfield.TextInputEditText nameEdit;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.devbeans.io.chat.models.Contact> contacts;
    private boolean isMembersSelected = false;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.devbeans.io.chat.models.Contact> groupMembers;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.devbeans.io.chat.models.Contact> SelectedGroupMembers;
    private boolean isGroup = false;
    private boolean isAnonymous = false;
    private int selected_time;
    private java.io.File mFile;
    private java.io.File apkFile;
    @org.jetbrains.annotations.Nullable
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> disappearActivityResultLauncher;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.activities.NewMessageActivity.Companion Companion = null;
    
    public NewMessageActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.android.material.textfield.TextInputEditText getUserIdEdit() {
        return null;
    }
    
    public final void setUserIdEdit(@org.jetbrains.annotations.Nullable
    com.google.android.material.textfield.TextInputEditText p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.android.material.textfield.TextInputEditText getNameEdit() {
        return null;
    }
    
    public final void setNameEdit(@org.jetbrains.annotations.Nullable
    com.google.android.material.textfield.TextInputEditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.devbeans.io.chat.models.Contact> getContacts() {
        return null;
    }
    
    public final void setContacts(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Contact> p0) {
    }
    
    public final boolean isMembersSelected() {
        return false;
    }
    
    public final void setMembersSelected(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.devbeans.io.chat.models.Contact> getGroupMembers() {
        return null;
    }
    
    public final void setGroupMembers(@org.jetbrains.annotations.Nullable
    java.util.List<com.devbeans.io.chat.models.Contact> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.devbeans.io.chat.models.Contact> getSelectedGroupMembers() {
        return null;
    }
    
    public final void setSelectedGroupMembers(@org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.models.Contact> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.activity.result.ActivityResultLauncher<android.content.Intent> getDisappearActivityResultLauncher() {
        return null;
    }
    
    public final void setDisappearActivityResultLauncher(@org.jetbrains.annotations.Nullable
    androidx.activity.result.ActivityResultLauncher<android.content.Intent> p0) {
    }
    
    /**
     * This method initializes the view components and sets up necessary configurations for the activity.
     * It also registers an activity result launcher for fetching the disappearing time of a message.
     * @param savedInstanceState: A bundle object that contains the previously saved instance state.
     */
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Sets up data binding and view model for the activity.
     */
    private final void setupDataBindingAndViewModel() {
    }
    
    /**
     * Sets up UI components for the activity.
     */
    private final void setupUIComponents() {
    }
    
    /**
     * Sets up activity result launcher for fetching the disappearing time of a message.
     */
    private final void setupActivityResultLauncher() {
    }
    
    /**
     * Sets up application context and notifications.
     */
    private final void setupAppContextAndNotifications() {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void initDialog() {
    }
    
    private final void observers() {
    }
    
    private final void listeners() {
    }
    
    private final void handleConfirmCreateClick() {
    }
    
    private final void handleBtnCreateGroupClick() {
    }
    
    private final void setSearchContacts() {
    }
    
    /**
     * This function filters contacts based on the provided text.
     * It populates a list with contacts whose names contain the provided text.
     * @param text: The text to filter contacts by.
     */
    private final void filter(java.lang.String text) {
    }
    
    /**
     * This function updates the UI based on the selected group members.
     */
    private final void updateGroupUI() {
    }
    
    private final void setToolBar(androidx.appcompat.widget.Toolbar toolbar) {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    protected final void showLoadingDialog() {
    }
    
    private final void populateRecyclerView(boolean isGroup) {
    }
    
    private final void populateRecyclerViewGroup(boolean isGroup) {
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    private final void moveAssetsToInternal() {
    }
    
    @java.lang.Override
    public void onContactClick(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Contact contact, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.adapters.viewholders.ContactViewHolder viewHolder, int position) {
    }
    
    @java.lang.Override
    public void onCheckBoxClick(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Contact contact, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.adapters.viewholders.ContactViewHolder viewHolder, int position, boolean isFromGroupAdapter, boolean isChecked) {
    }
    
    @java.lang.Override
    public void onMemberAddClick(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Contact contact, @org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position, boolean isFromMember, boolean isChecked) {
    }
    
    private final com.devbeans.io.chat.models.Conversation checkConversation(com.devbeans.io.chat.models.Contact contact) {
        return null;
    }
    
    private final void verifyUser(java.lang.String userId) {
    }
    
    @java.lang.Override
    public void onSuccess(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    retrofit2.Response<?> response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    private final void handleAddContact(com.devbeans.io.chat.network.serializers.response.BaseResponse res) {
    }
    
    @java.lang.Override
    public void onFailure(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.network.serializers.response.BaseResponse response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    @java.lang.Override
    public void notifyExpiry() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a8\u0006\n"}, d2 = {"Lcom/devbeans/io/chat/activities/NewMessageActivity$Companion;", "", "()V", "containMember", "", "list", "", "Lcom/devbeans/io/chat/models/Contact;", "userid", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean containMember(@org.jetbrains.annotations.NotNull
        java.util.List<com.devbeans.io.chat.models.Contact> list, @org.jetbrains.annotations.Nullable
        java.lang.String userid) {
            return false;
        }
    }
}