package com.devbeans.io.chat.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\"\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u0010H\u0016J\u0018\u0010-\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J-\u0010.\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00052\u000e\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u0016002\u0006\u00101\u001a\u000202H\u0016\u00a2\u0006\u0002\u00103J\u001a\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020%2\b\u00106\u001a\u0004\u0018\u00010+H\u0016J\b\u00107\u001a\u00020\u0010H\u0002J\b\u00108\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lcom/devbeans/io/chat/fragments/ImportListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/devbeans/io/chat/callBacks/OnImportFileSelected;", "()V", "MANAGE_DATA_PERMISSION_REQUEST_CODE", "", "adapter", "Lcom/devbeans/io/chat/adapters/ImportFileListAdapter;", "file", "Ljava/io/File;", "mBinding", "Lcom/devbeans/io/chat/databinding/ImportListFragmentBinding;", "notSelected", "", "position", "checkPermissionAndDelete", "", "checkReadExternalPermission", "getAllFiles", "getChatFiles", "", "pattern", "", "handlePermissionDenied", "handlePermissionPermanentlyDenied", "initViews", "initViewsDialog", "deleteDialogBinding", "Lcom/devbeans/io/chat/databinding/CustomDeleteMessageBinding;", "manageDataPermission", "navigateToImportFileFragment", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "bundle", "Landroid/os/Bundle;", "onDestroyView", "onFileSelected", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", "view", "savedInstanceState", "setListeners", "showDeleteFileDialog", "app_debug"})
public final class ImportListFragment extends androidx.fragment.app.Fragment implements com.devbeans.io.chat.callBacks.OnImportFileSelected {
    private int position = -1;
    private boolean notSelected = false;
    private com.devbeans.io.chat.databinding.ImportListFragmentBinding mBinding;
    private final com.devbeans.io.chat.adapters.ImportFileListAdapter adapter = null;
    private java.io.File file;
    private final int MANAGE_DATA_PERMISSION_REQUEST_CODE = 2296;
    
    public ImportListFragment() {
        super();
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
    
    /**
     * Requests the user's permission to access the app's data on external storage.
     * If the permission is already granted, checks for read external storage permission.
     * If the permission is not granted, starts the system settings activity to grant the permission.
     */
    private final void manageDataPermission() {
    }
    
    @java.lang.Override
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    /**
     * Returns a list of all files in the "Chat" folder of the downloads directory that match the given pattern.
     * The pattern should be a regular expression that matches the file names.
     * This function assumes that the "Chat" folder exists in the downloads directory.
     * If the folder does not exist, an empty list will be returned.
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.io.File> getChatFiles(@org.jetbrains.annotations.NotNull
    java.lang.String pattern) {
        return null;
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    /**
     * Initializes the views.
     */
    private final void initViews() {
    }
    
    /**
     * Sets the listeners.
     */
    private final void setListeners() {
    }
    
    private final void navigateToImportFileFragment() {
    }
    
    /**
     * Checks for permission and deletes the selected file.
     */
    private final void checkPermissionAndDelete() {
    }
    
    /**
     * Handles the permission denied.
     */
    private final void handlePermissionDenied() {
    }
    
    /**
     * Handles the permanently denied permission.
     */
    private final void handlePermissionPermanentlyDenied() {
    }
    
    /**
     * Checks for read external storage permission.
     */
    private final void checkReadExternalPermission() {
    }
    
    /**
     * This method is used for handling the events that are used in import/export
     */
    private final void showDeleteFileDialog() {
    }
    
    /**
     * Initializes the views of the custom delete message dialog.
     *
     * @param deleteDialogBinding the binding object for the dialog views
     */
    private final void initViewsDialog(com.devbeans.io.chat.databinding.CustomDeleteMessageBinding deleteDialogBinding) {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    /**
     * Retrieves all exported files and displays them in the RecyclerView.
     * Note: This method should be called after the RecyclerView adapter has been initialized.
     */
    private final void getAllFiles() {
    }
    
    /**
     * Called when a file is selected in the list.
     * Updates the selected file and position, and toggles the visibility of the selection view.
     *
     * @param file The selected file.
     * @param position The position of the selected file in the list.
     */
    @java.lang.Override
    public void onFileSelected(@org.jetbrains.annotations.NotNull
    java.io.File file, int position) {
    }
}