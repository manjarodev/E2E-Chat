package com.devbeans.io.chat.fragments;

import java.lang.System;

/**
 * Dialog for selecting a custom expire timer value.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/devbeans/io/chat/fragments/CustomExpireTimerSelectDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "selector", "Lcom/devbeans/io/chat/utils/views/CustomExpireTimerSelectorView;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onStart", "requireConversationExpireTime", "", "sendCommand", "command", "", "Companion", "app_debug"})
public final class CustomExpireTimerSelectDialog extends androidx.fragment.app.DialogFragment {
    private com.devbeans.io.chat.utils.views.CustomExpireTimerSelectorView selector;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.fragments.CustomExpireTimerSelectDialog.Companion Companion = null;
    private static final java.lang.String DIALOG_TAG = "CustomTimerSelectDialog";
    private static final java.lang.String ARG_EXPIRE_TIME = "arg.expire.time";
    
    public CustomExpireTimerSelectDialog() {
        super();
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onDismiss(@org.jetbrains.annotations.NotNull
    android.content.DialogInterface dialog) {
    }
    
    private final void sendCommand(int command) {
    }
    
    @kotlin.Suppress(names = {"DEPRECATION"})
    @java.lang.Override
    public void onActivityCreated(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final long requireConversationExpireTime() {
        return 0L;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/devbeans/io/chat/fragments/CustomExpireTimerSelectDialog$Companion;", "", "()V", "ARG_EXPIRE_TIME", "", "DIALOG_TAG", "show", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "expiryTime", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void show(@org.jetbrains.annotations.NotNull
        androidx.fragment.app.FragmentManager fragmentManager, long expiryTime) {
        }
    }
}