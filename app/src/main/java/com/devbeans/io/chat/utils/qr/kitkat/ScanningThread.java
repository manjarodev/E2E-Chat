package com.devbeans.io.chat.utils.qr.kitkat;

import androidx.annotation.NonNull;

import com.devbeans.io.chat.utils.logging.Log;
import com.devbeans.io.chat.utils.qr.QrProcessor;
import com.google.zxing.DecodeHintType;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;


public class ScanningThread extends Thread implements QrCameraView.PreviewCallback {

    private static final String TAG = Log.tag(ScanningThread.class);

    private final QrProcessor processor = new QrProcessor();
    private final AtomicReference<ScanListener> scanListener = new AtomicReference<>();
    private final Map<DecodeHintType, String> hints = new HashMap<>();

    private boolean scanning = true;
    private QrCameraView.PreviewFrame previewFrame;

    public void setCharacterSet(String characterSet) {
        hints.put(DecodeHintType.CHARACTER_SET, characterSet);
    }

    public void setScanListener(ScanListener scanListener) {
        this.scanListener.set(scanListener);
    }

    @Override
    public void onPreviewFrame(@NonNull QrCameraView.PreviewFrame previewFrame) {
        try {
            synchronized (this) {
                this.previewFrame = previewFrame;
                this.notify();
            }
        } catch (RuntimeException e) {
            Log.w(TAG, e);
        }
    }

    @Override
    public void run() {
        while (true) {
            QrCameraView.PreviewFrame ourFrame;

            synchronized (this) {
                while (scanning && previewFrame == null) {
                    waitFor();
                }

                if (!scanning) return;
                else ourFrame = previewFrame;

                previewFrame = null;
            }

            String data = processor.getScannedData(ourFrame.getData(), ourFrame.getWidth(), ourFrame.getHeight());
            ScanListener scanListener = this.scanListener.get();

            if (data != null && scanListener != null) {
                scanListener.onQrDataFound(data);
                return;
            }
        }
    }

    public void stopScanning() {
        synchronized (this) {
            scanning = false;
            notify();
        }
    }

    private void waitFor() {
        try {
            wait(0);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new AssertionError(ie);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
