package com.devbeans.io.chat.verifypin;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001(B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\nH\u0003J\b\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\u0012\u0010\u0019\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\fH\u0014J\b\u0010\u001d\u001a\u00020\fH\u0015J\b\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0014J\b\u0010 \u001a\u00020\fH\u0014J\b\u0010!\u001a\u00020\fH\u0014J\b\u0010\"\u001a\u00020\fH\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\nH\u0017J$\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\'\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0017R\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/devbeans/io/chat/verifypin/LogOutTimerUtil$LogOutListener;", "Lcom/devbeans/io/chat/callBacks/ResetLogoutTimer;", "()V", "dynamicTheme", "Lcom/devbeans/io/chat/utils/DynamicTheme;", "getDynamicTheme", "()Lcom/devbeans/io/chat/utils/DynamicTheme;", "isScreenOn", "", "doLogout", "", "handleBackground", "zis", "Ljava/util/zip/ZipInputStream;", "unziped", "", "targetDirectory", "Ljava/io/File;", "handleClipBoard", "hasFocus", "handleCopyFocus", "handleCutFocus", "moveAssetsToInternal", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResetTimer", "onResume", "onStart", "onStop", "onUserInteraction", "onWindowFocusChanged", "unzipFonts", "context", "Landroid/content/Context;", "zipFile", "Companion", "app_debug"})
public class BaseActivity extends androidx.appcompat.app.AppCompatActivity implements com.devbeans.io.chat.verifypin.LogOutTimerUtil.LogOutListener, com.devbeans.io.chat.callBacks.ResetLogoutTimer {
    private boolean isScreenOn = false;
    @org.jetbrains.annotations.NotNull
    private final com.devbeans.io.chat.utils.DynamicTheme dynamicTheme = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.verifypin.BaseActivity.Companion Companion = null;
    private static final java.lang.String TAG = null;
    
    public BaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    protected final com.devbeans.io.chat.utils.DynamicTheme getDynamicTheme() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.DelicateCoroutinesApi.class})
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void moveAssetsToInternal() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.P)
    @java.lang.Override
    public void onWindowFocusChanged(boolean hasFocus) {
    }
    
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    public boolean unzipFonts(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.io.File zipFile, @org.jetbrains.annotations.Nullable
    java.io.File targetDirectory) throws java.io.IOException {
        return false;
    }
    
    private final void handleBackground(java.util.zip.ZipInputStream zis, boolean[] unziped, java.io.File targetDirectory) {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.P)
    private final void handleClipBoard(boolean hasFocus) {
    }
    
    private final void handleCutFocus() {
    }
    
    private final void handleCopyFocus() {
    }
    
    @java.lang.Override
    public void onUserInteraction() {
    }
    
    @android.annotation.SuppressLint(value = {"ObsoleteSdkInt"})
    @java.lang.Override
    protected void onPause() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @java.lang.Override
    protected void onStop() {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    /**
     * Performing idle time logout
     */
    @java.lang.Override
    public void doLogout() {
    }
    
    @java.lang.Override
    public void onResetTimer() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/devbeans/io/chat/verifypin/BaseActivity$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final java.lang.String getTAG() {
            return null;
        }
    }
}