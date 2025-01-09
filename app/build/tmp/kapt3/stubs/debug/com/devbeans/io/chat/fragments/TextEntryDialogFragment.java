package com.devbeans.io.chat.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/devbeans/io/chat/fragments/TextEntryDialogFragment;", "Lcom/devbeans/io/chat/fragments/KeyboardEntryDialogFragment;", "()V", "EMOJI_REGEX", "", "colorIndicatorAlphaAnimator", "Landroid/animation/Animator;", "controller", "Lcom/devbeans/io/chat/fragments/TextEntryDialogFragment$Controller;", "hiddenTextEntry", "Lcom/devbeans/io/chat/utils/views/HiddenEditText;", "onDismiss", "", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "Controller", "app_debug"})
public final class TextEntryDialogFragment extends com.devbeans.io.chat.fragments.KeyboardEntryDialogFragment {
    private com.devbeans.io.chat.utils.views.HiddenEditText hiddenTextEntry;
    private com.devbeans.io.chat.fragments.TextEntryDialogFragment.Controller controller;
    private final java.lang.String EMOJI_REGEX = "[^\\p{L}\\p{M}\\p{N}\\p{P}\\p{Z}\\p{Cf}\\p{Cs}\\s]";
    private android.animation.Animator colorIndicatorAlphaAnimator;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.fragments.TextEntryDialogFragment.Companion Companion = null;
    
    public TextEntryDialogFragment() {
        super(0);
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onDismiss(@org.jetbrains.annotations.NotNull
    android.content.DialogInterface dialog) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/devbeans/io/chat/fragments/TextEntryDialogFragment$Controller;", "", "onTextColorChange", "", "colorIndex", "", "onTextEntryDialogDismissed", "hasText", "", "zoomToFitText", "editorElement", "Lcom/devbeans/io/chat/utils/views/EditorElement;", "textRenderer", "Lcom/devbeans/io/chat/utils/editor/MultiLineTextRenderer;", "app_debug"})
    public static abstract interface Controller {
        
        public abstract void onTextEntryDialogDismissed(boolean hasText);
        
        public abstract void zoomToFitText(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.views.EditorElement editorElement, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.editor.MultiLineTextRenderer textRenderer);
        
        public abstract void onTextColorChange(int colorIndex);
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r\u00a8\u0006\u000e"}, d2 = {"Lcom/devbeans/io/chat/fragments/TextEntryDialogFragment$Companion;", "", "()V", "show", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "editorElement", "Lcom/devbeans/io/chat/utils/views/EditorElement;", "isIncognitoEnabled", "", "selectAll", "colorIndex", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void show(@org.jetbrains.annotations.NotNull
        androidx.fragment.app.FragmentManager fragmentManager, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.views.EditorElement editorElement, boolean isIncognitoEnabled, boolean selectAll, int colorIndex) {
        }
    }
}