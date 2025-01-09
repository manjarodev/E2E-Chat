package com.devbeans.io.chat.app;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001<B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010\'\u001a\u0004\u0018\u00010\u0000J\b\u0010(\u001a\u00020\"H\u0002J\b\u0010)\u001a\u00020\"H\u0007J\b\u0010*\u001a\u00020\"H\u0002J\u0006\u0010+\u001a\u00020\"J\b\u0010,\u001a\u00020\"H\u0002J\u000e\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020\"J\b\u00101\u001a\u00020\"H\u0007J\b\u00102\u001a\u00020\"H\u0007J\b\u00103\u001a\u00020\"H\u0017J\b\u00104\u001a\u00020\"H\u0002J\u000e\u00105\u001a\u00020\"2\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020\u0011J\u000e\u0010:\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010;\u001a\u00020\"H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0000X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006="}, d2 = {"Lcom/devbeans/io/chat/app/MainApp;", "Landroid/app/Application;", "Lcom/devbeans/io/chat/utils/AppForegroundObserver$Listener;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "INSTANCE", "getINSTANCE", "()Lcom/devbeans/io/chat/app/MainApp;", "setINSTANCE", "(Lcom/devbeans/io/chat/app/MainApp;)V", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "setCurrentActivity", "(Landroid/app/Activity;)V", "expiryListener", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "getExpiryListener", "()Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "setExpiryListener", "(Lcom/devbeans/io/chat/callBacks/ExpiryCallback;)V", "isAppInForground", "", "()Z", "setAppInForground", "(Z)V", "webSocketStateChangeListener", "Lcom/devbeans/io/chat/websocket/WebSocketStateChangeListener;", "getWebSocketStateChangeListener", "()Lcom/devbeans/io/chat/websocket/WebSocketStateChangeListener;", "setWebSocketStateChangeListener", "(Lcom/devbeans/io/chat/websocket/WebSocketStateChangeListener;)V", "appForegroundObserver", "", "configurePR", "context", "Landroid/content/Context;", "createDirectories", "getAppContext", "initAPIs", "initializeAppDependencies", "initializeExpiringMessageManager", "initializeRevealableMessageManager", "initializeWorker", "notifySocketStateChange", "state", "Lcom/devbeans/io/chat/websocket/WebSocketConnectionState;", "notifyViewExpiry", "onAppBackgrounded", "onAppForegrounded", "onCreate", "regiterActivityCallback", "scheduleNextRevealableMessageManager", "TAG", "", "setNotifyExpiry", "expiryCallback", "setSocketChangeListener", "setupMediaRoutes", "Companion", "app_debug"})
public final class MainApp extends android.app.Application implements com.devbeans.io.chat.utils.AppForegroundObserver.Listener, androidx.lifecycle.LifecycleObserver {
    private boolean isAppInForground = false;
    @org.jetbrains.annotations.Nullable
    private android.app.Activity currentActivity;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.callBacks.ExpiryCallback expiryListener;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.websocket.WebSocketStateChangeListener webSocketStateChangeListener;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.app.MainApp INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.app.MainApp.Companion Companion = null;
    private static final java.lang.String TAG = null;
    @org.jetbrains.annotations.Nullable
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    private static com.devbeans.io.chat.app.MainApp appContext;
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmField
    public static com.devbeans.io.chat.app.AppDatabase database;
    @org.jetbrains.annotations.Nullable
    private static com.devbeans.io.chat.utils.AppForegroundObserver appForegroundObserver;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.Object LOCK = null;
    private static boolean isServiceRunning = false;
    @org.jetbrains.annotations.Nullable
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    private static com.devbeans.io.chat.utils.SimpleExoPlayerPool exoPlayerPool;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String imagesPath;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String audioPath;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String videoPath;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String filesPath;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String cachePath;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String trimmerPath;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String imagesPathSent;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String imagesPathReceive;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String imagesPathConv;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String imagesPathCaptured;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String audioPathSent;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String audioPathReceive;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String videoPathSent;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String videoPathReceive;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String videoPathCaptured;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String filesPathSent;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String filesPathReceive;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String confPath;
    @org.jetbrains.annotations.Nullable
    private static java.lang.String rootPath;
    @org.jetbrains.annotations.Nullable
    private static com.snatik.storage.Storage storage;
    public static com.devbeans.io.chat.app.AppSession session;
    public static com.devbeans.io.chat.verifypin.PinDialog pinDialog;
    public static com.goterl.lazysodium.LazySodiumAndroid ls;
    public static com.goterl.lazysodium.interfaces.Box.Lazy box;
    @org.jetbrains.annotations.Nullable
    private static com.devbeans.io.chat.utils.Stopwatch stopwatchOverAll;
    
