package com.devbeans.io.chat.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 72\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u000278B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u001e\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$H\u0015J\b\u0010%\u001a\u00020\u0007H\u0014J&\u0010&\u001a\u00020\u00072\f\u0010\'\u001a\b\u0012\u0002\b\u0003\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0007H\u0014J*\u0010.\u001a\u00020\u00072\f\u0010\'\u001a\b\u0012\u0002\b\u0003\u0018\u00010(2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030/2\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u0007H\u0002J\u0010\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0018H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00078CX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\tR\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u00069"}, d2 = {"Lcom/devbeans/io/chat/activities/DisappearingMsgActivity;", "Lcom/devbeans/io/chat/verifypin/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lcom/devbeans/io/chat/network/OnNetworkResponse;", "Lcom/devbeans/io/chat/callBacks/ExpiryCallback;", "()V", "checkConversation", "", "getCheckConversation", "()Lkotlin/Unit;", "isFromCreateConversation", "", "isFromGeneralSettings", "mBinding", "Lcom/devbeans/io/chat/databinding/ActivityDisappearingMsgBinding;", "mConversation", "Lcom/devbeans/io/chat/models/Conversation;", "mOption", "", "mSelectedOption", "Landroidx/lifecycle/MutableLiveData;", "roomData", "getRoomData", "time", "", "getTime", "()J", "setTime", "(J)V", "getConversation", "notifyExpiry", "onClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFailure", "call", "Lretrofit2/Call;", "response", "Lcom/devbeans/io/chat/network/serializers/response/BaseResponse;", "tag", "", "onResume", "onSuccess", "Lretrofit2/Response;", "setExpiryTime", "i", "_unit", "", "setToolbar", "updateExpiryTime", "timeInMillis", "Companion", "TimerUnit", "app_debug"})
public final class DisappearingMsgActivity extends com.devbeans.io.chat.verifypin.BaseActivity implements android.view.View.OnClickListener, com.devbeans.io.chat.network.OnNetworkResponse, com.devbeans.io.chat.callBacks.ExpiryCallback {
    private long time = -1L;
    private com.devbeans.io.chat.databinding.ActivityDisappearingMsgBinding mBinding;
    private androidx.lifecycle.MutableLiveData<java.lang.String> mSelectedOption;
    private java.lang.String mOption;
    private com.devbeans.io.chat.models.Conversation mConversation;
    private boolean isFromCreateConversation = false;
    private boolean isFromGeneralSettings = false;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.activities.DisappearingMsgActivity.Companion Companion = null;
    private static com.devbeans.io.chat.activities.DisappearingMsgActivity disappearingMsgActivity;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = null;
    
    public DisappearingMsgActivity() {
        super();
    }
    
    public final long getTime() {
        return 0L;
    }
    
    public final void setTime(long p0) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.N)
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.N)
    private final kotlin.Unit getRoomData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.devbeans.io.chat.models.Conversation getConversation() {
        return null;
    }
    
    private final kotlin.Unit getCheckConversation() {
        return null;
    }
    
    private final void setToolbar() {
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    private final void setExpiryTime(long i, int _unit) {
    }
    
    private final void updateExpiryTime(long timeInMillis) {
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.text.ParseException.class})
    @java.lang.Override
    public void onSuccess(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    retrofit2.Response<?> response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    @java.lang.Override
    public void onFailure(@org.jetbrains.annotations.Nullable
    retrofit2.Call<?> call, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.network.serializers.response.BaseResponse response, @org.jetbrains.annotations.NotNull
    java.lang.Object tag) {
    }
    
    public final boolean isFromCreateConversation() {
        return false;
    }
    
    @java.lang.Override
    public void notifyExpiry() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0014"}, d2 = {"Lcom/devbeans/io/chat/activities/DisappearingMsgActivity$TimerUnit;", "", "minValue", "", "maxValue", "valueMultiplier", "", "(Ljava/lang/String;IIIJ)V", "getMaxValue", "()I", "getMinValue", "getValueMultiplier", "()J", "SECONDS", "MINUTES", "HOURS", "DAYS", "WEEKS", "MONTH", "Companion", "app_debug"})
    public static enum TimerUnit {
        /*public static final*/ SECONDS /* = new SECONDS(0, 0, 0L) */,
        /*public static final*/ MINUTES /* = new MINUTES(0, 0, 0L) */,
        /*public static final*/ HOURS /* = new HOURS(0, 0, 0L) */,
        /*public static final*/ DAYS /* = new DAYS(0, 0, 0L) */,
        /*public static final*/ WEEKS /* = new WEEKS(0, 0, 0L) */,
        /*public static final*/ MONTH /* = new MONTH(0, 0, 0L) */;
        private final int minValue = 0;
        private final int maxValue = 0;
        private final long valueMultiplier = 0L;
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.activities.DisappearingMsgActivity.TimerUnit.Companion Companion = null;
        
        TimerUnit(int minValue, int maxValue, long valueMultiplier) {
        }
        
        public final int getMinValue() {
            return 0;
        }
        
        public final int getMaxValue() {
            return 0;
        }
        
        public final long getValueMultiplier() {
            return 0L;
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/devbeans/io/chat/activities/DisappearingMsgActivity$TimerUnit$Companion;", "", "()V", "get", "Lcom/devbeans/io/chat/activities/DisappearingMsgActivity$TimerUnit;", "value", "", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.devbeans.io.chat.activities.DisappearingMsgActivity.TimerUnit get(int value) {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/devbeans/io/chat/activities/DisappearingMsgActivity$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "disappearingMsgActivity", "Lcom/devbeans/io/chat/activities/DisappearingMsgActivity;", "instance", "getInstance", "()Lcom/devbeans/io/chat/activities/DisappearingMsgActivity;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getTAG() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        @kotlin.jvm.Synchronized
        public final synchronized com.devbeans.io.chat.activities.DisappearingMsgActivity getInstance() {
            return null;
        }
    }
}