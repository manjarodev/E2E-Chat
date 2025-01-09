package com.devbeans.io.chat.utils.views;

import java.lang.System;

/**
 * Show number pickers for value and units that are valid for expiration timer.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0013B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\f\u001a\u00020\u0007J\u0015\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/devbeans/io/chat/utils/views/CustomExpireTimerSelectorView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "unitPicker", "Landroid/widget/NumberPicker;", "valuePicker", "getTimer", "setTimer", "", "timer", "(Ljava/lang/Integer;)V", "unitChange", "newValue", "TimerUnit", "app_debug"})
public final class CustomExpireTimerSelectorView extends android.widget.LinearLayout {
    private final android.widget.NumberPicker valuePicker = null;
    private final android.widget.NumberPicker unitPicker = null;
    
    @kotlin.jvm.JvmOverloads
    public CustomExpireTimerSelectorView(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public CustomExpireTimerSelectorView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public CustomExpireTimerSelectorView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    public final void setTimer(@org.jetbrains.annotations.Nullable
    java.lang.Integer timer) {
    }
    
    public final int getTimer() {
        return 0;
    }
    
    private final void unitChange(int newValue) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\b\u0082\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0013"}, d2 = {"Lcom/devbeans/io/chat/utils/views/CustomExpireTimerSelectorView$TimerUnit;", "", "minValue", "", "maxValue", "valueMultiplier", "", "(Ljava/lang/String;IIIJ)V", "getMaxValue", "()I", "getMinValue", "getValueMultiplier", "()J", "SECONDS", "MINUTES", "HOURS", "DAYS", "WEEKS", "Companion", "app_debug"})
    static enum TimerUnit {
        /*public static final*/ SECONDS /* = new SECONDS(0, 0, 0L) */,
        /*public static final*/ MINUTES /* = new MINUTES(0, 0, 0L) */,
        /*public static final*/ HOURS /* = new HOURS(0, 0, 0L) */,
        /*public static final*/ DAYS /* = new DAYS(0, 0, 0L) */,
        /*public static final*/ WEEKS /* = new WEEKS(0, 0, 0L) */;
        private final int minValue = 0;
        private final int maxValue = 0;
        private final long valueMultiplier = 0L;
        @org.jetbrains.annotations.NotNull
        public static final com.devbeans.io.chat.utils.views.CustomExpireTimerSelectorView.TimerUnit.Companion Companion = null;
        
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
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/devbeans/io/chat/utils/views/CustomExpireTimerSelectorView$TimerUnit$Companion;", "", "()V", "get", "Lcom/devbeans/io/chat/utils/views/CustomExpireTimerSelectorView$TimerUnit;", "value", "", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.devbeans.io.chat.utils.views.CustomExpireTimerSelectorView.TimerUnit get(int value) {
                return null;
            }
        }
    }
}