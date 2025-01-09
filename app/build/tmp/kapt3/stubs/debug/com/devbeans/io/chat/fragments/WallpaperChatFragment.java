package com.devbeans.io.chat.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\"\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010\'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0019H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/devbeans/io/chat/fragments/WallpaperChatFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/devbeans/io/chat/callBacks/OnColorSelectCallback;", "Lcom/devbeans/io/chat/callBacks/OnWallpaperSelectCallback;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "adapter", "Lcom/devbeans/io/chat/adapters/ChatColorsAdapter;", "mBinding", "Lcom/devbeans/io/chat/databinding/FragmentChatWallpaperBinding;", "mViewModel", "Lcom/devbeans/io/chat/viewmodels/ChatSettingsViewModel;", "wallpaperAdapter", "Lcom/devbeans/io/chat/adapters/ChatWallpaperAdapter;", "handleWallpaper", "", "file", "Ljava/io/File;", "extension", "initViews", "listeners", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onColorSelected", "color", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "bundle", "Landroid/os/Bundle;", "onViewCreated", "view", "savedInstanceState", "onWallpaperSelected", "drawable", "app_debug"})
public final class WallpaperChatFragment extends androidx.fragment.app.Fragment implements com.devbeans.io.chat.callBacks.OnColorSelectCallback, com.devbeans.io.chat.callBacks.OnWallpaperSelectCallback {
    private com.devbeans.io.chat.databinding.FragmentChatWallpaperBinding mBinding;
    private com.devbeans.io.chat.adapters.ChatColorsAdapter adapter;
    private com.devbeans.io.chat.adapters.ChatWallpaperAdapter wallpaperAdapter;
    private com.devbeans.io.chat.viewmodels.ChatSettingsViewModel mViewModel;
    private final java.lang.String TAG = null;
    
    public WallpaperChatFragment() {
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
    
    private final void listeners() {
    }
    
    @java.lang.Override
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    private final void handleWallpaper(java.io.File file, java.lang.String extension) {
    }
    
    private final void initViews() {
    }
    
    @java.lang.Override
    public void onColorSelected(int color) {
    }
    
    @java.lang.Override
    public void onWallpaperSelected(int drawable) {
    }
}