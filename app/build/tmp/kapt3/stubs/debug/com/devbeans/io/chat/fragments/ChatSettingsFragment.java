package com.devbeans.io.chat.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001aH\u0002J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0018\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0016J\u0018\u0010,\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020.H\u0016J\u001a\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u00010+H\u0016J\u0010\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020.H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\r\u0012\t\u0012\u00070\u0005\u00a2\u0006\u0002\b\u00130\u0012X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u001b\u0010\u0015\u001a\r\u0012\t\u0012\u00070\u0005\u00a2\u0006\u0002\b\u00130\u0012X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u001b\u0010\u0016\u001a\r\u0012\t\u0012\u00070\u0005\u00a2\u0006\u0002\b\u00130\u0012X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/devbeans/io/chat/fragments/ChatSettingsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/devbeans/io/chat/callBacks/ChatSettingsCallback;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "adapter", "Lcom/devbeans/io/chat/adapters/DialogSettingsAdapter;", "fontEmojiSizeOption", "", "keepChatOption", "", "mBinding", "Lcom/devbeans/io/chat/databinding/FragmentChatSettingsBinding;", "mCreateDialog", "Landroidx/appcompat/app/AlertDialog;", "mEmojiSizeptions", "", "Llombok/NonNull;", "[Ljava/lang/String;", "mFontSizeOptions", "mKeepChatOptions", "mViewModel", "Lcom/devbeans/io/chat/viewmodels/ChatSettingsViewModel;", "handeShowImportExport", "", "handleOtherReceipts", "binding", "check", "", "initViews", "initViewsDialog", "deleteDialogBinding", "Lcom/devbeans/io/chat/databinding/CustomDeleteMessageBinding;", "listeners", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "bundle", "Landroid/os/Bundle;", "onSettingsClick", "position", "", "dataOff", "option", "onViewCreated", "view", "savedInstanceState", "showCustomDialog", "type", "app_debug"})
public final class ChatSettingsFragment extends androidx.fragment.app.Fragment implements com.devbeans.io.chat.callBacks.ChatSettingsCallback {
    private com.devbeans.io.chat.databinding.FragmentChatSettingsBinding mBinding;
    private com.devbeans.io.chat.viewmodels.ChatSettingsViewModel mViewModel;
    private com.devbeans.io.chat.adapters.DialogSettingsAdapter adapter;
    private java.lang.String[] mKeepChatOptions;
    private java.lang.String[] mFontSizeOptions;
    private java.lang.String[] mEmojiSizeptions;
    private java.util.List<java.lang.String> keepChatOption;
    private java.util.List<java.lang.String> fontEmojiSizeOption;
    private androidx.appcompat.app.AlertDialog mCreateDialog;
    private final java.lang.String TAG = null;
    
    public ChatSettingsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle bundle) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * This method sets up the click listeners for the chat settings options.
     */
    private final void listeners() {
    }
    
    /**
     * This method is used for handling the events that are used in import/export
     */
    private final void handeShowImportExport() {
    }
    
    /**
     * Initializes the views of the custom delete message dialog.
     *
     * @param deleteDialogBinding the binding object for the dialog views
     */
    private final void initViewsDialog(com.devbeans.io.chat.databinding.CustomDeleteMessageBinding deleteDialogBinding) {
    }
    
    /**
     * This method handles the visibility of read receipts options based on the value of check.
     * If check is true, it will fadeIn the read receipt options, otherwise it will fadeOut the options.
     *
     * @param binding the FragmentChatSettingsBinding object
     * @param check the boolean value which determines the visibility of read receipts options
     */
    private final void handleOtherReceipts(com.devbeans.io.chat.databinding.FragmentChatSettingsBinding binding, boolean check) {
    }
    
    /**
     * Shows a custom dialog based on the given type.
     *
     * @param type The type of dialog to show.
     */
    private final void showCustomDialog(int type) {
    }
    
    /**
     * Initializes the chat settings views with their corresponding values.
     */
    private final void initViews() {
    }
    
    @java.lang.Override
    public void onSettingsClick(@org.jetbrains.annotations.NotNull
    java.lang.String option, int dataOff) {
    }
    
    @java.lang.Override
    public void onSettingsClick(int position, int dataOff) {
    }
}