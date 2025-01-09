package com.devbeans.io.chat.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001TB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0012\u0010\'\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010(H\u0002J\b\u0010)\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\b\u0010+\u001a\u00020\u001cH\u0003J\"\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u000204H\u0016J0\u00105\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0006H\u0016J\"\u0010;\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020.H\u0016J\u0012\u0010<\u001a\u00020\u001c2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J&\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010=\u001a\u0004\u0018\u00010>H\u0017J&\u0010E\u001a\u00020\u001c2\f\u0010F\u001a\b\u0012\u0002\b\u0003\u0018\u00010G2\u0006\u0010H\u001a\u00020(2\u0006\u0010I\u001a\u00020JH\u0016J*\u0010K\u001a\u00020\u001c2\f\u0010F\u001a\b\u0012\u0002\b\u0003\u0018\u00010G2\n\u0010H\u001a\u0006\u0012\u0002\b\u00030L2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010M\u001a\u00020\u001cH\u0002J\u0010\u0010N\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020\u001eH\u0002J\b\u0010P\u001a\u00020\u001cH\u0002J\b\u0010Q\u001a\u00020\u001cH\u0004J\u0010\u0010R\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\u001eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017\u00a8\u0006U"}, d2 = {"Lcom/devbeans/io/chat/fragments/ContactsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/devbeans/io/chat/network/OnNetworkResponse;", "Lcom/devbeans/io/chat/callBacks/ContactsCallback;", "()V", "addedByQr", "", "mAdapter", "Lcom/devbeans/io/chat/adapters/ContactFragmentAdapter;", "mAddContact", "Landroidx/appcompat/widget/AppCompatButton;", "mBinding", "Lcom/devbeans/io/chat/databinding/FragmentContactsBinding;", "mCancel", "mDialog", "Landroidx/appcompat/app/AlertDialog;", "mViewModel", "Lcom/devbeans/io/chat/viewmodels/ContactFragmentViewModel;", "nameEdit", "Lcom/google/android/material/textfield/TextInputEditText;", "getNameEdit", "()Lcom/google/android/material/textfield/TextInputEditText;", "setNameEdit", "(Lcom/google/android/material/textfield/TextInputEditText;)V", "userIdEdit", "getUserIdEdit", "setUserIdEdit", "filter", "", "text", "", "handleAndAddInDb", "user", "Lcom/devbeans/io/chat/models/User;", "contact", "Lcom/devbeans/io/chat/models/Contact;", "handleGetProfile", "res", "Lcom/devbeans/io/chat/network/serializers/response/GetProfileResponse;", "handleVerifyResponse", "Lcom/devbeans/io/chat/network/serializers/response/BaseResponse;", "initDialog", "listeners", "observers", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCheckBoxClick", "viewHolder", "Lcom/devbeans/io/chat/adapters/viewholders/ContactViewHolder;", "position", "isFromGroupAdapter", "isChecked", "onContactClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onFailure", "call", "Lretrofit2/Call;", "response", "tag", "", "onSuccess", "Lretrofit2/Response;", "populateRecyclerView", "profileData", "userChatId", "setSearchContacts", "showLoadingDialog", "verifyUser", "userId", "Companion", "app_debug"})
public final class ContactsFragment extends androidx.fragment.app.Fragment implements com.devbeans.io.chat.network.OnNetworkResponse, com.devbeans.io.chat.callBacks.ContactsCallback {
    private boolean addedByQr = false;
    private com.devbeans.io.chat.databinding.FragmentContactsBinding mBinding;
    private com.devbeans.io.chat.viewmodels.ContactFragmentViewModel mViewModel;
    private com.devbeans.io.chat.adapters.ContactFragmentAdapter mAdapter;
    @org.jetbrains.annotations.Nullable
    private com.google.android.material.textfield.TextInputEditText userIdEdit;
    @org.jetbrains.annotations.Nullable
    private com.google.android.material.textfield.TextInputEditText nameEdit;
    private final androidx.appcompat.widget.AppCompatButton mCancel = null;
    private final androidx.appcompat.widget.AppCompatButton mAddContact = null;
    private androidx.appcompat.app.AlertDialog mDialog;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.fragments.ContactsFragment.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    public ContactsFragment() {
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
    
    /**
     * Initializes a custom dialog for adding a new contact.
     * The dialog contains input fields for the user id and name, and options to cancel,
     * add contact, and scan QR code.
     * It also includes error checks to prevent adding an empty or self user id.
     */
    private final void initDialog() {
    }
    
    protected final void showLoadingDialog() {
    }
    
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.N)
    private final void observers() {
    }
    
    private final void populateRecyclerView() {
    }
    
    @java.lang.Override
    public void onContactClick(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Contact contact, @org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.adapters.viewholders.ContactViewHolder viewHolder, int position) {
    }
    
    @java.lang.Override
    public void onCheckBoxClick(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Contact contact, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.adapters.viewholders.ContactViewHolder viewHolder, int position, boolean isFromGroupAdapter, boolean isChecked) {
    }
    
    private final void setSearchContacts() {
    }
    
    private final void filter(java.lang.String text) {
    }
    
    @java.lang.Override
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    private final void verifyUser(java.lang.String userId) {
    }
    
    private final void profileData(java.lang.String userChatId) {
    }
    
    @java.lang.Override
    public void onSuccess(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    retrofit2.Response<?> response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    private final void handleGetProfile(com.devbeans.io.chat.network.serializers.response.GetProfileResponse res) {
    }
    
    private final void handleAndAddInDb(com.devbeans.io.chat.models.User user, com.devbeans.io.chat.models.Contact contact) {
    }
    
    private final void handleVerifyResponse(com.devbeans.io.chat.network.serializers.response.BaseResponse res) {
    }
    
    @java.lang.Override
    public void onFailure(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.network.serializers.response.BaseResponse response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tR\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/devbeans/io/chat/fragments/ContactsFragment$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/devbeans/io/chat/fragments/ContactsFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final java.lang.String getTAG() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.fragments.ContactsFragment newInstance() {
            return null;
        }
    }
}