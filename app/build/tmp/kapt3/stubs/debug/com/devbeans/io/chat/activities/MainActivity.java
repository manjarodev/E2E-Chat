package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 k2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002klB\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010-\u001a\u00020(H\u0007J\"\u0010.\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u000e2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0007H\u0002J\u0012\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\u0007H\u0002J\u000e\u00106\u001a\u00020\u000b2\u0006\u00100\u001a\u000201J\u0010\u00107\u001a\u00020\u000b2\u0006\u00100\u001a\u000201H\u0002J\b\u00108\u001a\u00020\u000bH\u0002J\b\u00109\u001a\u0004\u0018\u00010:J\u0006\u0010;\u001a\u00020\u001cJ\u001a\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J\u000e\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020\u0007J\b\u0010D\u001a\u00020(H\u0016J\u0012\u0010E\u001a\u00020(2\b\u0010F\u001a\u0004\u0018\u00010GH\u0015J\b\u0010H\u001a\u00020(H\u0014J\u0010\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020(H\u0014J-\u0010M\u001a\u00020(2\u0006\u0010N\u001a\u00020A2\u000e\u0010\'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070O2\u0006\u0010P\u001a\u00020QH\u0016\u00a2\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020(H\u0014J\u0010\u0010T\u001a\u00020(2\u0006\u0010U\u001a\u00020VH\u0016J\u000e\u0010W\u001a\u00020(2\u0006\u0010C\u001a\u00020\u0007J\b\u0010X\u001a\u00020(H\u0003J\b\u0010Y\u001a\u00020(H\u0002J\u0018\u0010Z\u001a\u00020(2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0007H\u0002J\u0018\u0010[\u001a\u00020(2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0007H\u0002J\u0018\u0010\\\u001a\u00020(2\u0006\u00100\u001a\u0002012\u0006\u0010/\u001a\u00020\u000eH\u0002J\u0018\u0010]\u001a\u00020(2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0007H\u0002J\u000e\u0010^\u001a\u00020(2\u0006\u00100\u001a\u000201J\u000e\u0010_\u001a\u00020(2\u0006\u0010`\u001a\u000201J\u0016\u0010a\u001a\u00020(2\u0006\u0010b\u001a\u00020A2\u0006\u0010c\u001a\u00020\u0007J\b\u0010d\u001a\u00020(H\u0004J0\u0010e\u001a\u00020(\"\u0004\b\u0000\u0010f*\b\u0012\u0004\u0012\u0002Hf0\r2\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u0002Hf\u0012\u0004\u0012\u00020\u000b0hH\u0086\b\u00f8\u0001\u0000J\u001a\u0010i\u001a\u00020(*\u00020:2\u0006\u0010@\u001a\u00020A2\u0006\u0010j\u001a\u00020AR\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R>\u0010\f\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u00100\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010\'\u001a\u00020(8CX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006m"}, d2 = {"Lcom/devbeans/io/chat/activities/MainActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Lcom/devbeans/io/chat/utils/components/voice/VoiceNoteMediaControllerOwner;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "Lcom/devbeans/io/chat/websocket/WebSocketStateChangeListener;", "()V", "GET_UPDATED_CONVERSATION", "", "getGET_UPDATED_CONVERSATION", "()Ljava/lang/String;", "check", "", "conversations", "", "Lcom/devbeans/io/chat/models/Conversation;", "kotlin.jvm.PlatformType", "", "getConversations", "()Ljava/util/List;", "setConversations", "(Ljava/util/List;)V", "mBinding", "Lcom/devbeans/io/chat/databinding/ActivityMainBinding;", "getMBinding", "()Lcom/devbeans/io/chat/databinding/ActivityMainBinding;", "setMBinding", "(Lcom/devbeans/io/chat/databinding/ActivityMainBinding;)V", "mediaController", "Lcom/devbeans/io/chat/utils/components/voice/VoiceNoteMediaController;", "getMediaController", "()Lcom/devbeans/io/chat/utils/components/voice/VoiceNoteMediaController;", "setMediaController", "(Lcom/devbeans/io/chat/utils/components/voice/VoiceNoteMediaController;)V", "networkBroadcast", "Lcom/devbeans/io/chat/utils/NetworkReceiver;", "getNetworkBroadcast", "()Lcom/devbeans/io/chat/utils/NetworkReceiver;", "setNetworkBroadcast", "(Lcom/devbeans/io/chat/utils/NetworkReceiver;)V", "permissions", "", "getPermissions", "()Lkotlin/Unit;", "voiceNoteMediaController", "getVoiceNoteMediaController", "addUpdateBadge", "checkAckPayload", "conversation", "actualPayload", "Lcom/devbeans/io/chat/models/Payload;", "type", "checkContactNull", "Lcom/devbeans/io/chat/models/Contact;", "memberID", "checkNotifyPayload", "checkPayload", "checkPermission", "getBottomNav", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "getMediaControl", "getOrCreateBadge", "Landroid/widget/TextView;", "bottomBar", "Landroid/view/View;", "tabResId", "", "initiateSocketConnection", "tag", "notifyExpiry", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPause", "onRequestPermissionsResult", "requestCode", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStateChange", "state", "Lcom/devbeans/io/chat/websocket/WebSocketConnectionState;", "reInitiateSocketConnection", "registerNetworkReceiver", "requestPermission", "sendAck", "sendAckConfirmation", "sendAnonymousConfirmMember", "sendConfirmMember", "sendKeyDeficiencyAckConfirmation", "sendPayload", "payload", "setCount", "count", "s", "unregisterNetworkReceiver", "moveItemToFirstPosition", "T", "predicate", "Lkotlin/Function1;", "setBadge", "badgeValue", "Companion", "SocketListener", "app_debug"})
public final class MainActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements com.devbeans.io.chat.utils.components.voice.VoiceNoteMediaControllerOwner, com.devbeans.io.chat.callBacks.ExpiryCallback, com.devbeans.io.chat.websocket.WebSocketStateChangeListener {
    private boolean check = false;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.databinding.ActivityMainBinding mBinding;
    private java.util.List<com.devbeans.io.chat.models.Conversation> conversations;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.utils.NetworkReceiver networkBroadcast;
    @org.jetbrains.annotations.Nullable
    private com.devbeans.io.chat.utils.components.voice.VoiceNoteMediaController mediaController;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String GET_UPDATED_CONVERSATION = "MainActivity getUpdatedConversation: ";
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.activities.MainActivity.Companion Companion = null;
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmField
    public static okhttp3.WebSocket webSocket;
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmField
    public static com.devbeans.io.chat.websocket.ChatWebSocket chatWebSocket;
    private static final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmField
    public static androidx.lifecycle.MutableLiveData<java.lang.Boolean> isSocketConnected;
    @org.jetbrains.annotations.Nullable
    private static com.devbeans.io.chat.activities.MainActivity INSTANCE;
    @org.jetbrains.annotations.Nullable
    private static com.devbeans.io.chat.models.Payload prevPayload;
    @org.jetbrains.annotations.Nullable
    private static com.devbeans.io.chat.models.Payload prevEncryptedPayload;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.databinding.ActivityMainBinding getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.databinding.ActivityMainBinding p0) {
    }
    
    public final java.util.List<com.devbeans.io.chat.models.Conversation> getConversations() {
        return null;
    }
    
    public final void setConversations(java.util.List<com.devbeans.io.chat.models.Conversation> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.utils.NetworkReceiver getNetworkBroadcast() {
        return null;
    }
    
    public final void setNetworkBroadcast(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.utils.NetworkReceiver p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.utils.components.voice.VoiceNoteMediaController getMediaController() {
        return null;
    }
    
    public final void setMediaController(@org.jetbrains.annotations.Nullable
    com.devbeans.io.chat.utils.components.voice.VoiceNoteMediaController p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getGET_UPDATED_CONVERSATION() {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.R)
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    /**
     * Extension fun for bottom nav setting Badge Layout and count
     */
    public final void setBadge(@org.jetbrains.annotations.NotNull
    com.google.android.material.bottomnavigation.BottomNavigationView $this$setBadge, int tabResId, int badgeValue) {
    }
    
    private final android.widget.TextView getOrCreateBadge(android.view.View bottomBar, int tabResId) {
        return null;
    }
    
    /**
     * add badge(notification dot) to bottom bar
     * @param position to get badge container
     */
    @android.annotation.SuppressLint(value = {"PrivateResource"})
    public final void addUpdateBadge() {
    }
    
    public final void setCount(int count, @org.jetbrains.annotations.NotNull
    java.lang.String s) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.android.material.bottomnavigation.BottomNavigationView getBottomNav() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.utils.components.voice.VoiceNoteMediaController getMediaControl() {
        return null;
    }
    
    /**
     * Connect or Reconnect [WebSocket] when lifecycle event [onResume] is called
     */
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    public final void initiateSocketConnection(@org.jetbrains.annotations.NotNull
    java.lang.String tag) {
    }
    
    public final void reInitiateSocketConnection(@org.jetbrains.annotations.NotNull
    java.lang.String tag) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.R)
    private final kotlin.Unit getPermissions() {
        return null;
    }
    
    private final boolean checkPermission() {
        return false;
    }
    
    private final void requestPermission() {
    }
    
    @android.annotation.SuppressLint(value = {"ObsoleteSdkInt"})
    private final void registerNetworkReceiver() {
    }
    
    protected final void unregisterNetworkReceiver() {
    }
    
    private final void sendAnonymousConfirmMember(com.devbeans.io.chat.models.Payload actualPayload, com.devbeans.io.chat.models.Conversation conversation) {
    }
    
    private final void sendConfirmMember(com.devbeans.io.chat.models.Payload actualPayload, java.lang.String type) {
    }
    
    private final boolean checkAckPayload(com.devbeans.io.chat.models.Conversation conversation, com.devbeans.io.chat.models.Payload actualPayload, java.lang.String type) {
        return false;
    }
    
    private final void sendAck(com.devbeans.io.chat.models.Payload actualPayload, java.lang.String type) {
    }
    
    private final com.devbeans.io.chat.models.Contact checkContactNull(java.lang.String memberID) {
        return null;
    }
    
    private final void sendAckConfirmation(com.devbeans.io.chat.models.Payload actualPayload, java.lang.String type) {
    }
    
    public final void sendKeyDeficiencyAckConfirmation(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload actualPayload) {
    }
    
    public final void sendPayload(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload payload) {
    }
    
    /**
     * if the [actualPayload] is not in between these types
     * it means it needs to be handled with decryption
     */
    private final boolean checkPayload(com.devbeans.io.chat.models.Payload actualPayload) {
        return false;
    }
    
    public final boolean checkNotifyPayload(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.models.Payload actualPayload) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public static final com.devbeans.io.chat.activities.MainActivity getInstance() {
        return null;
    }
    
    @kotlin.jvm.JvmStatic
    public static final void runService() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.devbeans.io.chat.utils.components.voice.VoiceNoteMediaController getVoiceNoteMediaController() {
        return null;
    }
    
    public final <T extends java.lang.Object>void moveItemToFirstPosition(@org.jetbrains.annotations.NotNull
    java.util.List<T> $this$moveItemToFirstPosition, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> predicate) {
    }
    
    @java.lang.Override
    public void notifyExpiry() {
    }
    
    @java.lang.Override
    public void onStateChange(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.websocket.WebSocketConnectionState state) {
    }
    
    /**
     * Inner class for liseting to socket every time [onMessage] event is called
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0012\u0010 \u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%J\u0012\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\'\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010*\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010+\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010,\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u001a\u0010-\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020%H\u0003J\u0010\u00102\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u00103\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u00104\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u00105\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0012\u00106\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u0012\u00107\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u0010\u00108\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u00109\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010:\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010;\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010<\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010=\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010>\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0012\u0010?\u001a\u00020\u000f2\b\u0010@\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010A\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\tH\u0002J\u0010\u0010B\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010C\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010D\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010E\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0012\u0010F\u001a\u00020\u000f2\b\u0010@\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010G\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u001a\u0010H\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001f\u001a\u00020\tH\u0003J\u0010\u0010I\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\tH\u0003J\u0010\u0010J\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010K\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0012\u0010L\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u0010\u0010M\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010N\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J \u0010O\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020%H\u0016J \u0010T\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020%H\u0016J\"\u0010U\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020Q2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J&\u0010U\u001a\u00020\u000f2\f\u0010Z\u001a\b\u0012\u0002\b\u0003\u0018\u00010[2\u0006\u0010X\u001a\u00020\\2\u0006\u0010]\u001a\u00020^H\u0016J\u0018\u0010_\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020Q2\u0006\u00101\u001a\u00020%H\u0017J\u0018\u0010`\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020Q2\u0006\u0010X\u001a\u00020YH\u0016J*\u0010a\u001a\u00020\u000f2\f\u0010Z\u001a\b\u0012\u0002\b\u0003\u0018\u00010[2\n\u0010X\u001a\u0006\u0012\u0002\b\u00030b2\u0006\u0010]\u001a\u00020^H\u0016J\u0012\u0010c\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010d\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020\u0007H\u0002J\u001c\u0010h\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010i\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010j\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010k\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010l\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u001a\u0010m\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010n\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010o\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\tH\u0002J \u0010p\u001a\u0004\u0018\u00010%2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020%0r2\u0006\u0010\u0014\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006s"}, d2 = {"Lcom/devbeans/io/chat/activities/MainActivity$SocketListener;", "Lokhttp3/WebSocketListener;", "Lcom/devbeans/io/chat/network/OnNetworkResponse;", "(Lcom/devbeans/io/chat/activities/MainActivity;)V", "conId", "", "conversation", "Lcom/devbeans/io/chat/models/Conversation;", "payload", "Lcom/devbeans/io/chat/models/Payload;", "getPayload", "()Lcom/devbeans/io/chat/models/Payload;", "setPayload", "(Lcom/devbeans/io/chat/models/Payload;)V", "addPayloadInDb", "", "checkAdminAssignInDb", "actualPayload", "checkAdminRemoveinDb", "checkDeliveredToAll", "message", "checkHandleTextPayload", "", "checkMemberLeaveinDb", "checkMemberRemoveInDb", "checkMessageInDb", "checkOpenedToAll", "checkOwnerMessageInDb", "checkPayloadDelete", "checkPrevPayload", "prevEncryptedPayload", "decryptedPayload", "checkReadToAll", "deleteConversationChannels", "getChangedIconConversationLink", "getConversation", "id", "", "getPayloadStatus", "getUpdatedConversation", "handleAdminAssignedPayload", "handleAdminRemovedPayload", "handleAnonymousConvPayload", "handleBlockUnblockGroup", "handleChangeOwnerPayload", "handleConversationFromDb", "res", "Lcom/devbeans/io/chat/network/serializers/response/GetConversationResponse;", "handleData", "data", "handleDeletePayload", "handleDeliverPayload", "handleEditPayload", "handleExpireChangePayload", "handleGetConversationResponse", "handleGetGroupIconResponse", "handleGroupAndBlockMessage", "handleGroupConfidentialPayload", "handleGroupDesChangePayload", "handleGroupDestroyPayload", "handleGroupIconChangePayload", "handleGroupMediaRstrictPayload", "handleGroupNameChangePayload", "handleKeyDef", "plainPayload", "handleKeyDeficiencyPayload", "handleLastMessageConversation", "handleMemberAddedPayload", "handleMemberLeavePayload", "handleMemberRemovePayload", "handleMessage", "handleOtherMessages", "handlePrevDecryptPayload", "handlePrevPayload", "handleReadPayload", "handleTextPayload", "handleUpdateConversationResponse", "handleViewOnceAckPayload", "handleViewOncePayload", "onClosed", "webSocket", "Lokhttp3/WebSocket;", "code", "reason", "onClosing", "onFailure", "t", "", "response", "Lokhttp3/Response;", "call", "Lretrofit2/Call;", "Lcom/devbeans/io/chat/network/serializers/response/BaseResponse;", "tag", "", "onMessage", "onOpen", "onSuccess", "Lretrofit2/Response;", "sendConfirmAckForAnon", "updateConvWithImg", "imgFile", "Ljava/io/File;", "conversation1", "updateConvWithPayload", "conversation2", "updateConversationInOthers", "updateExpiryConversation", "updateGroupDesConversation", "updateGroupNameConversation", "groupName", "updateMessageInDb", "updateStatus", "members", "", "app_debug"})
    final class SocketListener extends okhttp3.WebSocketListener implements com.devbeans.io.chat.network.OnNetworkResponse {
        @org.jetbrains.annotations.Nullable
        private com.devbeans.io.chat.models.Payload payload;
        private com.devbeans.io.chat.models.Conversation conversation;
        private int conId = 0;
        
        public SocketListener() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.models.Payload getPayload() {
            return null;
        }
        
        public final void setPayload(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.models.Payload p0) {
        }
        
        @java.lang.Override
        public void onClosed(@org.jetbrains.annotations.NotNull
        okhttp3.WebSocket webSocket, int code, @org.jetbrains.annotations.NotNull
        java.lang.String reason) {
        }
        
        @java.lang.Override
        public void onClosing(@org.jetbrains.annotations.NotNull
        okhttp3.WebSocket webSocket, int code, @org.jetbrains.annotations.NotNull
        java.lang.String reason) {
        }
        
        @java.lang.Override
        public void onFailure(@org.jetbrains.annotations.NotNull
        okhttp3.WebSocket webSocket, @org.jetbrains.annotations.NotNull
        java.lang.Throwable t, @org.jetbrains.annotations.Nullable
        okhttp3.Response response) {
        }
        
        @java.lang.Override
        public void onOpen(@org.jetbrains.annotations.NotNull
        okhttp3.WebSocket webSocket, @org.jetbrains.annotations.NotNull
        okhttp3.Response response) {
        }
        
        /**
         * This method is called when a message is received from the WebSocket.
         * @param webSocket The WebSocket instance
         * @param data The message received from the WebSocket
         */
        @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
        @java.lang.Override
        public void onMessage(@org.jetbrains.annotations.NotNull
        okhttp3.WebSocket webSocket, @org.jetbrains.annotations.NotNull
        java.lang.String data) {
        }
        
        /**
         * Handles the given data by decrypting the payload and processing it accordingly.
         *
         * @param data The data to be handled.
         */
        @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
        private final void handleData(java.lang.String data) {
        }
        
        private final boolean checkPrevPayload(com.devbeans.io.chat.models.Payload prevEncryptedPayload, com.devbeans.io.chat.models.Payload decryptedPayload) {
            return false;
        }
        
        /**
         * Handles the previous decrypted payload by checking its properties and processing it accordingly.
         *
         * @param prevEncryptedPayload The previous encrypted payload.
         * @param decryptedPayload The decrypted payload to be handled.
         */
        @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
        private final void handlePrevDecryptPayload(com.devbeans.io.chat.models.Payload prevEncryptedPayload, com.devbeans.io.chat.models.Payload decryptedPayload) {
        }
        
        @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
        private final void handlePrevPayload(com.devbeans.io.chat.models.Payload decryptedPayload) {
        }
        
        /**
         * Handles the given payload by checking its properties and processing it accordingly.
         *
         * @param plainPayload The payload to be handled.
         */
        @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
        public final void handleMessage(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.models.Payload plainPayload) {
        }
        
        private final void handleKeyDef(com.devbeans.io.chat.models.Payload plainPayload) {
        }
        
        /**
         * Handles other types of messages by checking the payload type and processing it accordingly.
         *
         * @param actualPayload The payload to be handled.
         */
        private final void handleOtherMessages(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleGroupAndBlockMessage(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleBlockUnblockGroup(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleKeyDeficiencyPayload(com.devbeans.io.chat.models.Payload plainPayload) {
        }
        
        private final void handleViewOncePayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleGroupDestroyPayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleAnonymousConvPayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleExpireChangePayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void updateExpiryConversation(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleGroupDesChangePayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void updateGroupDesConversation(com.devbeans.io.chat.models.Conversation conversation, com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleGroupNameChangePayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void updateGroupNameConversation(com.devbeans.io.chat.models.Payload actualPayload, java.lang.String groupName) {
        }
        
        private final void checkMessageInDb(com.devbeans.io.chat.models.Conversation conversation, com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleGroupIconChangePayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleChangeOwnerPayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void checkOwnerMessageInDb(com.devbeans.io.chat.models.Conversation conversation, com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleMemberLeavePayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void checkMemberLeaveinDb(com.devbeans.io.chat.models.Conversation conversation, com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleAdminRemovedPayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void checkAdminRemoveinDb(com.devbeans.io.chat.models.Conversation conversation, com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void updateConversationInOthers(com.devbeans.io.chat.models.Conversation conversation) {
        }
        
        private final void handleAdminAssignedPayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void checkAdminAssignInDb(com.devbeans.io.chat.models.Conversation conversation, com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleMemberAddedPayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleMemberRemovePayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void checkMemberRemoveInDb(com.devbeans.io.chat.models.Conversation conversation, com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void deleteConversationChannels(com.devbeans.io.chat.models.Conversation conversation) {
        }
        
        private final void handleGroupMediaRstrictPayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleGroupConfidentialPayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleViewOnceAckPayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleReadPayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        /**
         * Handles the deliver payload by checking its properties and processing it accordingly.
         *
         * @param actualPayload The payload to be handled.
         */
        private final void handleDeliverPayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleDeletePayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final boolean checkPayloadDelete(com.devbeans.io.chat.models.Payload actualPayload) {
            return false;
        }
        
        private final void handleEditPayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleLastMessageConversation(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        private final void handleTextPayload(com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        /**
         * Checks if the text payload should be handled based on the user's properties and the payload's properties.
         *
         * @param actualPayload The payload to be checked.
         * @return True if the payload should be handled, false otherwise.
         */
        private final boolean checkHandleTextPayload(com.devbeans.io.chat.models.Payload actualPayload) {
            return false;
        }
        
        /**
         * Checks if the message has been delivered to all conversation members.
         *
         * @param message The message to be checked.
         */
        private final void checkDeliveredToAll(com.devbeans.io.chat.models.Payload message) {
        }
        
        /**
         * Updates the status of the message based on its properties and the given list of members.
         *
         * @param members The list of members to check against.
         * @param message The message to be updated.
         * @return The updated status of the message.
         */
        private final java.lang.String updateStatus(java.util.List<java.lang.String> members, com.devbeans.io.chat.models.Payload message) {
            return null;
        }
        
        /**
         * Updates the message in the database with the given payload.
         *
         * @param message The payload to be used to update the message.
         */
        private final void updateMessageInDb(com.devbeans.io.chat.models.Payload message) {
        }
        
        /**
         * Checks if a message has been read by all members of a conversation and updates its status accordingly.
         *
         * @param message The message to be checked.
         */
        private final void checkReadToAll(com.devbeans.io.chat.models.Payload message) {
        }
        
        /**
         * Checks if a message has been opened by all members of a conversation and updates its status accordingly.
         *
         * @param message The message to be checked.
         */
        private final void checkOpenedToAll(com.devbeans.io.chat.models.Payload message) {
        }
        
        public final void getConversation(@org.jetbrains.annotations.NotNull
        java.lang.String id) {
        }
        
        public final void getUpdatedConversation(@org.jetbrains.annotations.NotNull
        java.lang.String id) {
        }
        
        public final void getChangedIconConversationLink(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.models.Payload actualPayload) {
        }
        
        /**
         * Handles successful API responses.
         *
         * @param call The call that was made.
         * @param response The response received from the server.
         * @param tag The tag associated with the call.
         */
        @java.lang.Override
        public void onSuccess(@org.jetbrains.annotations.Nullable
        retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
        retrofit2.Response<?> response, @org.jetbrains.annotations.NotNull
        java.lang.Object tag) {
        }
        
        private final void handleGetGroupIconResponse(com.devbeans.io.chat.network.serializers.response.GetConversationResponse res) {
        }
        
        private final void updateConvWithPayload(com.devbeans.io.chat.models.Payload payload, com.devbeans.io.chat.models.Conversation conversation2) {
        }
        
        private final void updateConvWithImg(java.io.File imgFile, com.devbeans.io.chat.models.Conversation conversation1) {
        }
        
        private final void handleUpdateConversationResponse(com.devbeans.io.chat.network.serializers.response.GetConversationResponse res) {
        }
        
        private final void handleGetConversationResponse(com.devbeans.io.chat.network.serializers.response.GetConversationResponse res) {
        }
        
        private final java.lang.String getPayloadStatus(com.devbeans.io.chat.models.Payload payload) {
            return null;
        }
        
        private final void addPayloadInDb(com.devbeans.io.chat.models.Payload payload) {
        }
        
        private final void handleConversationFromDb(com.devbeans.io.chat.models.Conversation conversation, com.devbeans.io.chat.network.serializers.response.GetConversationResponse res) {
        }
        
        private final void sendConfirmAckForAnon(com.devbeans.io.chat.models.Payload payload) {
        }
        
        @java.lang.Override
        public void onFailure(@org.jetbrains.annotations.Nullable
        retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.network.serializers.response.BaseResponse response, @org.jetbrains.annotations.NotNull
        java.lang.Object tag) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0006R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u0014\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/devbeans/io/chat/activities/MainActivity$Companion;", "", "()V", "INSTANCE", "Lcom/devbeans/io/chat/activities/MainActivity;", "getINSTANCE", "()Lcom/devbeans/io/chat/activities/MainActivity;", "setINSTANCE", "(Lcom/devbeans/io/chat/activities/MainActivity;)V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "chatWebSocket", "Lcom/devbeans/io/chat/websocket/ChatWebSocket;", "instance", "getInstance$annotations", "getInstance", "isSocketConnected", "Landroidx/lifecycle/MutableLiveData;", "", "prevEncryptedPayload", "Lcom/devbeans/io/chat/models/Payload;", "getPrevEncryptedPayload", "()Lcom/devbeans/io/chat/models/Payload;", "setPrevEncryptedPayload", "(Lcom/devbeans/io/chat/models/Payload;)V", "prevPayload", "getPrevPayload", "setPrevPayload", "webSocket", "Lokhttp3/WebSocket;", "runService", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final java.lang.String getTAG() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.activities.MainActivity getINSTANCE() {
            return null;
        }
        
        public final void setINSTANCE(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.activities.MainActivity p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.models.Payload getPrevPayload() {
            return null;
        }
        
        public final void setPrevPayload(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.models.Payload p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.models.Payload getPrevEncryptedPayload() {
            return null;
        }
        
        public final void setPrevEncryptedPayload(@org.jetbrains.annotations.Nullable
        com.devbeans.io.chat.models.Payload p0) {
        }
        
        @kotlin.jvm.JvmStatic
        @java.lang.Deprecated
        public static void getInstance$annotations() {
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.devbeans.io.chat.activities.MainActivity getInstance() {
            return null;
        }
        
        @kotlin.jvm.JvmStatic
        public final void runService() {
        }
    }
}