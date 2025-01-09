package com.devbeans.io.chat.utils.avatar;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003+,-B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J@\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u00152\b\b\u0001\u0010\u0017\u001a\u00020\u00152\b\b\u0001\u0010\u0018\u001a\u00020\u00152\b\b\u0001\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0007J,\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\'2\u0006\u0010\u001c\u001a\u00020\u00052\b\b\u0001\u0010(\u001a\u00020\u00152\b\b\u0001\u0010)\u001a\u00020\u0015H\u0007J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\'H\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006."}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/Avatars;", "", "()V", "colorMap", "", "", "Lcom/devbeans/io/chat/utils/avatar/Avatars$ColorPair;", "getColorMap", "()Ljava/util/Map;", "colors", "", "getColors", "()Ljava/util/List;", "defaultAvatarsForGroup", "Ljava/util/LinkedHashMap;", "Lcom/devbeans/io/chat/utils/avatar/Avatars$DefaultAvatar;", "getDefaultAvatarsForGroup", "()Ljava/util/LinkedHashMap;", "defaultAvatarsForSelf", "getDefaultAvatarsForSelf", "branchSizes", "", "lastFontSize", "fontSize", "target", "maxFontSize", "paint", "Landroid/graphics/Paint;", "text", "getDrawableResource", "", "key", "(Ljava/lang/String;)Ljava/lang/Integer;", "getForegroundColor", "Lcom/devbeans/io/chat/utils/avatar/Avatars$ForegroundColor;", "avatarColor", "Lcom/devbeans/io/chat/utils/avatar/AvatarColor;", "getTextSizeForLength", "context", "Landroid/content/Context;", "maxWidth", "maxSize", "textPaint", "ColorPair", "DefaultAvatar", "ForegroundColor", "app_debug"})
public final class Avatars {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.avatar.Avatars INSTANCE = null;
    
    /**
     * Mapping which associates color codes to ColorPair objects containing background and foreground colors.
     */
    @org.jetbrains.annotations.NotNull
    private static final java.util.Map<java.lang.String, com.devbeans.io.chat.utils.avatar.Avatars.ColorPair> colorMap = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<com.devbeans.io.chat.utils.avatar.Avatars.ColorPair> colors = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.LinkedHashMap<java.lang.String, com.devbeans.io.chat.utils.avatar.Avatars.DefaultAvatar> defaultAvatarsForSelf = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.LinkedHashMap<java.lang.String, com.devbeans.io.chat.utils.avatar.Avatars.DefaultAvatar> defaultAvatarsForGroup = null;
    
    private Avatars() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, com.devbeans.io.chat.utils.avatar.Avatars.ColorPair> getColorMap() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.devbeans.io.chat.utils.avatar.Avatars.ColorPair> getColors() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.LinkedHashMap<java.lang.String, com.devbeans.io.chat.utils.avatar.Avatars.DefaultAvatar> getDefaultAvatarsForSelf() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.LinkedHashMap<java.lang.String, com.devbeans.io.chat.utils.avatar.Avatars.DefaultAvatar> getDefaultAvatarsForGroup() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @androidx.annotation.DrawableRes
    public final java.lang.Integer getDrawableResource(@org.jetbrains.annotations.NotNull
    java.lang.String key) {
        return null;
    }
    
    private final android.graphics.Paint textPaint(android.content.Context context) {
        return null;
    }
    
    /**
     * Calculate the text size for a give string using a maximum desired width and a maximum desired font size.
     */
    @kotlin.jvm.JvmStatic
    public static final float getTextSizeForLength(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String text, @androidx.annotation.Px
    float maxWidth, @androidx.annotation.Px
    float maxSize) {
        return 0.0F;
    }
    
