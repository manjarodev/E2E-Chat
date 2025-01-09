package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 M2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001MB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010%\u001a\u00020\u000fH\u0002J\b\u0010&\u001a\u00020\u000fH\u0002J\u0012\u0010\'\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010(\u001a\u00020\f2\u0006\u0010$\u001a\u00020\nH\u0002J\b\u0010)\u001a\u00020\fH\u0002J\b\u0010*\u001a\u00020\u000fH\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u000fH\u0002J\b\u00102\u001a\u00020\u000fH\u0002J\b\u00103\u001a\u00020\u000fH\u0002J\b\u00104\u001a\u00020\u000fH\u0002J\b\u00105\u001a\u00020\u000fH\u0002J\b\u00106\u001a\u00020\u000fH\u0002J\b\u00107\u001a\u00020\u000fH\u0016J\u0012\u00108\u001a\u00020\u000f2\b\u00109\u001a\u0004\u0018\u00010:H\u0014J&\u0010;\u001a\u00020\u000f2\f\u0010<\u001a\b\u0012\u0002\b\u0003\u0018\u00010=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020\u000fH\u0014J*\u0010C\u001a\u00020\u000f2\f\u0010<\u001a\b\u0012\u0002\b\u0003\u0018\u00010=2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030D2\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010E\u001a\u00020\u000fH\u0002J\b\u0010F\u001a\u00020\u000fH\u0002J\b\u0010G\u001a\u00020\u000fH\u0002J\b\u0010H\u001a\u00020\u000fH\u0002J\u0010\u0010I\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020-H\u0002J\b\u0010K\u001a\u00020\u000fH\u0002J\b\u0010L\u001a\u00020\u000fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006N"}, d2 = {"Lcom/devbeans/io/chat/activities/RemoveViewActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Lcom/devbeans/io/chat/network/OnNetworkResponse;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "apkFile", "Ljava/io/File;", "con", "Lcom/devbeans/io/chat/models/Conversation;", "con_id", "", "contactAdded", "", "currConNotNull", "dataFromDB", "", "getDataFromDB", "()Lkotlin/Unit;", "intentData", "getIntentData", "isAdminOwner", "isBlocked", "isContact", "isConversationAvailable", "mBinding", "Lcom/devbeans/io/chat/databinding/ActivityRemoveViewBinding;", "mContact", "Lcom/devbeans/io/chat/models/Contact;", "mConversation", "mCreateDialog", "Landroidx/appcompat/app/AlertDialog;", "mFile", "mImageAdapter", "Lcom/devbeans/io/chat/adapters/ImageAdapter;", "member", "Lcom/devbeans/io/chat/models/ConversationMember;", "memberId", "blockUser", "changeOtherActivitiesData", "checkContact", "checkConversation", "checkIsMediaShared", "checkisBlocked", "getGroupConversation", "getVisibility", "", "handleAfterNickName", "mCreateDialogBinding", "Lcom/devbeans/io/chat/databinding/CustomDailogAddContactBinding;", "handleConversationAvailable", "handleConversationForContact", "handleConversationForUnknown", "initViews", "listeners", "moveOwnAssetsToInternal", "notifyExpiry", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFailure", "call", "Lretrofit2/Call;", "response", "Lcom/devbeans/io/chat/network/serializers/response/BaseResponse;", "tag", "", "onResume", "onSuccess", "Lretrofit2/Response;", "populateRecyclerView", "removeMember", "showAddContactDialog", "showChangeNickNameDialog", "showCustomDialog", "i", "showMedia", "unblock", "Companion", "app_debug"})
public final class RemoveViewActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements com.devbeans.io.chat.network.OnNetworkResponse, com.devbeans.io.chat.callBacks.ExpiryCallback {
    private com.devbeans.io.chat.databinding.ActivityRemoveViewBinding mBinding;
    private java.lang.String memberId;
    private java.lang.String con_id;
    private com.devbeans.io.chat.models.ConversationMember member;
    private boolean isContact = false;
    private boolean isConversationAvailable = false;
    private boolean currConNotNull = false;
    private boolean isAdminOwner = false;
    private boolean isBlocked = false;
    private boolean contactAdded = false;
    private com.devbeans.io.chat.models.Contact mContact;
    private com.devbeans.io.chat.models.Conversation mConversation;
    private com.devbeans.io.chat.models.Conversation con;
    private com.devbeans.io.chat.adapters.ImageAdapter mImageAdapter;
    private androidx.appcompat.app.AlertDialog mCreateDialog;
    private final java.io.File apkFile = null;
    private final java.io.File mFile = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.activities.RemoveViewActivity.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    public RemoveViewActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void listeners() {
    }
    
    private final void handleConversationForUnknown() {
    }
    
    private final void handleConversationForContact() {
    }
    
    private final void handleConversationAvailable() {
    }
    
    private final void moveOwnAssetsToInternal() {
    }
    
    private final void populateRecyclerView() {
    }
    
    private final kotlin.Unit getDataFromDB() {
        return null;
    }
    
    private final void checkisBlocked() {
    }
    
    private final void initViews() {
    }
    
    private final int getVisibility() {
        return 0;
    }
    
    private final kotlin.Unit getIntentData() {
        return null;
    }
    
    private final com.devbeans.io.chat.models.Conversation getGroupConversation(java.lang.String con_id) {
        return null;
    }
    
    private final boolean checkConversation(java.lang.String memberId) {
        return false;
    }
    
    private final boolean checkContact(java.lang.String memberId) {
        return false;
    }
    
    private final void showMedia() {
    }
    
    private final boolean checkIsMediaShared() {
        return false;
    }
    
    private final void showCustomDialog(int i) {
    }
    
    private final void showChangeNickNameDialog() {
    }
    
    private final void showAddContactDialog() {
    }
    
    /**
     * This function handles the event after nickname is set.
     * @param mCreateDialogBinding is the dialog binding used to fetch the name for the new contact.
     */
    private final void handleAfterNickName(com.devbeans.io.chat.databinding.CustomDailogAddContactBinding mCreateDialogBinding) {
    }
    
    private final void removeMember() {
    }
    
    private final void unblock() {
    }
    
    private final void blockUser() {
    }
    
    private final void changeOtherActivitiesData() {
    }
    
    /**
     * Handles the success response for different API requests.
     * @param call The original call.
     * @param response The successful response.
     * @param tag The tag identifying the type of the request.
     * @throws ParseException if there is an error parsing the response.
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
    public void notifyExpiry() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/devbeans/io/chat/activities/RemoveViewActivity$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final java.lang.String getTAG() {
            return null;
        }
    }
}