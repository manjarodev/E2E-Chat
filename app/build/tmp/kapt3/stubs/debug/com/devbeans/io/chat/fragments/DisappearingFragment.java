package com.devbeans.io.chat.fragments;

import java.lang.System;

/**
 * Fragment for Disappearing options for updating conversation expiry time
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u001aH\u0002J\u0012\u0010+\u001a\u00020\u001a2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J&\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020\u001aH\u0016J&\u00106\u001a\u00020\u001a2\f\u00107\u001a\b\u0012\u0002\b\u0003\u0018\u0001082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016J*\u0010=\u001a\u00020\u001a2\f\u00107\u001a\b\u0012\u0002\b\u0003\u0018\u0001082\n\u00109\u001a\u0006\u0012\u0002\b\u00030>2\u0006\u0010;\u001a\u00020<H\u0016J\u001a\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020-2\b\u0010A\u001a\u0004\u0018\u000104H\u0016J\u0018\u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020)H\u0002J\u0010\u0010E\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020!H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006G"}, d2 = {"Lcom/devbeans/io/chat/fragments/DisappearingFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "Lcom/devbeans/io/chat/network/OnNetworkResponse;", "()V", "CommandReceiver", "Landroid/content/BroadcastReceiver;", "isFromCreateConversation", "", "()Z", "setFromCreateConversation", "(Z)V", "isFromGeneral", "mBinding", "Lcom/devbeans/io/chat/databinding/DisappearingFragmentBinding;", "getMBinding", "()Lcom/devbeans/io/chat/databinding/DisappearingFragmentBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/DisappearingFragmentBinding;)V", "mConversation", "Lcom/devbeans/io/chat/models/Conversation;", "getMConversation", "()Lcom/devbeans/io/chat/models/Conversation;", "setMConversation", "(Lcom/devbeans/io/chat/models/Conversation;)V", "changeUI", "", "selectedOption", "Landroid/widget/LinearLayout;", "tvOptionText", "Landroid/widget/TextView;", "getDisappearingOptions", "expiryTime", "", "getValues", "", "handleClick", "handleExpirySet", "timerUnit", "Lcom/devbeans/io/chat/activities/DisappearingMsgActivity$TimerUnit;", "message", "", "listeners", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "bundle", "Landroid/os/Bundle;", "onDestroyView", "onFailure", "call", "Lretrofit2/Call;", "response", "Lcom/devbeans/io/chat/network/serializers/response/BaseResponse;", "tag", "", "onSuccess", "Lretrofit2/Response;", "onViewCreated", "view", "savedInstanceState", "setExpiryTime", "i", "_unit", "updateExpiryTime", "timeInMillis", "app_debug"})
public final class DisappearingFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener, com.devbeans.io.chat.network.OnNetworkResponse {
    private boolean isFromGeneral = false;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.databinding.DisappearingFragmentBinding mBinding;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.models.Conversation mConversation;
    private boolean isFromCreateConversation = false;
    private final android.content.BroadcastReceiver CommandReceiver = null;
    
    public DisappearingFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.databinding.DisappearingFragmentBinding getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.databinding.DisappearingFragmentBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Conversation getMConversation() {
        return null;
    }
    
    public final void setMConversation(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.models.Conversation p0) {
    }
    
    public final boolean isFromCreateConversation() {
        return false;
    }
    
    public final void setFromCreateConversation(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup viewGroup, @org.jetbrains.annotations.Nullable
    android.os.Bundle bundle) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void handleExpirySet(com.devbeans.io.chat.activities.DisappearingMsgActivity.TimerUnit timerUnit, int message) {
    }
    
    private final void setExpiryTime(long i, int _unit) {
    }
    
    private final void updateExpiryTime(long timeInMillis) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    private final void listeners() {
    }
    
    public final void getDisappearingOptions(long expiryTime) {
    }
    
    private final java.lang.String getValues(long expiryTime) {
        return null;
    }
    
    private final void changeUI(android.widget.LinearLayout selectedOption, android.widget.TextView tvOptionText) {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.Nullable
    android.view.View v) {
    }
    
    private final void handleClick(long expiryTime) {
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
}