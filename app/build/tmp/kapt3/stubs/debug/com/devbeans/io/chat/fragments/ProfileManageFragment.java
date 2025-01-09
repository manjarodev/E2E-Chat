package com.devbeans.io.chat.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001SB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001eH\u0002J\u0012\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0002J\u0012\u0010(\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010)H\u0002J\b\u0010*\u001a\u00020 H\u0002J\b\u0010+\u001a\u00020 H\u0003J\"\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020 2\b\u00103\u001a\u0004\u0018\u000104H\u0016J&\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u00103\u001a\u0004\u0018\u000104H\u0016J&\u0010;\u001a\u00020 2\f\u0010<\u001a\b\u0012\u0002\b\u0003\u0018\u00010=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020 H\u0016J\u0010\u0010C\u001a\u00020 2\u0006\u0010D\u001a\u00020\u001cH\u0016J\u0010\u0010C\u001a\u00020 2\u0006\u0010E\u001a\u00020.H\u0016J\b\u0010F\u001a\u00020 H\u0016J*\u0010G\u001a\u00020 2\f\u0010<\u001a\b\u0012\u0002\b\u0003\u0018\u00010=2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030H2\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010I\u001a\u00020 H\u0002J\b\u0010J\u001a\u00020 H\u0002J\u0018\u0010K\u001a\u00020 2\u0006\u0010L\u001a\u00020M2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010N\u001a\u00020 2\u0006\u0010O\u001a\u00020#H\u0002J\u0010\u0010P\u001a\u00020 2\u0006\u0010Q\u001a\u00020\bH\u0002J\u0010\u0010R\u001a\u00020 2\u0006\u0010Q\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001b0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006T"}, d2 = {"Lcom/devbeans/io/chat/fragments/ProfileManageFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/devbeans/io/chat/network/OnNetworkResponse;", "Lcom/devbeans/io/chat/callBacks/OnSettingsClick;", "()V", "adapter", "Lcom/devbeans/io/chat/adapters/SettingsAdapter;", "img_file", "Ljava/io/File;", "mBinding", "Lcom/devbeans/io/chat/databinding/FragmentProfileManageBinding;", "getMBinding", "()Lcom/devbeans/io/chat/databinding/FragmentProfileManageBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/FragmentProfileManageBinding;)V", "mCreateDialog", "Landroidx/appcompat/app/AlertDialog;", "mCreateDialogBinding", "Lcom/devbeans/io/chat/databinding/CustomNicknameDailogBinding;", "mUser", "Lcom/devbeans/io/chat/models/User;", "mViewModel", "Lcom/devbeans/io/chat/viewmodels/SettingsViewModel;", "mutableLiveUser", "Landroidx/lifecycle/MutableLiveData;", "observer", "Landroidx/lifecycle/Observer;", "", "Lcom/devbeans/io/chat/models/SettingsModel;", "checkIsSocketConnected", "", "dummyInfo", "", "getProfileDataFromApi", "chatUserId", "", "fromUpdate", "handleGetProfile", "res", "Lcom/devbeans/io/chat/network/serializers/response/GetProfileResponse;", "handleUploadMediaResponse", "Lcom/devbeans/io/chat/network/serializers/response/UploadMediaResponse;", "listeners", "observers", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onFailure", "call", "Lretrofit2/Call;", "response", "Lcom/devbeans/io/chat/network/serializers/response/BaseResponse;", "tag", "", "onResume", "onSettingsClick", "settingsModel", "position", "onStop", "onSuccess", "Lretrofit2/Response;", "showChangeNickNameDialog", "showProfileData", "showQRDialog", "bitmap", "Landroid/graphics/Bitmap;", "updateNickName", "toString", "updateProfileImage", "file", "uploadFile", "Companion", "app_debug"})
public final class ProfileManageFragment extends androidx.fragment.app.Fragment implements com.devbeans.io.chat.network.OnNetworkResponse, com.devbeans.io.chat.callBacks.OnSettingsClick {
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.databinding.FragmentProfileManageBinding mBinding;
    private com.devbeans.io.chat.databinding.CustomNicknameDailogBinding mCreateDialogBinding;
    private androidx.appcompat.app.AlertDialog mCreateDialog;
    private com.devbeans.io.chat.models.User mUser;
    private final androidx.lifecycle.MutableLiveData<com.devbeans.io.chat.models.User> mutableLiveUser = null;
    private final java.io.File img_file = null;
    private com.devbeans.io.chat.viewmodels.SettingsViewModel mViewModel;
    private com.devbeans.io.chat.adapters.SettingsAdapter adapter;
    private final androidx.lifecycle.Observer<java.util.List<com.devbeans.io.chat.models.SettingsModel>> observer = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.fragments.ProfileManageFragment.Companion Companion = null;
    
    public ProfileManageFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.databinding.FragmentProfileManageBinding getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.databinding.FragmentProfileManageBinding p0) {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showProfileData() {
    }
    
    private final void getProfileDataFromApi(java.lang.String chatUserId, boolean fromUpdate) {
    }
    
    private final void updateProfileImage(java.io.File file) {
    }
    
    private final boolean checkIsSocketConnected() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    private final void observers() {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onStop() {
    }
    
    private final void dummyInfo() {
    }
    
    private final void listeners() {
    }
    
    @java.lang.Override
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    private final void uploadFile(java.io.File file) {
    }
    
    private final void showQRDialog(android.graphics.Bitmap bitmap, java.lang.String chatUserId) {
    }
    
    private final void showChangeNickNameDialog() {
    }
    
    private final void updateNickName(java.lang.String toString) {
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.text.ParseException.class})
    @java.lang.Override
    public void onSuccess(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    retrofit2.Response<?> response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    private final void handleUploadMediaResponse(com.devbeans.io.chat.network.serializers.response.UploadMediaResponse res) {
    }
    
    private final void handleGetProfile(com.devbeans.io.chat.network.serializers.response.GetProfileResponse res) {
    }
    
    @java.lang.Override
    public void onFailure(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.network.serializers.response.BaseResponse response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    @java.lang.Override
    public void onSettingsClick(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.SettingsModel settingsModel) {
    }
    
    @java.lang.Override
    public void onSettingsClick(int position) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/fragments/ProfileManageFragment$Companion;", "", "()V", "generateQrCode", "Landroid/graphics/Bitmap;", "myCodeText", "", "newInstance", "Lcom/devbeans/io/chat/fragments/ProfileManageFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.fragments.ProfileManageFragment newInstance() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @kotlin.jvm.Throws(exceptionClasses = {com.google.zxing.WriterException.class})
        public final android.graphics.Bitmap generateQrCode(@org.jetbrains.annotations.Nullable
        java.lang.String myCodeText) throws com.google.zxing.WriterException {
            return null;
        }
    }
}