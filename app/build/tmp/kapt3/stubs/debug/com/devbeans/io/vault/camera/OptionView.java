package com.devbeans.io.vault.camera;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004:\u0001)B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ0\u0010\u001c\u001a\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0016\u0010$\u001a\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001eH\u0016J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\'J\u001c\u0010(\u001a\u00020\u00172\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u00028\u0000X\u0082.\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0013X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/devbeans/io/vault/camera/OptionView;", "Value", "", "Landroid/widget/LinearLayout;", "Landroid/widget/AdapterView$OnItemSelectedListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "callback", "Lcom/devbeans/io/vault/camera/OptionView$Callback;", "option", "Lcom/devbeans/io/vault/camera/Option;", "spinner", "Landroid/widget/Spinner;", "getSpinner", "()Landroid/widget/Spinner;", "value", "Ljava/lang/Object;", "values", "", "valuesStrings", "", "onCameraOpened", "", "view", "Lcom/otaliastudios/cameraview/CameraView;", "options", "Lcom/otaliastudios/cameraview/CameraOptions;", "onItemSelected", "adapterView", "Landroid/widget/AdapterView;", "Landroid/view/View;", "i", "", "l", "", "onNothingSelected", "setHasDivider", "hasDivider", "", "setOption", "Callback", "app_debug"})
public final class OptionView<Value extends java.lang.Object> extends android.widget.LinearLayout implements android.widget.AdapterView.OnItemSelectedListener {
    private com.devbeans.io.vault.camera.Option<Value> option;
    private com.devbeans.io.vault.camera.OptionView.Callback callback;
    private Value value;
    private java.util.List<? extends Value> values;
    private java.util.List<java.lang.String> valuesStrings;
    @org.jetbrains.annotations.NotNull
    private final android.widget.Spinner spinner = null;
    
    public OptionView(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.Spinner getSpinner() {
        return null;
    }
    
    public final void setHasDivider(boolean hasDivider) {
    }
    
    public final void setOption(@org.jetbrains.annotations.NotNull
    com.devbeans.io.vault.camera.Option<Value> option, @org.jetbrains.annotations.NotNull
    com.devbeans.io.vault.camera.OptionView.Callback callback) {
    }
    
    public final void onCameraOpened(@org.jetbrains.annotations.NotNull
    com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
    com.otaliastudios.cameraview.CameraOptions options) {
    }
    
    @java.lang.Override
    public void onItemSelected(@org.jetbrains.annotations.Nullable
    android.widget.AdapterView<?> adapterView, @org.jetbrains.annotations.Nullable
    android.view.View view, int i, long l) {
    }
    
    @java.lang.Override
    public void onNothingSelected(@org.jetbrains.annotations.Nullable
    android.widget.AdapterView<?> adapterView) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\u0007\u001a\u0002H\u00042\u0006\u0010\b\u001a\u00020\tH&\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/devbeans/io/vault/camera/OptionView$Callback;", "", "onValueChanged", "", "T", "option", "Lcom/devbeans/io/vault/camera/Option;", "value", "name", "", "(Lcom/devbeans/io/vault/camera/Option;Ljava/lang/Object;Ljava/lang/String;)Z", "app_debug"})
    public static abstract interface Callback {
        
        public abstract <T extends java.lang.Object>boolean onValueChanged(@org.jetbrains.annotations.NotNull
        com.devbeans.io.vault.camera.Option<T> option, @org.jetbrains.annotations.NotNull
        T value, @org.jetbrains.annotations.NotNull
        java.lang.String name);
    }
}