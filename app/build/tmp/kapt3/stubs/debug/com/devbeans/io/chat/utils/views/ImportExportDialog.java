package com.devbeans.io.chat.utils.views;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/devbeans/io/chat/utils/views/ImportExportDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "listener", "Lcom/devbeans/io/chat/utils/views/ImportExportDialog$ImportExportDialogListener;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ImportExportDialogListener", "app_debug"})
public final class ImportExportDialog extends androidx.fragment.app.DialogFragment {
    private com.devbeans.io.chat.utils.views.ImportExportDialog.ImportExportDialogListener listener;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.views.ImportExportDialog.Companion Companion = null;
    private static final java.lang.String DIALOG_TAG = "ImportExportDialog";
    private static final java.lang.String ARG_IS_IMPORT = "arg.is_import";
    
    public ImportExportDialog() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/devbeans/io/chat/utils/views/ImportExportDialog$ImportExportDialogListener;", "", "onImportExportOptionSelected", "", "isImport", "", "isInternal", "app_debug"})
    public static abstract interface ImportExportDialogListener {
        
        public abstract void onImportExportOptionSelected(boolean isImport, boolean isInternal);
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/devbeans/io/chat/utils/views/ImportExportDialog$Companion;", "", "()V", "ARG_IS_IMPORT", "", "DIALOG_TAG", "show", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "isImport", "", "listener", "Lcom/devbeans/io/chat/utils/views/ImportExportDialog$ImportExportDialogListener;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void show(@org.jetbrains.annotations.NotNull
        androidx.fragment.app.FragmentManager fragmentManager, boolean isImport, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.views.ImportExportDialog.ImportExportDialogListener listener) {
        }
    }
}