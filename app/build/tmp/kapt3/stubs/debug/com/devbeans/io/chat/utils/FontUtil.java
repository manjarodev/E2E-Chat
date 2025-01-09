package com.devbeans.io.chat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/utils/FontUtil;", "", "()V", "SAMPLE_EMOJI", "", "canRenderEmojiAtFontSize", "", "size", "", "app_debug"})
public final class FontUtil {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.FontUtil INSTANCE = null;
    private static final java.lang.String SAMPLE_EMOJI = "\ud83c\udf0d";
    
    private FontUtil() {
        super();
    }
    
    /**
     * Certain platforms cannot render emoji above a certain font size.
     *
     * This will attempt to render an emoji at the specified font size and tell you if it's possible.
     * It does this by rendering an emoji into a 1x1 bitmap and seeing if the resulting pixel is non-transparent.
     *
     * https://stackoverflow.com/a/50988748
     */
    @kotlin.jvm.JvmStatic
    public static final boolean canRenderEmojiAtFontSize(float size) {
        return false;
    }
}