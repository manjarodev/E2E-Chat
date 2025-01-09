package com.devbeans.io.chat.fragments;

import java.lang.System;

/**
 * Fullscreen Dialog Fragment which will dismiss itself when the keyboard is closed
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\bX\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001a"}, d2 = {"Lcom/devbeans/io/chat/fragments/KeyboardEntryDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/devbeans/io/chat/utils/views/KeyboardAwareLinearLayout$OnKeyboardShownListener;", "Lcom/devbeans/io/chat/utils/views/KeyboardAwareLinearLayout$OnKeyboardHiddenListener;", "contentLayoutId", "", "(I)V", "hasShown", "", "withDim", "getWithDim", "()Z", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onKeyboardHidden", "onKeyboardShown", "app_debug"})
public abstract class KeyboardEntryDialogFragment extends androidx.fragment.app.DialogFragment implements com.devbeans.io.chat.utils.views.KeyboardAwareLinearLayout.OnKeyboardShownListener, com.devbeans.io.chat.utils.views.KeyboardAwareLinearLayout.OnKeyboardHiddenListener {
    private boolean hasShown = false;
    private final boolean withDim = false;
    
    public KeyboardEntryDialogFragment(@androidx.annotation.LayoutRes
    int contentLayoutId) {
        super();
    }
    
    protected boolean getWithDim() {
        return false;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.Suppress(names = {"DEPRECATION"})
    @java.lang.Override
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onKeyboardShown() {
    }
    
    @java.lang.Override
    public void onKeyboardHidden() {
    }
}