    public MainApp() {
        super();
    }
    
    public final boolean isAppInForground() {
        return false;
    }
    
    public final void setAppInForground(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.app.Activity getCurrentActivity() {
        return null;
    }
    
    public final void setCurrentActivity(@org.jetbrains.annotations.Nullable
    android.app.Activity p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.callBacks.ExpiryCallback getExpiryListener() {
        return null;
    }
    
    public final void setExpiryListener(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.callBacks.ExpiryCallback p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.websocket.WebSocketStateChangeListener getWebSocketStateChangeListener() {
        return null;
    }
    
    public final void setWebSocketStateChangeListener(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.websocket.WebSocketStateChangeListener p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.app.MainApp getINSTANCE() {
        return null;
    }
    
    public final void setINSTANCE(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.app.MainApp p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.app.MainApp getAppContext() {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.P)
    @java.lang.Override
    public void onCreate() {
    }
    
    public final void initializeRevealableMessageManager() {
    }
    
    public final void scheduleNextRevealableMessageManager(@org.jetbrains.annotations.NotNull
    java.lang.String TAG) {
    }
    
    private final void configurePR(android.content.Context context) {
    }
    
    public final void setSocketChangeListener(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.websocket.WebSocketStateChangeListener webSocketStateChangeListener) {
    }
    
    public final void notifySocketStateChange(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.websocket.WebSocketConnectionState state) {
    }
    
    private final void initializeWorker() {
    }
    
    private final void appForegroundObserver() {
    }
    
    private final void initializeExpiringMessageManager() {
    }
    
    @androidx.annotation.VisibleForTesting
    public final void initializeAppDependencies() {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_STOP)
    public final void onAppBackgrounded() {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_START)
    public final void onAppForegrounded() {
    }
    
    private final void setupMediaRoutes() {
    }
    
    private final void createDirectories() {
    }
    
    private final void regiterActivityCallback() {
    }
    
    private final void initAPIs() {
    }
    
    public final void setNotifyExpiry(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.callBacks.ExpiryCallback expiryCallback) {
    }
    
    public final void notifyViewExpiry() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\u0012H\u0007\u00a2\u0006\u0003\b\u0082\u0001J\u000e\u00101\u001a\u000200H\u0007\u00a2\u0006\u0003\b\u0083\u0001J\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001J\u0018\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u000e\u0010\u0086\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u0087\u0001R\u0011\u0010\u0003\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\"X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\'\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\n\"\u0004\b)\u0010\u001aR\u001c\u0010*\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\n\"\u0004\b,\u0010\u001aR\u0014\u0010-\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R \u0010/\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\n\"\u0004\b7\u0010\u001aR\u001c\u00108\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\n\"\u0004\b:\u0010\u001aR\u001c\u0010;\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\n\"\u0004\b=\u0010\u001aR\u001c\u0010>\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\n\"\u0004\b@\u0010\u001aR\u001c\u0010A\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\n\"\u0004\bC\u0010\u001aR\u001c\u0010D\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\n\"\u0004\bF\u0010\u001aR\u001c\u0010G\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\n\"\u0004\bI\u0010\u001aR\u001c\u0010J\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\n\"\u0004\bL\u0010\u001aR\u001a\u0010M\u001a\u00020NX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020SX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020YX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001c\u0010^\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\n\"\u0004\b`\u0010\u001aR\u001a\u0010a\u001a\u00020bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001c\u0010g\u001a\u0004\u0018\u00010hX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u001c\u0010m\u001a\u0004\u0018\u00010nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001c\u0010s\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\n\"\u0004\bu\u0010\u001aR\u001c\u0010v\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\n\"\u0004\bx\u0010\u001aR\u001c\u0010y\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\n\"\u0004\b{\u0010\u001aR\u001c\u0010|\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\n\"\u0004\b~\u0010\u001aR\u001e\u0010\u007f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\n\"\u0005\b\u0081\u0001\u0010\u001a\u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/devbeans/io/chat/app/MainApp$Companion;", "", "()V", "LOCK", "getLOCK", "()Ljava/lang/Object;", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "appContext", "Lcom/devbeans/io/chat/app/MainApp;", "getAppContext", "()Lcom/devbeans/io/chat/app/MainApp;", "setAppContext", "(Lcom/devbeans/io/chat/app/MainApp;)V", "appForegroundObserver", "Lcom/devbeans/io/chat/utils/AppForegroundObserver;", "getAppForegroundObserver", "()Lcom/devbeans/io/chat/utils/AppForegroundObserver;", "setAppForegroundObserver", "(Lcom/devbeans/io/chat/utils/AppForegroundObserver;)V", "audioPath", "getAudioPath", "setAudioPath", "(Ljava/lang/String;)V", "audioPathReceive", "getAudioPathReceive", "setAudioPathReceive", "audioPathSent", "getAudioPathSent", "setAudioPathSent", "box", "Lcom/goterl/lazysodium/interfaces/Box$Lazy;", "getBox", "()Lcom/goterl/lazysodium/interfaces/Box$Lazy;", "setBox", "(Lcom/goterl/lazysodium/interfaces/Box$Lazy;)V", "cachePath", "getCachePath", "setCachePath", "confPath", "getConfPath", "setConfPath", "database", "Lcom/devbeans/io/chat/app/AppDatabase;", "exoPlayerPool", "Lcom/devbeans/io/chat/utils/SimpleExoPlayerPool;", "getExoPlayerPool", "()Lcom/devbeans/io/chat/utils/SimpleExoPlayerPool;", "setExoPlayerPool", "(Lcom/devbeans/io/chat/utils/SimpleExoPlayerPool;)V", "filesPath", "getFilesPath", "setFilesPath", "filesPathReceive", "getFilesPathReceive", "setFilesPathReceive", "filesPathSent", "getFilesPathSent", "setFilesPathSent", "imagesPath", "getImagesPath", "setImagesPath", "imagesPathCaptured", "getImagesPathCaptured", "setImagesPathCaptured", "imagesPathConv", "getImagesPathConv", "setImagesPathConv", "imagesPathReceive", "getImagesPathReceive", "setImagesPathReceive", "imagesPathSent", "getImagesPathSent", "setImagesPathSent", "isServiceRunning", "", "()Z", "setServiceRunning", "(Z)V", "ls", "Lcom/goterl/lazysodium/LazySodiumAndroid;", "getLs", "()Lcom/goterl/lazysodium/LazySodiumAndroid;", "setLs", "(Lcom/goterl/lazysodium/LazySodiumAndroid;)V", "pinDialog", "Lcom/devbeans/io/chat/verifypin/PinDialog;", "getPinDialog", "()Lcom/devbeans/io/chat/verifypin/PinDialog;", "setPinDialog", "(Lcom/devbeans/io/chat/verifypin/PinDialog;)V", "rootPath", "getRootPath", "setRootPath", "session", "Lcom/devbeans/io/chat/app/AppSession;", "getSession", "()Lcom/devbeans/io/chat/app/AppSession;", "setSession", "(Lcom/devbeans/io/chat/app/AppSession;)V", "stopwatchOverAll", "Lcom/devbeans/io/chat/utils/Stopwatch;", "getStopwatchOverAll", "()Lcom/devbeans/io/chat/utils/Stopwatch;", "setStopwatchOverAll", "(Lcom/devbeans/io/chat/utils/Stopwatch;)V", "storage", "Lcom/snatik/storage/Storage;", "getStorage", "()Lcom/snatik/storage/Storage;", "setStorage", "(Lcom/snatik/storage/Storage;)V", "trimmerPath", "getTrimmerPath", "setTrimmerPath", "videoPath", "getVideoPath", "setVideoPath", "videoPathCaptured", "getVideoPathCaptured", "setVideoPathCaptured", "videoPathReceive", "getVideoPathReceive", "setVideoPathReceive", "videoPathSent", "getVideoPathSent", "setVideoPathSent", "getAppForegroundObserver1", "getExoPlayerPool1", "resetApplication", "", "clas", "Ljava/lang/Class;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final java.lang.String getTAG() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.app.MainApp getAppContext() {
            return null;
        }
        
        public final void setAppContext(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.app.MainApp p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.utils.AppForegroundObserver getAppForegroundObserver() {
            return null;
        }
        
        public final void setAppForegroundObserver(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.utils.AppForegroundObserver p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.Object getLOCK() {
            return null;
        }
        
        public final boolean isServiceRunning() {
            return false;
        }
        
        public final void setServiceRunning(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.utils.SimpleExoPlayerPool getExoPlayerPool() {
            return null;
        }
        
        public final void setExoPlayerPool(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.utils.SimpleExoPlayerPool p0) {
        }
        
        public final void resetApplication(@org.jetbrains.annotations.Nullable
        java.lang.Class<?> clas) {
        }
        
        public final void resetApplication() {
        }
        
        @org.jetbrains.annotations.NotNull
        @kotlin.jvm.JvmName(name = "getAppForegroundObserver1")
        public final com.devbeans.io.chat.utils.AppForegroundObserver getAppForegroundObserver1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @kotlin.jvm.JvmName(name = "getExoPlayerPool1")
        public final com.devbeans.io.chat.utils.SimpleExoPlayerPool getExoPlayerPool1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getImagesPath() {
            return null;
        }
        
        public final void setImagesPath(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getAudioPath() {
            return null;
        }
        
        public final void setAudioPath(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getVideoPath() {
            return null;
        }
        
        public final void setVideoPath(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getFilesPath() {
            return null;
        }
        
        public final void setFilesPath(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getCachePath() {
            return null;
        }
        
        public final void setCachePath(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getTrimmerPath() {
            return null;
        }
        
        public final void setTrimmerPath(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getImagesPathSent() {
            return null;
        }
        
        public final void setImagesPathSent(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getImagesPathReceive() {
            return null;
        }
        
        public final void setImagesPathReceive(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getImagesPathConv() {
            return null;
        }
        
        public final void setImagesPathConv(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getImagesPathCaptured() {
            return null;
        }
        
        public final void setImagesPathCaptured(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getAudioPathSent() {
            return null;
        }
        
        public final void setAudioPathSent(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getAudioPathReceive() {
            return null;
        }
        
        public final void setAudioPathReceive(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getVideoPathSent() {
            return null;
        }
        
        public final void setVideoPathSent(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getVideoPathReceive() {
            return null;
        }
        
        public final void setVideoPathReceive(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getVideoPathCaptured() {
            return null;
        }
        
        public final void setVideoPathCaptured(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getFilesPathSent() {
            return null;
        }
        
        public final void setFilesPathSent(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getFilesPathReceive() {
            return null;
        }
        
        public final void setFilesPathReceive(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getConfPath() {
            return null;
        }
        
        public final void setConfPath(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getRootPath() {
            return null;
        }
        
        public final void setRootPath(@org.jetbrains.annotations.Nullable
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.snatik.storage.Storage getStorage() {
            return null;
        }
        
        public final void setStorage(@org.jetbrains.annotations.Nullable
        com.snatik.storage.Storage p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.app.AppSession getSession() {
            return null;
        }
        
        public final void setSession(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.app.AppSession p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.verifypin.PinDialog getPinDialog() {
            return null;
        }
        
        public final void setPinDialog(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.verifypin.PinDialog p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.goterl.lazysodium.LazySodiumAndroid getLs() {
            return null;
        }
        
        public final void setLs(@org.jetbrains.annotations.NotNull
        com.goterl.lazysodium.LazySodiumAndroid p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.goterl.lazysodium.interfaces.Box.Lazy getBox() {
            return null;
        }
        
        public final void setBox(@org.jetbrains.annotations.NotNull
        com.goterl.lazysodium.interfaces.Box.Lazy p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.utils.Stopwatch getStopwatchOverAll() {
            return null;
        }
        
        public final void setStopwatchOverAll(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.utils.Stopwatch p0) {
        }
    }
}