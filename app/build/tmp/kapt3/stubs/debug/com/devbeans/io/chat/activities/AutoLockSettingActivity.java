package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0002\u0018\u0019B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\b\u0010\u0014\u001a\u00020\u000bH\u0014J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u001a"}, d2 = {"Lcom/devbeans/io/chat/activities/AutoLockSettingActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "mBinding", "Lcom/devbeans/io/chat/databinding/ActivityAutoLockSettingBinding;", "getMBinding", "()Lcom/devbeans/io/chat/databinding/ActivityAutoLockSettingBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/ActivityAutoLockSettingBinding;)V", "listeners", "", "notifyExpiry", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onResume", "setToolBar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "Companion", "OnBackPressed", "app_debug"})
public final class AutoLockSettingActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements com.devbeans.io.chat.callBacks.ExpiryCallback {
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.databinding.ActivityAutoLockSettingBinding mBinding;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.activities.AutoLockSettingActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static java.lang.String FROM_SETTINGS = "settings";
    
    public AutoLockSettingActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.databinding.ActivityAutoLockSettingBinding getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.databinding.ActivityAutoLockSettingBinding p0) {
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
    protected void onResume() {
    }
    
    private final void listeners() {
    }
    
    @java.lang.Override
    public void notifyExpiry() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/devbeans/io/chat/activities/AutoLockSettingActivity$OnBackPressed;", "Landroidx/activity/OnBackPressedCallback;", "(Lcom/devbeans/io/chat/activities/AutoLockSettingActivity;)V", "handleOnBackPressed", "", "app_debug"})
    final class OnBackPressed extends androidx.activity.OnBackPressedCallback {
        
        public OnBackPressed() {
            super(false);
        }
        
        @java.lang.Override
        public void handleOnBackPressed() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/activities/AutoLockSettingActivity$Companion;", "", "()V", "FROM_SETTINGS", "", "getFROM_SETTINGS", "()Ljava/lang/String;", "setFROM_SETTINGS", "(Ljava/lang/String;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getFROM_SETTINGS() {
            return null;
        }
        
        public final void setFROM_SETTINGS(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
    }
}