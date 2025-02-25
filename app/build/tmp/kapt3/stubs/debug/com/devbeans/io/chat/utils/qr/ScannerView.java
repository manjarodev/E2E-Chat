package com.devbeans.io.chat.utils.qr;

import java.lang.System;

/**
 * Common interface for interacting with QR scanning views.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/devbeans/io/chat/utils/qr/ScannerView;", "", "start", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "app_debug"})
public abstract interface ScannerView {
    
    public abstract void start(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LifecycleOwner lifecycleOwner);
}