    /**
     * Uses binary search to determine optimal font size to within 1% given the input parameters.
     */
    private final float branchSizes(@androidx.annotation.Px
    float lastFontSize, @androidx.annotation.Px
    float fontSize, @androidx.annotation.Px
    float target, @androidx.annotation.Px
    float maxFontSize, android.graphics.Paint paint, java.lang.String text) {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final com.devbeans.io.chat.utils.avatar.Avatars.ForegroundColor getForegroundColor(@org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.avatar.AvatarColor avatarColor) {
        return null;
    }
    
    /**
     * Enum class mirroring AvatarColors codes but utilizing foreground colors for text or icon tinting.
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\n\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/Avatars$ForegroundColor;", "", "code", "", "colorInt", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getColorInt", "()I", "deserialize", "serialize", "A100", "A110", "A120", "A130", "A140", "A150", "A160", "A170", "A180", "A190", "A200", "A210", "A212", "app_debug"})
    public static enum ForegroundColor {
        /*public static final*/ A100 /* = new A100(null, 0) */,
        /*public static final*/ A110 /* = new A110(null, 0) */,
        /*public static final*/ A120 /* = new A120(null, 0) */,
        /*public static final*/ A130 /* = new A130(null, 0) */,
        /*public static final*/ A140 /* = new A140(null, 0) */,
        /*public static final*/ A150 /* = new A150(null, 0) */,
        /*public static final*/ A160 /* = new A160(null, 0) */,
        /*public static final*/ A170 /* = new A170(null, 0) */,
        /*public static final*/ A180 /* = new A180(null, 0) */,
        /*public static final*/ A190 /* = new A190(null, 0) */,
        /*public static final*/ A200 /* = new A200(null, 0) */,
        /*public static final*/ A210 /* = new A210(null, 0) */,
        /*public static final*/ A212 /* = new A212(null, 0) */;
        private final java.lang.String code = null;
        private final int colorInt = 0;
        
        ForegroundColor(java.lang.String code, @androidx.annotation.ColorInt
        int colorInt) {
        }
        
        public final int getColorInt() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatars.ForegroundColor deserialize(@org.jetbrains.annotations.NotNull
        java.lang.String code) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String serialize() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/Avatars$DefaultAvatar;", "", "vectorDrawableId", "", "colorCode", "", "(ILjava/lang/String;)V", "getColorCode", "()Ljava/lang/String;", "getVectorDrawableId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class DefaultAvatar {
        @com.google.gson.annotations.SerializedName(value = "vectorDrawableId")
        private final int vectorDrawableId = 0;
        @org.jetbrains.annotations.NotNull
        @com.google.gson.annotations.SerializedName(value = "colorCode")
        private final java.lang.String colorCode = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatars.DefaultAvatar copy(@androidx.annotation.DrawableRes
        int vectorDrawableId, @org.jetbrains.annotations.NotNull
        java.lang.String colorCode) {
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
        
        public DefaultAvatar(@androidx.annotation.DrawableRes
        int vectorDrawableId, @org.jetbrains.annotations.NotNull
        java.lang.String colorCode) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int getVectorDrawableId() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getColorCode() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B!\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0012\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0013\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u000bH\u00c6\u0003J\'\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u000bH\u00d6\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/Avatars$ColorPair;", "", "backgroundAvatarColor", "Lcom/devbeans/io/chat/utils/avatar/AvatarColor;", "foregroundAvatarColor", "Lcom/devbeans/io/chat/utils/avatar/Avatars$ForegroundColor;", "(Lcom/devbeans/io/chat/utils/avatar/AvatarColor;Lcom/devbeans/io/chat/utils/avatar/Avatars$ForegroundColor;)V", "backgroundColor", "", "foregroundColor", "code", "", "(IILjava/lang/String;)V", "getBackgroundColor", "()I", "getCode", "()Ljava/lang/String;", "getForegroundColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class ColorPair {
        @com.google.gson.annotations.SerializedName(value = "backgroundColor")
        private final int backgroundColor = 0;
        @com.google.gson.annotations.SerializedName(value = "foregroundColor")
        private final int foregroundColor = 0;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String code = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.Avatars.ColorPair copy(@androidx.annotation.ColorInt
        int backgroundColor, @androidx.annotation.ColorInt
        int foregroundColor, @org.jetbrains.annotations.NotNull
        java.lang.String code) {
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
        
        public ColorPair(@androidx.annotation.ColorInt
        int backgroundColor, @androidx.annotation.ColorInt
        int foregroundColor, @org.jetbrains.annotations.NotNull
        java.lang.String code) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int getBackgroundColor() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int getForegroundColor() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCode() {
            return null;
        }
        
        public ColorPair(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.AvatarColor backgroundAvatarColor, @org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.avatar.Avatars.ForegroundColor foregroundAvatarColor) {
            super();
        }
    }
}