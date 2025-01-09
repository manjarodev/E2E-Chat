package com.devbeans.io.chat.camera;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/devbeans/io/chat/camera/MediaSelectionNavigator;", "", "toCamera", "", "toGallery", "(II)V", "goToCamera", "", "navController", "Landroidx/navigation/NavController;", "goToGallery", "goToReview", "Companion", "app_debug"})
public final class MediaSelectionNavigator {
    private final int toCamera = 0;
    private final int toGallery = 0;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.camera.MediaSelectionNavigator.Companion Companion = null;
    
    public MediaSelectionNavigator() {
        super();
    }
    
    public MediaSelectionNavigator(int toCamera, int toGallery) {
        super();
    }
    
    public final void goToReview(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController) {
    }
    
    public final void goToCamera(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController) {
    }
    
    public final void goToGallery(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u00a8\u0006\b"}, d2 = {"Lcom/devbeans/io/chat/camera/MediaSelectionNavigator$Companion;", "", "()V", "requestPermissionsForCamera", "", "Landroidx/fragment/app/Fragment;", "onGranted", "Lkotlin/Function0;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void requestPermissionsForCamera(@org.jetbrains.annotations.NotNull
        androidx.fragment.app.Fragment $this$requestPermissionsForCamera, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function0<kotlin.Unit> onGranted) {
        }
    }
}