package com.devbeans.io.chat.utils.qr

import androidx.lifecycle.LifecycleOwner

/**
 * Common interface for interacting with QR scanning views.
 */
interface ScannerView {
  fun start(lifecycleOwner: LifecycleOwner)
}
