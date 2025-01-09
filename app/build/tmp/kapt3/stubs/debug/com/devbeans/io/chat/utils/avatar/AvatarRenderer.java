package com.devbeans.io.chat.utils.avatar;

import java.lang.System;

/**
 * Renders Avatar objects into Media objects. This can involve creating a Bitmap, depending on the
 * type of Avatar passed to `renderAvatar`
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J6\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0007J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nJ@\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u00172\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u00140\u0017J,\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u001c2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u0017H\u0002JB\u0010\u001d\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u00172\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u00140\u0017H\u0002JB\u0010\u001e\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u001f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u00172\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u00140\u0017H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006 "}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/AvatarRenderer;", "", "()V", "DIMENSIONS", "", "getDIMENSIONS", "()I", "createTextDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "avatar", "Lcom/devbeans/io/chat/utils/avatar/Avatar$Text;", "inverted", "", "size", "synchronous", "getTypeface", "Landroid/graphics/Typeface;", "renderAvatar", "", "Lcom/devbeans/io/chat/utils/avatar/Avatar;", "onAvatarRendered", "Lkotlin/Function1;", "Lcom/devbeans/io/chat/models/Media;", "onRenderFailed", "", "renderPhoto", "Lcom/devbeans/io/chat/utils/avatar/Avatar$Photo;", "renderText", "renderVector", "Lcom/devbeans/io/chat/utils/avatar/Avatar$Vector;", "app_debug"})
public final class AvatarRenderer {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.avatar.AvatarRenderer INSTANCE = null;
    private static final int DIMENSIONS = 0;
    
    private AvatarRenderer() {
        super();
    }
    
    public final int getDIMENSIONS() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.graphics.Typeface getTypeface(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    public final void renderAvatar(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.avatar.Avatar avatar, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.devbeans.io.chat.models.Media, kotlin.Unit> onAvatarRendered, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onRenderFailed) {
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final android.graphics.drawable.Drawable createTextDrawable(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.avatar.Avatar.Text avatar, boolean inverted, int size, boolean synchronous) {
        return null;
    }
    
    private final void renderVector(android.content.Context context, com.devbeans.io.chat.utils.avatar.Avatar.Vector avatar, kotlin.jvm.functions.Function1<? super com.devbeans.io.chat.models.Media, kotlin.Unit> onAvatarRendered, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onRenderFailed) {
    }
    
    private final void renderText(android.content.Context context, com.devbeans.io.chat.utils.avatar.Avatar.Text avatar, kotlin.jvm.functions.Function1<? super com.devbeans.io.chat.models.Media, kotlin.Unit> onAvatarRendered, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onRenderFailed) {
    }
    
    private final void renderPhoto(android.content.Context context, com.devbeans.io.chat.utils.avatar.Avatar.Photo avatar, kotlin.jvm.functions.Function1<? super com.devbeans.io.chat.models.Media, kotlin.Unit> onAvatarRendered) {
    }
}