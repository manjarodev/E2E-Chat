package com.devbeans.io.chat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007J\f\u0010\t\u001a\u00020\u0007*\u00020\u0007H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/devbeans/io/chat/utils/NameUtil;", "", "()V", "PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getAbbreviation", "", "name", "firstGrapheme", "app_debug"})
public final class NameUtil {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.NameUtil INSTANCE = null;
    
    /**
     * \p{L} is letter, \p{Nd} is digit, \p{S} is whitespace/separator
     * https://www.regular-expressions.info/unicode.html#category
     */
    private static final java.util.regex.Pattern PATTERN = null;
    
    private NameUtil() {
        super();
    }
    
    /**
     * Returns an abbreviation of the input, up to two characters long.
     */
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmStatic
    public static final java.lang.String getAbbreviation(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
        return null;
    }
    
    private final java.lang.String firstGrapheme(java.lang.String $this$firstGrapheme) {
        return null;
    }
}