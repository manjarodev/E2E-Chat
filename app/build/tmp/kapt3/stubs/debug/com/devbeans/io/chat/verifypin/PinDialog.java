package com.devbeans.io.chat.verifypin;

import java.lang.System;

/**
 * Dialog used to inflate dialog screen on
 * @see [LogOutTimerUtil]
 * @see [BaseActivity.onPause] //if screen in locked
 * @see [com.devbeans.io.chat.fragments.HomeFragment] //lock is clicked and chat locked
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0014J\u0006\u0010\u001b\u001a\u00020\u0019J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0006\u0010\u001e\u001a\u00020\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086.\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/devbeans/io/chat/verifypin/PinDialog;", "", "()V", "buttonVerify", "Landroid/widget/LinearLayout;", "dialog", "Landroid/app/Dialog;", "editTexts", "", "Landroid/widget/EditText;", "getEditTexts", "()[Landroid/widget/EditText;", "setEditTexts", "([Landroid/widget/EditText;)V", "[Landroid/widget/EditText;", "pinView", "Lcom/chaos/view/PinView;", "tvAttempts", "Landroid/widget/TextView;", "clearText", "", "createPinDialog", "context", "Landroid/content/Context;", "from", "", "destroyDialog", "getPin", "performVerify", "setupEditTexts", "showError", "Companion", "PlayerAction", "app_debug"})
public final class PinDialog {
    private android.widget.LinearLayout buttonVerify;
    private android.widget.TextView tvAttempts;
    private com.chaos.view.PinView pinView;
    private android.app.Dialog dialog;
    public android.widget.EditText[] editTexts;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.verifypin.PinDialog.Companion Companion = null;
    private static final java.lang.String TAG = null;
    private static java.lang.Integer attempts;
    private static com.devbeans.io.chat.callBacks.ResetLogoutTimer resetLogoutTimer;
    private static final com.devbeans.io.chat.verifypin.PinDialog.PlayerAction playerAction = null;
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    private static final com.devbeans.io.chat.verifypin.PinDialog INSTANCE = null;
    
    public PinDialog() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.EditText[] getEditTexts() {
        return null;
    }
    
    public final void setEditTexts(@org.jetbrains.annotations.NotNull
    android.widget.EditText[] p0) {
    }
    
    /**
     * Create a Dialog upon with given context of Activity
     */
    public final void createPinDialog(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String from) {
    }
    
    private final void performVerify() {
    }
    
    public final void destroyDialog() {
    }
    
    private final void setupEditTexts(android.app.Dialog dialog) {
    }
    
    public final void clearText() {
    }
    
    public final void showError() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPin() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/verifypin/PinDialog$PlayerAction;", "", "pausePlayer", "", "isDialogVisible", "", "app_debug"})
    public static abstract interface PlayerAction {
        
        public abstract void pausePlayer(boolean isDialogVisible);
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0014\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/devbeans/io/chat/verifypin/PinDialog$Companion;", "", "()V", "INSTANCE", "Lcom/devbeans/io/chat/verifypin/PinDialog;", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "attempts", "", "Ljava/lang/Integer;", "playerAction", "Lcom/devbeans/io/chat/verifypin/PinDialog$PlayerAction;", "resetLogoutTimer", "Lcom/devbeans/io/chat/callBacks/ResetLogoutTimer;", "dialogINSTANCE", "setResetLogoutTimer", "", "with", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final java.lang.String getTAG() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.verifypin.PinDialog dialogINSTANCE() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.verifypin.PinDialog with() {
            return null;
        }
        
        public final void setResetLogoutTimer(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.callBacks.ResetLogoutTimer resetLogoutTimer) {
        }
    }
}