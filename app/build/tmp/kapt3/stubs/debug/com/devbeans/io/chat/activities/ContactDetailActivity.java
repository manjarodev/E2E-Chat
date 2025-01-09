package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001a\u001a\u00020\fH\u0002J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u001e\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0002J\b\u0010 \u001a\u00020\fH\u0002J\b\u0010!\u001a\u00020\fH\u0016J\u0012\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J&\u0010%\u001a\u00020\f2\f\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010\'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0017J\b\u00100\u001a\u00020\fH\u0014J*\u00101\u001a\u00020\f2\f\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010\'2\n\u0010(\u001a\u0006\u0012\u0002\b\u0003022\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00103\u001a\u00020\f2\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020\fH\u0002J\u0010\u00107\u001a\u00020\f2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020\fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/devbeans/io/chat/activities/ContactDetailActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Lcom/devbeans/io/chat/network/OnNetworkResponse;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "BLOCK", "", "DELETE", "UNBLOCK", "apkFile", "Ljava/io/File;", "contactDetails", "", "getContactDetails", "()Lkotlin/Unit;", "mBinding", "Lcom/devbeans/io/chat/databinding/ActivityContactDetailBinding;", "getMBinding", "()Lcom/devbeans/io/chat/databinding/ActivityContactDetailBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/ActivityContactDetailBinding;)V", "mContact", "Lcom/devbeans/io/chat/models/Contact;", "mCreateDialog", "Landroidx/appcompat/app/AlertDialog;", "mFile", "blockUser", "checkConversation", "Lcom/devbeans/io/chat/models/Conversation;", "contact", "initViews", "listeners", "moveAssetsToInternal", "notifyExpiry", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFailure", "call", "Lretrofit2/Call;", "response", "Lcom/devbeans/io/chat/network/serializers/response/BaseResponse;", "tag", "", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onResume", "onSuccess", "Lretrofit2/Response;", "setToolBar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "showChangeNickNameDialog", "showCustomDialog", "i", "", "unblock", "app_debug"})
public final class ContactDetailActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements com.devbeans.io.chat.network.OnNetworkResponse, com.devbeans.io.chat.callBacks.ExpiryCallback {
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.databinding.ActivityContactDetailBinding mBinding;
    private com.devbeans.io.chat.models.Contact mContact;
    private androidx.appcompat.app.AlertDialog mCreateDialog;
    private final java.lang.String UNBLOCK = "Unblock";
    private final java.lang.String BLOCK = "Block";
    private final java.lang.String DELETE = "Delete";
    private java.io.File apkFile;
    private java.io.File mFile;
    
    public ContactDetailActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.databinding.ActivityContactDetailBinding getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.databinding.ActivityContactDetailBinding p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    /**
     * This method is used to initialize views with contact data.
     * It handles null safety and possible exceptions in the process.
     */
    private final void initViews() {
    }
    
    private final void listeners() {
    }
    
    private final void moveAssetsToInternal() {
    }
    
    private final void showCustomDialog(int i) {
    }
    
    private final void unblock() {
    }
    
    private final void blockUser() {
    }
    
    private final void showChangeNickNameDialog() {
    }
    
    private final kotlin.Unit getContactDetails() {
        return null;
    }
    
    private final com.devbeans.io.chat.models.Conversation checkConversation(com.devbeans.io.chat.models.Contact contact) {
        return null;
    }
    
    private final void setToolBar(androidx.appcompat.widget.Toolbar toolbar) {
    }
    
    @androidx.annotation.MainThread
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
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
}