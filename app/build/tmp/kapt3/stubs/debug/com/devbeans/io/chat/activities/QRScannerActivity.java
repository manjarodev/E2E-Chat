package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u0000 *2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002)*B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0018H\u0014J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J+\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060#2\u0006\u0010$\u001a\u00020%H\u0016\u00a2\u0006\u0002\u0010&J\b\u0010\'\u001a\u00020\u0018H\u0014J\b\u0010(\u001a\u00020\u0018H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/devbeans/io/chat/activities/QRScannerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/devbeans/io/chat/utils/qr/kitkat/ScanListener;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "CAMERA", "", "getCAMERA", "()Ljava/lang/String;", "binding", "Lcom/devbeans/io/chat/databinding/ActivityQrscannerBinding;", "getBinding", "()Lcom/devbeans/io/chat/databinding/ActivityQrscannerBinding;", "setBinding", "(Lcom/devbeans/io/chat/databinding/ActivityQrscannerBinding;)V", "generatedDeviceId", "getGeneratedDeviceId", "setGeneratedDeviceId", "(Ljava/lang/String;)V", "mCodeScanner", "Lcom/budiyev/android/codescanner/CodeScanner;", "scanFragment", "Lcom/devbeans/io/chat/verify/VerifyScanFragment;", "notifyExpiry", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onQrDataFound", "data", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "setScanner", "Callback", "Companion", "app_debug"})
public final class QRScannerActivity extends androidx.appcompat.app.AppCompatActivity implements com.devbeans.io.chat.utils.qr.kitkat.ScanListener, com.devbeans.io.chat.callBacks.ExpiryCallback {
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.databinding.ActivityQrscannerBinding binding;
    @org.jetbrains.annotations.Nullable
    private java.lang.String generatedDeviceId;
    private com.budiyev.android.codescanner.CodeScanner mCodeScanner;
    private final com.devbeans.io.chat.verify.VerifyScanFragment scanFragment = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String CAMERA = "android.permission-group.CAMERA";
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.activities.QRScannerActivity.Companion Companion = null;
    private static final java.lang.String VERIFIED_EXTRA = "verified_state";
    
    public QRScannerActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.databinding.ActivityQrscannerBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.databinding.ActivityQrscannerBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getGeneratedDeviceId() {
        return null;
    }
    
    public final void setGeneratedDeviceId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCAMERA() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setScanner() {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    @java.lang.Override
    public void onQrDataFound(@org.jetbrains.annotations.NotNull
    java.lang.String data) {
    }
    
    @java.lang.Override
    public void notifyExpiry() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/devbeans/io/chat/activities/QRScannerActivity$Callback;", "", "onQrCodeContainerClicked", "", "app_debug"})
    public static abstract interface Callback {
        
        public abstract void onQrCodeContainerClicked();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/devbeans/io/chat/activities/QRScannerActivity$Companion;", "", "()V", "VERIFIED_EXTRA", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}