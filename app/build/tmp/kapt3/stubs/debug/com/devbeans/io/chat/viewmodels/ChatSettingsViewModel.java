package com.devbeans.io.chat.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u0016\u0010\u001c\u001a\u00020\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u001b\u0010\r\u001a\r\u0012\t\u0012\u00070\u000f\u00a2\u0006\u0002\b\u00100\u000eX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/devbeans/io/chat/viewmodels/ChatSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "chatColors", "", "Lcom/devbeans/io/chat/models/ChatColor;", "chatColorsLiveData", "Landroidx/lifecycle/MutableLiveData;", "getChatColorsLiveData", "()Landroidx/lifecycle/MutableLiveData;", "chatWallpaperLiveData", "Lcom/devbeans/io/chat/models/ChatWallpaper;", "getChatWallpaperLiveData", "mKeepChatOptions", "", "", "Llombok/NonNull;", "[Ljava/lang/String;", "settingsLiveData", "getSettingsLiveData", "threadId", "Lio/reactivex/rxjava3/subjects/BehaviorSubject;", "", "wallpapers", "initSettingsData", "", "setChatColorsLiveData", "setChatWallpapersLiveData", "setSettingsLiveData", "settingsList", "Companion", "Factory", "app_debug"})
public final class ChatSettingsViewModel extends androidx.lifecycle.ViewModel {
    private java.lang.String[] mKeepChatOptions;
    private final io.reactivex.rxjava3.subjects.BehaviorSubject<java.lang.Long> threadId = null;
    private final java.util.List<com.devbeans.io.chat.models.ChatColor> chatColors = null;
    private final java.util.List<com.devbeans.io.chat.models.ChatWallpaper> wallpapers = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> settingsLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.devbeans.io.chat.models.ChatColor>> chatColorsLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.devbeans.io.chat.models.ChatWallpaper>> chatWallpaperLiveData = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.viewmodels.ChatSettingsViewModel.Companion Companion = null;
    private static com.devbeans.io.chat.viewmodels.ChatSettingsViewModel instance;
    
    public ChatSettingsViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> getSettingsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.devbeans.io.chat.models.ChatColor>> getChatColorsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.devbeans.io.chat.models.ChatWallpaper>> getChatWallpaperLiveData() {
        return null;
    }
    
    private final void initSettingsData() {
    }
    
    private final void setChatWallpapersLiveData() {
    }
    
    private final void setChatColorsLiveData() {
    }
    
    private final void setSettingsLiveData(java.util.List<java.lang.String> settingsList) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0016\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/viewmodels/ChatSettingsViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "()V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
    public static final class Factory extends androidx.lifecycle.ViewModelProvider.NewInstanceFactory {
        
        public Factory() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull
        java.lang.Class<T> modelClass) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/devbeans/io/chat/viewmodels/ChatSettingsViewModel$Companion;", "", "()V", "instance", "Lcom/devbeans/io/chat/viewmodels/ChatSettingsViewModel;", "with", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.viewmodels.ChatSettingsViewModel with(@org.jetbrains.annotations.Nullable
        android.content.Context context) {
            return null;
        }
    }
}