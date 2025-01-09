package com.devbeans.io.vault.camera;

import java.lang.System;

/**
 * Controls that we want to display in a ControlView.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b#\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u001e\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&\'()*+,-./0123B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0015\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH&\u00a2\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0015R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u00064"}, d2 = {"Lcom/devbeans/io/vault/camera/Option;", "T", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "get", "view", "Lcom/otaliastudios/cameraview/CameraView;", "(Lcom/otaliastudios/cameraview/CameraView;)Ljava/lang/Object;", "getAll", "", "options", "Lcom/otaliastudios/cameraview/CameraOptions;", "set", "", "value", "(Lcom/otaliastudios/cameraview/CameraView;Ljava/lang/Object;)V", "toString", "(Ljava/lang/Object;)Ljava/lang/String;", "Audio", "AudioCodec", "Control", "Engine", "Flash", "FrameProcessingFormat", "Gesture", "Grid", "GridColor", "Hdr", "Height", "HorizontalScroll", "LongTap", "Mode", "Overlay", "OverlayInPictureSnapshot", "OverlayInPreview", "OverlayInVideoSnapshot", "PictureFormat", "PictureMetering", "PictureSnapshotMetering", "Pinch", "Preview", "PreviewFrameRate", "Tap", "UseDeviceOrientation", "VerticalScroll", "VideoCodec", "WhiteBalance", "Width", "app_debug"})
public abstract class Option<T extends java.lang.Object> {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    
    public Option(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract T get(@org.jetbrains.annotations.NotNull
    com.otaliastudios.cameraview.CameraView view);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.Collection<T> getAll(@org.jetbrains.annotations.NotNull
    com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
    com.otaliastudios.cameraview.CameraOptions options);
    
    public abstract void set(@org.jetbrains.annotations.NotNull
    com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
    T value);
    
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString(@org.jetbrains.annotations.NotNull
    T value) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$Width;", "Lcom/devbeans/io/vault/camera/Option;", "", "()V", "get", "view", "Lcom/otaliastudios/cameraview/CameraView;", "(Lcom/otaliastudios/cameraview/CameraView;)Ljava/lang/Integer;", "getAll", "", "options", "Lcom/otaliastudios/cameraview/CameraOptions;", "set", "", "value", "toString", "", "app_debug"})
    public static final class Width extends com.devbeans.io.vault.camera.Option<java.lang.Integer> {
        
        public Width() {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.Integer get(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view) {
            return null;
        }
        
        @java.lang.Override
        public void set(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, int value) {
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.util.Collection<java.lang.Integer> getAll(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraOptions options) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString(int value) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$Height;", "Lcom/devbeans/io/vault/camera/Option;", "", "()V", "get", "view", "Lcom/otaliastudios/cameraview/CameraView;", "(Lcom/otaliastudios/cameraview/CameraView;)Ljava/lang/Integer;", "getAll", "", "options", "Lcom/otaliastudios/cameraview/CameraOptions;", "set", "", "value", "toString", "", "app_debug"})
    public static final class Height extends com.devbeans.io.vault.camera.Option<java.lang.Integer> {
        
        public Height() {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.Integer get(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view) {
            return null;
        }
        
        @java.lang.Override
        public void set(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, int value) {
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.util.Collection<java.lang.Integer> getAll(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraOptions options) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString(int value) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ:\u0010\r\u001a$\u0012\f\u0012\n \u000f*\u0004\u0018\u00018\u00018\u0001 \u000f*\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00018\u00018\u00010\u00100\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$Control;", "T", "Lcom/otaliastudios/cameraview/controls/Control;", "Lcom/devbeans/io/vault/camera/Option;", "kclass", "Lkotlin/reflect/KClass;", "name", "", "(Lkotlin/reflect/KClass;Ljava/lang/String;)V", "get", "view", "Lcom/otaliastudios/cameraview/CameraView;", "(Lcom/otaliastudios/cameraview/CameraView;)Lcom/otaliastudios/cameraview/controls/Control;", "getAll", "", "kotlin.jvm.PlatformType", "", "options", "Lcom/otaliastudios/cameraview/CameraOptions;", "set", "", "value", "(Lcom/otaliastudios/cameraview/CameraView;Lcom/otaliastudios/cameraview/controls/Control;)V", "app_debug"})
    public static abstract class Control<T extends com.otaliastudios.cameraview.controls.Control> extends com.devbeans.io.vault.camera.Option<T> {
        private final kotlin.reflect.KClass<T> kclass = null;
        
        public Control(@org.jetbrains.annotations.NotNull
        kotlin.reflect.KClass<T> kclass, @org.jetbrains.annotations.NotNull
        java.lang.String name) {
            super(null);
        }
        
        @java.lang.Override
        public void set(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
        T value) {
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public T get(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.util.Collection<T> getAll(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraOptions options) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$Mode;", "Lcom/devbeans/io/vault/camera/Option$Control;", "Lcom/otaliastudios/cameraview/controls/Mode;", "()V", "app_debug"})
    public static final class Mode extends com.devbeans.io.vault.camera.Option.Control<com.otaliastudios.cameraview.controls.Mode> {
        
        public Mode() {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$Engine;", "Lcom/devbeans/io/vault/camera/Option$Control;", "Lcom/otaliastudios/cameraview/controls/Engine;", "()V", "set", "", "view", "Lcom/otaliastudios/cameraview/CameraView;", "value", "app_debug"})
    public static final class Engine extends com.devbeans.io.vault.camera.Option.Control<com.otaliastudios.cameraview.controls.Engine> {
        
        public Engine() {
            super(null, null);
        }
        
        @java.lang.Override
        public void set(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.controls.Engine value) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$Preview;", "Lcom/devbeans/io/vault/camera/Option$Control;", "Lcom/otaliastudios/cameraview/controls/Preview;", "()V", "applyPreview", "", "view", "Lcom/otaliastudios/cameraview/CameraView;", "value", "set", "app_debug"})
    public static final class Preview extends com.devbeans.io.vault.camera.Option.Control<com.otaliastudios.cameraview.controls.Preview> {
        
        public Preview() {
            super(null, null);
        }
        
        @java.lang.Override
        public void set(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.controls.Preview value) {
        }
        
        private final void applyPreview(com.otaliastudios.cameraview.CameraView view, com.otaliastudios.cameraview.controls.Preview value) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$Flash;", "Lcom/devbeans/io/vault/camera/Option$Control;", "Lcom/otaliastudios/cameraview/controls/Flash;", "()V", "app_debug"})
    public static final class Flash extends com.devbeans.io.vault.camera.Option.Control<com.otaliastudios.cameraview.controls.Flash> {
        
        public Flash() {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$WhiteBalance;", "Lcom/devbeans/io/vault/camera/Option$Control;", "Lcom/otaliastudios/cameraview/controls/WhiteBalance;", "()V", "app_debug"})
    public static final class WhiteBalance extends com.devbeans.io.vault.camera.Option.Control<com.otaliastudios.cameraview.controls.WhiteBalance> {
        
        public WhiteBalance() {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$Hdr;", "Lcom/devbeans/io/vault/camera/Option$Control;", "Lcom/otaliastudios/cameraview/controls/Hdr;", "()V", "app_debug"})
    public static final class Hdr extends com.devbeans.io.vault.camera.Option.Control<com.otaliastudios.cameraview.controls.Hdr> {
        
        public Hdr() {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$PictureMetering;", "Lcom/devbeans/io/vault/camera/Option;", "", "()V", "get", "view", "Lcom/otaliastudios/cameraview/CameraView;", "(Lcom/otaliastudios/cameraview/CameraView;)Ljava/lang/Boolean;", "getAll", "", "options", "Lcom/otaliastudios/cameraview/CameraOptions;", "set", "", "value", "app_debug"})
    public static final class PictureMetering extends com.devbeans.io.vault.camera.Option<java.lang.Boolean> {
        
        public PictureMetering() {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.Boolean get(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.util.List<java.lang.Boolean> getAll(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraOptions options) {
            return null;
        }
        
        @java.lang.Override
        public void set(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, boolean value) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$PictureSnapshotMetering;", "Lcom/devbeans/io/vault/camera/Option;", "", "()V", "get", "view", "Lcom/otaliastudios/cameraview/CameraView;", "(Lcom/otaliastudios/cameraview/CameraView;)Ljava/lang/Boolean;", "getAll", "", "options", "Lcom/otaliastudios/cameraview/CameraOptions;", "set", "", "value", "app_debug"})
    public static final class PictureSnapshotMetering extends com.devbeans.io.vault.camera.Option<java.lang.Boolean> {
        
        public PictureSnapshotMetering() {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.Boolean get(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.util.List<java.lang.Boolean> getAll(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraOptions options) {
            return null;
        }
        
        @java.lang.Override
        public void set(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, boolean value) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$VideoCodec;", "Lcom/devbeans/io/vault/camera/Option$Control;", "Lcom/otaliastudios/cameraview/controls/VideoCodec;", "()V", "app_debug"})
    public static final class VideoCodec extends com.devbeans.io.vault.camera.Option.Control<com.otaliastudios.cameraview.controls.VideoCodec> {
        
        public VideoCodec() {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$AudioCodec;", "Lcom/devbeans/io/vault/camera/Option$Control;", "Lcom/otaliastudios/cameraview/controls/AudioCodec;", "()V", "app_debug"})
    public static final class AudioCodec extends com.devbeans.io.vault.camera.Option.Control<com.otaliastudios.cameraview.controls.AudioCodec> {
        
        public AudioCodec() {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$Audio;", "Lcom/devbeans/io/vault/camera/Option$Control;", "Lcom/otaliastudios/cameraview/controls/Audio;", "()V", "app_debug"})
    public static final class Audio extends com.devbeans.io.vault.camera.Option.Control<com.otaliastudios.cameraview.controls.Audio> {
        
        public Audio() {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$Gesture;", "Lcom/devbeans/io/vault/camera/Option;", "Lcom/otaliastudios/cameraview/gesture/GestureAction;", "gesture", "Lcom/otaliastudios/cameraview/gesture/Gesture;", "name", "", "(Lcom/otaliastudios/cameraview/gesture/Gesture;Ljava/lang/String;)V", "getGesture", "()Lcom/otaliastudios/cameraview/gesture/Gesture;", "get", "view", "Lcom/otaliastudios/cameraview/CameraView;", "getAll", "", "options", "Lcom/otaliastudios/cameraview/CameraOptions;", "set", "", "value", "app_debug"})
    public static abstract class Gesture extends com.devbeans.io.vault.camera.Option<com.otaliastudios.cameraview.gesture.GestureAction> {
        @org.jetbrains.annotations.NotNull
        private final com.otaliastudios.cameraview.gesture.Gesture gesture = null;
        
        public Gesture(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.gesture.Gesture gesture, @org.jetbrains.annotations.NotNull
        java.lang.String name) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.otaliastudios.cameraview.gesture.Gesture getGesture() {
            return null;
        }
        
        @java.lang.Override
        public void set(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.gesture.GestureAction value) {
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.otaliastudios.cameraview.gesture.GestureAction get(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.util.Collection<com.otaliastudios.cameraview.gesture.GestureAction> getAll(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraOptions options) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$Pinch;", "Lcom/devbeans/io/vault/camera/Option$Gesture;", "()V", "app_debug"})
    public static final class Pinch extends com.devbeans.io.vault.camera.Option.Gesture {
        
        public Pinch() {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$HorizontalScroll;", "Lcom/devbeans/io/vault/camera/Option$Gesture;", "()V", "app_debug"})
    public static final class HorizontalScroll extends com.devbeans.io.vault.camera.Option.Gesture {
        
        public HorizontalScroll() {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$VerticalScroll;", "Lcom/devbeans/io/vault/camera/Option$Gesture;", "()V", "app_debug"})
    public static final class VerticalScroll extends com.devbeans.io.vault.camera.Option.Gesture {
        
        public VerticalScroll() {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$Tap;", "Lcom/devbeans/io/vault/camera/Option$Gesture;", "()V", "app_debug"})
    public static final class Tap extends com.devbeans.io.vault.camera.Option.Gesture {
        
        public Tap() {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$LongTap;", "Lcom/devbeans/io/vault/camera/Option$Gesture;", "()V", "app_debug"})
    public static final class LongTap extends com.devbeans.io.vault.camera.Option.Gesture {
        
        public LongTap() {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a2\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$Overlay;", "Lcom/devbeans/io/vault/camera/Option;", "", "overlay", "Landroid/view/View;", "target", "Lcom/otaliastudios/cameraview/overlay/Overlay$Target;", "name", "", "(Landroid/view/View;Lcom/otaliastudios/cameraview/overlay/Overlay$Target;Ljava/lang/String;)V", "get", "view", "Lcom/otaliastudios/cameraview/CameraView;", "(Lcom/otaliastudios/cameraview/CameraView;)Ljava/lang/Boolean;", "getAll", "", "options", "Lcom/otaliastudios/cameraview/CameraOptions;", "set", "", "value", "app_debug"})
    public static abstract class Overlay extends com.devbeans.io.vault.camera.Option<java.lang.Boolean> {
        private final android.view.View overlay = null;
        private final com.otaliastudios.cameraview.overlay.Overlay.Target target = null;
        
        public Overlay(@org.jetbrains.annotations.NotNull
        android.view.View overlay, @org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.overlay.Overlay.Target target, @org.jetbrains.annotations.NotNull
        java.lang.String name) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.util.List<java.lang.Boolean> getAll(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraOptions options) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.Boolean get(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view) {
            return null;
        }
        
        @java.lang.Override
        public void set(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, boolean value) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$OverlayInPreview;", "Lcom/devbeans/io/vault/camera/Option$Overlay;", "overlay", "Landroid/view/View;", "(Landroid/view/View;)V", "app_debug"})
    public static final class OverlayInPreview extends com.devbeans.io.vault.camera.Option.Overlay {
        
        public OverlayInPreview(@org.jetbrains.annotations.NotNull
        android.view.View overlay) {
            super(null, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$OverlayInPictureSnapshot;", "Lcom/devbeans/io/vault/camera/Option$Overlay;", "overlay", "Landroid/view/View;", "(Landroid/view/View;)V", "app_debug"})
    public static final class OverlayInPictureSnapshot extends com.devbeans.io.vault.camera.Option.Overlay {
        
        public OverlayInPictureSnapshot(@org.jetbrains.annotations.NotNull
        android.view.View overlay) {
            super(null, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$OverlayInVideoSnapshot;", "Lcom/devbeans/io/vault/camera/Option$Overlay;", "overlay", "Landroid/view/View;", "(Landroid/view/View;)V", "app_debug"})
    public static final class OverlayInVideoSnapshot extends com.devbeans.io.vault.camera.Option.Overlay {
        
        public OverlayInVideoSnapshot(@org.jetbrains.annotations.NotNull
        android.view.View overlay) {
            super(null, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$Grid;", "Lcom/devbeans/io/vault/camera/Option$Control;", "Lcom/otaliastudios/cameraview/controls/Grid;", "()V", "app_debug"})
    public static final class Grid extends com.devbeans.io.vault.camera.Option.Control<com.otaliastudios.cameraview.controls.Grid> {
        
        public Grid() {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0005J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J*\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$GridColor;", "Lcom/devbeans/io/vault/camera/Option;", "Lkotlin/Pair;", "", "", "()V", "all", "", "get", "view", "Lcom/otaliastudios/cameraview/CameraView;", "getAll", "options", "Lcom/otaliastudios/cameraview/CameraOptions;", "set", "", "value", "app_debug"})
    public static final class GridColor extends com.devbeans.io.vault.camera.Option<kotlin.Pair<? extends java.lang.Integer, ? extends java.lang.String>> {
        private final java.util.List<kotlin.Pair<java.lang.Integer, java.lang.String>> all = null;
        
        public GridColor() {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.util.List<kotlin.Pair<java.lang.Integer, java.lang.String>> getAll(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraOptions options) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public kotlin.Pair<java.lang.Integer, java.lang.String> get(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view) {
            return null;
        }
        
        @java.lang.Override
        public void set(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
        kotlin.Pair<java.lang.Integer, java.lang.String> value) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$UseDeviceOrientation;", "Lcom/devbeans/io/vault/camera/Option;", "", "()V", "get", "view", "Lcom/otaliastudios/cameraview/CameraView;", "(Lcom/otaliastudios/cameraview/CameraView;)Ljava/lang/Boolean;", "getAll", "", "options", "Lcom/otaliastudios/cameraview/CameraOptions;", "set", "", "value", "app_debug"})
    public static final class UseDeviceOrientation extends com.devbeans.io.vault.camera.Option<java.lang.Boolean> {
        
        public UseDeviceOrientation() {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.util.List<java.lang.Boolean> getAll(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraOptions options) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.Boolean get(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view) {
            return null;
        }
        
        @java.lang.Override
        public void set(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, boolean value) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$PreviewFrameRate;", "Lcom/devbeans/io/vault/camera/Option;", "", "()V", "get", "view", "Lcom/otaliastudios/cameraview/CameraView;", "(Lcom/otaliastudios/cameraview/CameraView;)Ljava/lang/Integer;", "getAll", "", "options", "Lcom/otaliastudios/cameraview/CameraOptions;", "set", "", "value", "app_debug"})
    public static final class PreviewFrameRate extends com.devbeans.io.vault.camera.Option<java.lang.Integer> {
        
        public PreviewFrameRate() {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.Integer get(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view) {
            return null;
        }
        
        @java.lang.Override
        public void set(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, int value) {
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.util.Collection<java.lang.Integer> getAll(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraOptions options) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$PictureFormat;", "Lcom/devbeans/io/vault/camera/Option$Control;", "Lcom/otaliastudios/cameraview/controls/PictureFormat;", "()V", "app_debug"})
    public static final class PictureFormat extends com.devbeans.io.vault.camera.Option.Control<com.otaliastudios.cameraview.controls.PictureFormat> {
        
        public PictureFormat() {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J:\u0010\b\u001a$\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00020\u0002 \n*\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00020\u00020\u000b0\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/devbeans/io/vault/camera/Option$FrameProcessingFormat;", "Lcom/devbeans/io/vault/camera/Option;", "", "()V", "get", "view", "Lcom/otaliastudios/cameraview/CameraView;", "(Lcom/otaliastudios/cameraview/CameraView;)Ljava/lang/Integer;", "getAll", "", "kotlin.jvm.PlatformType", "", "options", "Lcom/otaliastudios/cameraview/CameraOptions;", "set", "", "value", "toString", "", "app_debug"})
    public static final class FrameProcessingFormat extends com.devbeans.io.vault.camera.Option<java.lang.Integer> {
        
        public FrameProcessingFormat() {
            super(null);
        }
        
        @java.lang.Override
        public void set(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, int value) {
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.Integer get(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.util.Collection<java.lang.Integer> getAll(@org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraView view, @org.jetbrains.annotations.NotNull
        com.otaliastudios.cameraview.CameraOptions options) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString(int value) {
            return null;
        }
    }
}