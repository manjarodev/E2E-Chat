package com.devbeans.io.chat.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u001a\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/devbeans/io/chat/fragments/ImportExportFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/devbeans/io/chat/utils/views/ImportExportDialog$ImportExportDialogListener;", "()V", "mBinding", "Lcom/devbeans/io/chat/databinding/FragmentImportExportBinding;", "token", "", "vaultActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "initViews", "", "listeners", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "bundle", "Landroid/os/Bundle;", "onImportExportOptionSelected", "isImport", "", "isInternal", "onViewCreated", "view", "savedInstanceState", "showImportExportDialog", "startVaultActivity", "app_debug"})
public final class ImportExportFragment extends androidx.fragment.app.Fragment implements com.devbeans.io.chat.utils.views.ImportExportDialog.ImportExportDialogListener {
    private final java.lang.String token = "com.example.myapplication.Testing.action";
    private com.devbeans.io.chat.databinding.FragmentImportExportBinding mBinding;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> vaultActivityLauncher;
    
    public ImportExportFragment() {
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
     * This method sets up the click listeners for the Import export.
     */
    private final void listeners() {
    }
    
    private final void startVaultActivity() {
    }
    
    @java.lang.Override
    public void onImportExportOptionSelected(boolean isImport, boolean isInternal) {
    }
    
    private final void showImportExportDialog(boolean isImport) {
    }
    
    /**
     * Initializes the Import export views with their corresponding values.
     */
    private final void initViews() {
    }
}