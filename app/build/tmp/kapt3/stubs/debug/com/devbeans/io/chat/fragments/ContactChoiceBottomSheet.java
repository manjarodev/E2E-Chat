package com.devbeans.io.chat.fragments;

import java.lang.System;

/**
 * A BottomSheetDialogFragment class responsible for presenting contact choices and handling user selection.
 *
 * @param viewModel The ContactChoiceViewModel used to handle contact selections.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020&H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/devbeans/io/chat/fragments/ContactChoiceBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "viewModel", "Lcom/devbeans/io/chat/viewmodels/ContactChoiceViewModel;", "(Lcom/devbeans/io/chat/viewmodels/ContactChoiceViewModel;)V", "binding", "Lcom/devbeans/io/chat/databinding/FragmentBottomSheetContactChoiceBinding;", "currentChoiceIndex", "", "listener", "Lcom/devbeans/io/chat/fragments/ContactChoiceBottomSheet$OnImportCompletedListener;", "totalChoices", "displayNextChoice", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", "view", "setOnImportCompletedListener", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "showChoicePair", "choicePair", "Lcom/devbeans/io/chat/models/ContactChoice;", "OnImportCompletedListener", "app_debug"})
public final class ContactChoiceBottomSheet extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    private final com.devbeans.io.chat.viewmodels.ContactChoiceViewModel viewModel = null;
    private com.devbeans.io.chat.databinding.FragmentBottomSheetContactChoiceBinding binding;
    private com.devbeans.io.chat.fragments.ContactChoiceBottomSheet.OnImportCompletedListener listener;
    private int currentChoiceIndex = 0;
    private int totalChoices = 0;
    
    public ContactChoiceBottomSheet(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.viewmodels.ContactChoiceViewModel viewModel) {
        super();
    }
    
    public final void setOnImportCompletedListener(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.fragments.ContactChoiceBottomSheet.OnImportCompletedListener listener) {
    }
    
    /**
     * Called to create the dialog displayed by this fragment.
     */
    @org.jetbrains.annotations.NotNull
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
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void show(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentManager manager, @org.jetbrains.annotations.Nullable
    java.lang.String tag) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    /**
     * Displays the next contact choice in the list.
     */
    private final void displayNextChoice() {
    }
    
    /**
     * Displays the given contact choice pair and sets up click listeners for user selection.
     *
     * @param choicePair The contact choice pair to display.
     */
    private final void showChoicePair(com.devbeans.io.chat.models.ContactChoice choicePair) {
    }
    
    /**
     * Used for events when bottom sheet is dismissed
     */
    @java.lang.Override
    public void onDismiss(@org.jetbrains.annotations.NotNull
    android.content.DialogInterface dialog) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/devbeans/io/chat/fragments/ContactChoiceBottomSheet$OnImportCompletedListener;", "", "onImportCompleted", "", "app_debug"})
    public static abstract interface OnImportCompletedListener {
        
        public abstract void onImportCompleted();
    }
}