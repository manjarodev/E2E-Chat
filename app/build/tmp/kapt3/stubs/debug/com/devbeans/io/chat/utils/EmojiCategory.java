package com.devbeans.io.chat.utils;

import java.lang.System;

/**
 * All the different Emoji categories the app is aware of in the order we want to display them.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u0003H\u0007R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/devbeans/io/chat/utils/EmojiCategory;", "", "priority", "", "key", "", "icon", "(Ljava/lang/String;IILjava/lang/String;I)V", "getIcon", "()I", "getKey", "()Ljava/lang/String;", "getPriority", "getCategoryLabel", "PEOPLE", "NATURE", "FOODS", "ACTIVITY", "PLACES", "OBJECTS", "SYMBOLS", "FLAGS", "EMOTICONS", "Companion", "app_debug"})
public enum EmojiCategory {
    /*public static final*/ PEOPLE /* = new PEOPLE(0, null, 0) */,
    /*public static final*/ NATURE /* = new NATURE(0, null, 0) */,
    /*public static final*/ FOODS /* = new FOODS(0, null, 0) */,
    /*public static final*/ ACTIVITY /* = new ACTIVITY(0, null, 0) */,
    /*public static final*/ PLACES /* = new PLACES(0, null, 0) */,
    /*public static final*/ OBJECTS /* = new OBJECTS(0, null, 0) */,
    /*public static final*/ SYMBOLS /* = new SYMBOLS(0, null, 0) */,
    /*public static final*/ FLAGS /* = new FLAGS(0, null, 0) */,
    /*public static final*/ EMOTICONS /* = new EMOTICONS(0, null, 0) */;
    private final int priority = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String key = null;
    private final int icon = 0;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.EmojiCategory.Companion Companion = null;
    
    EmojiCategory(int priority, java.lang.String key, @androidx.annotation.AttrRes
    int icon) {
    }
    
    public final int getPriority() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKey() {
        return null;
    }
    
    public final int getIcon() {
        return 0;
    }
    
    @androidx.annotation.StringRes
    public final int getCategoryLabel() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final com.devbeans.io.chat.utils.EmojiCategory forKey(@org.jetbrains.annotations.NotNull
    java.lang.String key) {
        return null;
    }
    
    @androidx.annotation.StringRes
    @kotlin.jvm.JvmStatic
    public static final int getCategoryLabel(@androidx.annotation.AttrRes
    int iconAttr) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH\u0007\u00a8\u0006\n"}, d2 = {"Lcom/devbeans/io/chat/utils/EmojiCategory$Companion;", "", "()V", "forKey", "Lcom/devbeans/io/chat/utils/EmojiCategory;", "key", "", "getCategoryLabel", "", "iconAttr", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @kotlin.jvm.JvmStatic
        public final com.devbeans.io.chat.utils.EmojiCategory forKey(@org.jetbrains.annotations.NotNull
        java.lang.String key) {
            return null;
        }
        
        @androidx.annotation.StringRes
        @kotlin.jvm.JvmStatic
        public final int getCategoryLabel(@androidx.annotation.AttrRes
        int iconAttr) {
            return 0;
        }
    }
}