package com.devbeans.io.chat.fragments;

import java.lang.System;

/**
 * A Fragment class responsible for importing contacts and handling user choices.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\u001a\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006!"}, d2 = {"Lcom/devbeans/io/chat/fragments/ImportFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/devbeans/io/chat/fragments/ContactChoiceBottomSheet$OnImportCompletedListener;", "()V", "_binding", "Lcom/devbeans/io/chat/databinding/ImportFragmentBinding;", "binding", "getBinding", "()Lcom/devbeans/io/chat/databinding/ImportFragmentBinding;", "selectedFile", "Ljava/io/File;", "viewModel", "Lcom/devbeans/io/chat/viewmodels/ContactChoiceViewModel;", "getViewModel", "()Lcom/devbeans/io/chat/viewmodels/ContactChoiceViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "importContactsProgress", "", "initViews", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onImportCompleted", "onImportCompletedUi", "onViewCreated", "view", "app_debug"})
public final class ImportFragment extends androidx.fragment.app.Fragment implements com.devbeans.io.chat.fragments.ContactChoiceBottomSheet.OnImportCompletedListener {
    private java.io.File selectedFile;
    private com.devbeans.io.chat.databinding.ImportFragmentBinding _binding;
    private final kotlin.Lazy viewModel$delegate = null;
    
    public ImportFragment() {
        super();
    }
    
    private final com.devbeans.io.chat.databinding.ImportFragmentBinding getBinding() {
        return null;
    }
    
    private final com.devbeans.io.chat.viewmodels.ContactChoiceViewModel getViewModel() {
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
    public void onDestroyView() {
    }
    
    /**
     * Initializes the views and starts the import process.
     */
    private final void initViews() {
    }
    
    /**
     * Displays the progress of importing contacts.
     */
    private final void importContactsProgress() {
    }
    
    /**
     * Handles the completion of the import process.
     */
    private final void onImportCompletedUi() {
    }
    
    @java.lang.Override
    public void onImportCompleted() {
    }
}