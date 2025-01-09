package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\b\u0010\u0015\u001a\u00020\rH\u0014J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000bH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0019"}, d2 = {"Lcom/devbeans/io/chat/activities/PrivacyActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "mBinding", "Lcom/devbeans/io/chat/databinding/ActivityPrivacyBinding;", "getMBinding", "()Lcom/devbeans/io/chat/databinding/ActivityPrivacyBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/ActivityPrivacyBinding;)V", "getToolbar", "Landroidx/appcompat/widget/Toolbar;", "notifyExpiry", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onResume", "setToolBar", "toolbar", "OnBackPressed", "app_debug"})
public final class PrivacyActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements com.devbeans.io.chat.callBacks.ExpiryCallback {
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.databinding.ActivityPrivacyBinding mBinding;
    
    public PrivacyActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.databinding.ActivityPrivacyBinding getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.databinding.ActivityPrivacyBinding p0) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.appcompat.widget.Toolbar getToolbar() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
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
    public void notifyExpiry() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/devbeans/io/chat/activities/PrivacyActivity$OnBackPressed;", "Landroidx/activity/OnBackPressedCallback;", "(Lcom/devbeans/io/chat/activities/PrivacyActivity;)V", "handleOnBackPressed", "", "app_debug"})
    final class OnBackPressed extends androidx.activity.OnBackPressedCallback {
        
        public OnBackPressed() {
            super(false);
        }
        
        @java.lang.Override
        public void handleOnBackPressed() {
        }
    }
}