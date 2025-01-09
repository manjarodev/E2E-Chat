package com.devbeans.io.chat.utils.components;

import java.lang.System;

/**
 * Convenience class for wrapping Fragments in full-screen dialogs. Due to how fragments work, they
 * must be public static classes. Therefore, this class should be subclassed as its own entity, rather
 * than via `object : WrapperDialogFragment`.
 *
 * Example usage:
 *
 * ```
 * class Dialog : WrapperDialogFragment() {
 *  override fun getWrappedFragment(): Fragment {
 *    return NavHostFragment.create(R.navigation.private_story_settings, requireArguments())
 *  }
 * }
 *
 * companion object {
 *  fun createAsDialog(distributionListId: DistributionListId): DialogFragment {
 *    return Dialog().apply {
 *      arguments = PrivateStorySettingsFragmentArgs.Builder(distributionListId).build().toBundle()
 *    }
 *  }
 * }
 * ```
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/devbeans/io/chat/utils/components/WrapperDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "getWrappedFragment", "Landroidx/fragment/app/Fragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onHandleBackPressed", "onViewCreated", "view", "Landroid/view/View;", "WrapperDialogFragmentCallback", "app_debug"})
public abstract class WrapperDialogFragment extends androidx.fragment.app.DialogFragment {
    
    public WrapperDialogFragment() {
        super();
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public void onHandleBackPressed() {
    }
    
    @java.lang.Override
    public void onDismiss(@org.jetbrains.annotations.NotNull
    android.content.DialogInterface dialog) {
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract androidx.fragment.app.Fragment getWrappedFragment();
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/devbeans/io/chat/utils/components/WrapperDialogFragment$WrapperDialogFragmentCallback;", "", "onWrapperDialogFragmentDismissed", "", "app_debug"})
    public static abstract interface WrapperDialogFragmentCallback {
        
        public abstract void onWrapperDialogFragmentDismissed();
    }
}