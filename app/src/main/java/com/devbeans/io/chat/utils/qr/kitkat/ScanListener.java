package com.devbeans.io.chat.utils.qr.kitkat;

import androidx.annotation.NonNull;

public interface ScanListener {
  void onQrDataFound(@NonNull String data);
}
