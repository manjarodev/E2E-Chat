package com.devbeans.io.chat.camera;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/devbeans/io/chat/camera/PicturePreviewActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "()V", "binding", "Lcom/devbeans/io/chat/databinding/ActivityPicturePreviewBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "persistentState", "Landroid/os/PersistableBundle;", "onDestroy", "Companion", "app_debug"})
public final class PicturePreviewActivity extends com.devbeans.io.chat.verifypin.BaseActivity {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.camera.PicturePreviewActivity.Companion Companion = null;
    @org.jetbrains.annotations.Nullable
    private static com.otaliastudios.cameraview.PictureResult pictureResult;
    private com.devbeans.io.chat.databinding.ActivityPicturePreviewBinding binding;
    
    public PicturePreviewActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState, @org.jetbrains.annotations.Nullable
    android.os.PersistableBundle persistentState) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/camera/PicturePreviewActivity$Companion;", "", "()V", "pictureResult", "Lcom/otaliastudios/cameraview/PictureResult;", "getPictureResult", "()Lcom/otaliastudios/cameraview/PictureResult;", "setPictureResult", "(Lcom/otaliastudios/cameraview/PictureResult;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.otaliastudios.cameraview.PictureResult getPictureResult() {
            return null;
        }
        
        public final void setPictureResult(@org.jetbrains.annotations.Nullable
        com.otaliastudios.cameraview.PictureResult p0) {
        }
    }
}