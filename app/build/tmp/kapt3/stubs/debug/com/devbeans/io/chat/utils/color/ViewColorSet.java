package com.devbeans.io.chat.utils.color;

import java.lang.System;

/**
 * Represents a set of colors to be applied to the foreground and background of a view.
 *
 * Supports mixing color ints and color resource ids.
 */
@kotlinx.parcelize.Parcelize
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\rH\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u001c"}, d2 = {"Lcom/devbeans/io/chat/utils/color/ViewColorSet;", "Landroid/os/Parcelable;", "foreground", "Lcom/devbeans/io/chat/utils/color/ViewColorSet$ViewColor;", "background", "(Lcom/devbeans/io/chat/utils/color/ViewColorSet$ViewColor;Lcom/devbeans/io/chat/utils/color/ViewColorSet$ViewColor;)V", "getBackground", "()Lcom/devbeans/io/chat/utils/color/ViewColorSet$ViewColor;", "getForeground", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "ViewColor", "app_debug"})
public final class ViewColorSet implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull
    private final com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor foreground = null;
    @org.jetbrains.annotations.NotNull
    private final com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor background = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.color.ViewColorSet.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static final com.devbeans.io.chat.utils.color.ViewColorSet PRIMARY = null;
    public static final android.os.Parcelable.Creator<com.devbeans.io.chat.utils.color.ViewColorSet> CREATOR = null;
    
    /**
     * Represents a set of colors to be applied to the foreground and background of a view.
     *
     * Supports mixing color ints and color resource ids.
     */
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.utils.color.ViewColorSet copy(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor foreground, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor background) {
        return null;
    }
    
    /**
     * Represents a set of colors to be applied to the foreground and background of a view.
     *
     * Supports mixing color ints and color resource ids.
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Represents a set of colors to be applied to the foreground and background of a view.
     *
     * Supports mixing color ints and color resource ids.
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * Represents a set of colors to be applied to the foreground and background of a view.
     *
     * Supports mixing color ints and color resource ids.
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public ViewColorSet(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor foreground, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor background) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor getForeground() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor getBackground() {
        return null;
    }
    
    @java.lang.Override
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override
    public void writeToParcel(@org.jetbrains.annotations.NotNull
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.devbeans.io.chat.utils.color.ViewColorSet> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public final com.devbeans.io.chat.utils.color.ViewColorSet createFromParcel(@org.jetbrains.annotations.NotNull
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public final com.devbeans.io.chat.utils.color.ViewColorSet[] newArray(int size) {
            return null;
        }
    }
    
    @kotlinx.parcelize.Parcelize
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'\u0082\u0001\u0002\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/devbeans/io/chat/utils/color/ViewColorSet$ViewColor;", "Landroid/os/Parcelable;", "()V", "resolve", "", "context", "Landroid/content/Context;", "ColorResource", "ColorValue", "Lcom/devbeans/io/chat/utils/color/ViewColorSet$ViewColor$ColorResource;", "Lcom/devbeans/io/chat/utils/color/ViewColorSet$ViewColor$ColorValue;", "app_debug"})
    public static abstract class ViewColor implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor> CREATOR = null;
        
        private ViewColor() {
            super();
        }
        
        @androidx.annotation.ColorInt
        public abstract int resolve(@org.jetbrains.annotations.NotNull
        android.content.Context context);
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
        public static final class Creator implements android.os.Parcelable.Creator<com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor> {
            
            public Creator() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            @java.lang.Override
            public final com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor createFromParcel(@org.jetbrains.annotations.NotNull
            android.os.Parcel in) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            @java.lang.Override
            public final com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor[] newArray(int size) {
                return null;
            }
        }
        
        @kotlinx.parcelize.Parcelize
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\t\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0019"}, d2 = {"Lcom/devbeans/io/chat/utils/color/ViewColorSet$ViewColor$ColorValue;", "Lcom/devbeans/io/chat/utils/color/ViewColorSet$ViewColor;", "colorInt", "", "(I)V", "getColorInt", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "resolve", "context", "Landroid/content/Context;", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
        public static final class ColorValue extends com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor {
            private final int colorInt = 0;
            public static final android.os.Parcelable.Creator<com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor.ColorValue> CREATOR = null;
            
            @org.jetbrains.annotations.NotNull
            public final com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor.ColorValue copy(@androidx.annotation.ColorInt
            int colorInt) {
                return null;
            }
            
            @java.lang.Override
            public boolean equals(@org.jetbrains.annotations.Nullable
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull
            @java.lang.Override
            public java.lang.String toString() {
                return null;
            }
            
            public ColorValue(@androidx.annotation.ColorInt
            int colorInt) {
                super();
            }
            
            public final int component1() {
                return 0;
            }
            
            public final int getColorInt() {
                return 0;
            }
            
            @java.lang.Override
            public int resolve(@org.jetbrains.annotations.NotNull
            android.content.Context context) {
                return 0;
            }
            
            @java.lang.Override
            public int describeContents() {
                return 0;
            }
            
            @java.lang.Override
            public void writeToParcel(@org.jetbrains.annotations.NotNull
            android.os.Parcel parcel, int flags) {
            }
            
            @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
            public static final class Creator implements android.os.Parcelable.Creator<com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor.ColorValue> {
                
                public Creator() {
                    super();
                }
                
                @org.jetbrains.annotations.NotNull
                @java.lang.Override
                public final com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor.ColorValue createFromParcel(@org.jetbrains.annotations.NotNull
                android.os.Parcel in) {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull
                @java.lang.Override
                public final com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor.ColorValue[] newArray(int size) {
                    return null;
                }
            }
        }
        
        @kotlinx.parcelize.Parcelize
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\t\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0019"}, d2 = {"Lcom/devbeans/io/chat/utils/color/ViewColorSet$ViewColor$ColorResource;", "Lcom/devbeans/io/chat/utils/color/ViewColorSet$ViewColor;", "colorRes", "", "(I)V", "getColorRes", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "resolve", "context", "Landroid/content/Context;", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
        public static final class ColorResource extends com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor {
            private final int colorRes = 0;
            public static final android.os.Parcelable.Creator<com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor.ColorResource> CREATOR = null;
            
            @org.jetbrains.annotations.NotNull
            public final com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor.ColorResource copy(@androidx.annotation.ColorRes
            int colorRes) {
                return null;
            }
            
            @java.lang.Override
            public boolean equals(@org.jetbrains.annotations.Nullable
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull
            @java.lang.Override
            public java.lang.String toString() {
                return null;
            }
            
            public ColorResource(@androidx.annotation.ColorRes
            int colorRes) {
                super();
            }
            
            public final int component1() {
                return 0;
            }
            
            public final int getColorRes() {
                return 0;
            }
            
            @java.lang.Override
            public int resolve(@org.jetbrains.annotations.NotNull
            android.content.Context context) {
                return 0;
            }
            
            @java.lang.Override
            public int describeContents() {
                return 0;
            }
            
            @java.lang.Override
            public void writeToParcel(@org.jetbrains.annotations.NotNull
            android.os.Parcel parcel, int flags) {
            }
            
            @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
            public static final class Creator implements android.os.Parcelable.Creator<com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor.ColorResource> {
                
                public Creator() {
                    super();
                }
                
                @org.jetbrains.annotations.NotNull
                @java.lang.Override
                public final com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor.ColorResource createFromParcel(@org.jetbrains.annotations.NotNull
                android.os.Parcel in) {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull
                @java.lang.Override
                public final com.devbeans.io.chat.utils.color.ViewColorSet.ViewColor.ColorResource[] newArray(int size) {
                    return null;
                }
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/devbeans/io/chat/utils/color/ViewColorSet$Companion;", "", "()V", "PRIMARY", "Lcom/devbeans/io/chat/utils/color/ViewColorSet;", "getPRIMARY", "()Lcom/devbeans/io/chat/utils/color/ViewColorSet;", "forCustomColor", "customColor", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.color.ViewColorSet getPRIMARY() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.color.ViewColorSet forCustomColor(@androidx.annotation.ColorInt
        int customColor) {
            return null;
        }
    }
}