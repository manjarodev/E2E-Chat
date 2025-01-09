package com.devbeans.io.chat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/devbeans/io/chat/utils/BottomSheetUtil;", "", "()V", "STANDARD_BOTTOM_SHEET_FRAGMENT_TAG", "", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "dialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "app_debug"})
public final class BottomSheetUtil {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.BottomSheetUtil INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String STANDARD_BOTTOM_SHEET_FRAGMENT_TAG = "BOTTOM";
    
    private BottomSheetUtil() {
        super();
    }
    
    /**
     * Show preventing a possible IllegalStateException.
     */
    @kotlin.jvm.JvmStatic
    public static final void show(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentManager manager, @org.jetbrains.annotations.Nullable
    java.lang.String tag, @org.jetbrains.annotations.NotNull
    com.google.android.material.bottomsheet.BottomSheetDialogFragment dialog) {
    }
}