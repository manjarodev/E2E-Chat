package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010/\u001a\u00020\u001bH\u0002J\b\u00100\u001a\u00020\u001bH\u0002J\b\u00101\u001a\u00020\u001bH\u0002J\u0010\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020+H\u0002J\u0012\u00104\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\b\u00107\u001a\u00020\u001bH\u0002J\b\u00108\u001a\u00020\u001bH\u0016J\"\u00109\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010>H\u0014J\u0012\u0010?\u001a\u00020\u001b2\b\u0010@\u001a\u0004\u0018\u00010AH\u0014J&\u0010B\u001a\u00020\u001b2\f\u0010C\u001a\b\u0012\u0002\b\u0003\u0018\u00010D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020\u00062\u0006\u0010J\u001a\u00020KH\u0017J\b\u0010L\u001a\u00020\u001bH\u0014J*\u0010M\u001a\u00020\u001b2\f\u0010C\u001a\b\u0012\u0002\b\u0003\u0018\u00010D2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030N2\u0006\u0010G\u001a\u00020HH\u0016J\u0010\u0010O\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020\u001bH\u0002J\b\u0010S\u001a\u00020\u001bH\u0002J\b\u0010T\u001a\u00020\u001bH\u0002J\b\u0010U\u001a\u00020\u001bH\u0002J\b\u0010V\u001a\u00020\u001bH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010\u0013\u00a8\u0006W"}, d2 = {"Lcom/devbeans/io/chat/activities/DetailsEditActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Lcom/devbeans/io/chat/network/OnNetworkResponse;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "BINDING_NOT_NULL", "", "getBINDING_NOT_NULL", "()Z", "setBINDING_NOT_NULL", "(Z)V", "_descriptionChange", "get_descriptionChange", "set_descriptionChange", "_extension", "", "get_extension", "()Ljava/lang/String;", "set_extension", "(Ljava/lang/String;)V", "_nameChanged", "get_nameChanged", "set_nameChanged", "_profileChange", "get_profileChange", "set_profileChange", "intentData", "", "getIntentData", "()Lkotlin/Unit;", "mBinding", "Lcom/devbeans/io/chat/databinding/ActivityDetailsEditBinding;", "getMBinding", "()Lcom/devbeans/io/chat/databinding/ActivityDetailsEditBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/ActivityDetailsEditBinding;)V", "mConversation", "Lcom/devbeans/io/chat/models/Conversation;", "getMConversation", "()Lcom/devbeans/io/chat/models/Conversation;", "setMConversation", "(Lcom/devbeans/io/chat/models/Conversation;)V", "mFile", "Ljava/io/File;", "mFileName", "getMFileName", "setMFileName", "checkChatDescriptionChange", "checkChatNameChange", "checkProfileChange", "handleFileToUpload", "file", "handleGroupIconResponse", "res", "Lcom/devbeans/io/chat/network/serializers/response/GetUpdateConversationImageResponse;", "initViews", "notifyExpiry", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFailure", "call", "Lretrofit2/Call;", "response", "Lcom/devbeans/io/chat/network/serializers/response/BaseResponse;", "tag", "", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "onSuccess", "Lretrofit2/Response;", "setToolBar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "setupListeners", "updateGroupDescription", "updateGroupInfo", "updateGroupName", "updateGroupProfile", "app_debug"})
public final class DetailsEditActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements com.devbeans.io.chat.network.OnNetworkResponse, com.devbeans.io.chat.callBacks.ExpiryCallback {
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.databinding.ActivityDetailsEditBinding mBinding;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Conversation mConversation;
    private boolean BINDING_NOT_NULL = false;
    private boolean _nameChanged = false;
    private boolean _descriptionChange = false;
    private boolean _profileChange = false;
    private java.io.File mFile;
    @org.jetbrains.annotations.Nullable
    private java.lang.String _extension;
    @org.jetbrains.annotations.Nullable
    private java.lang.String mFileName;
    
    public DetailsEditActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.databinding.ActivityDetailsEditBinding getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.databinding.ActivityDetailsEditBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Conversation getMConversation() {
        return null;
    }
    
    public final void setMConversation(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Conversation p0) {
    }
    
    public final boolean getBINDING_NOT_NULL() {
        return false;
    }
    
    public final void setBINDING_NOT_NULL(boolean p0) {
    }
    
    public final boolean get_nameChanged() {
        return false;
    }
    
    public final void set_nameChanged(boolean p0) {
    }
    
    public final boolean get_descriptionChange() {
        return false;
    }
    
    public final void set_descriptionChange(boolean p0) {
    }
    
    public final boolean get_profileChange() {
        return false;
    }
    
    public final void set_profileChange(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String get_extension() {
        return null;
    }
    
    public final void set_extension(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMFileName() {
        return null;
    }
    
    public final void setMFileName(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * This method sets up listeners for the view elements.
     */
    private final void setupListeners() {
    }
    
    /**
     * Checks if the chat name has changed and sets _nameChanged accordingly.
     */
    private final void checkChatNameChange() {
    }
    
    /**
     * Checks if the chat description has changed and sets _descriptionChange accordingly.
     */
    private final void checkChatDescriptionChange() {
    }
    
    /**
     * Checks if the profile picture has changed and sets _profileChange accordingly.
     */
    private final void checkProfileChange() {
    }
    
    private final void updateGroupInfo() {
    }
    
    private final void updateGroupProfile() {
    }
    
    private final void updateGroupDescription() {
    }
    
    private final void updateGroupName() {
    }
    
    /**
     * Initializes the view elements with data from the conversation.
     */
    private final void initViews() {
    }
    
    private final kotlin.Unit getIntentData() {
        return null;
    }
    
    @java.lang.Override
    protected void onResume() {
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
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    private final void handleFileToUpload(java.io.File file) {
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.text.ParseException.class})
    @java.lang.Override
    public void onSuccess(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    retrofit2.Response<?> response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    private final void handleGroupIconResponse(com.devbeans.io.chat.network.serializers.response.GetUpdateConversationImageResponse res) {
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