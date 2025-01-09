package com.devbeans.io.chat.utils.avatar;

import java.lang.System;

/**
 * Takes an emoji_data.json file data and parses it into an EmojiSource
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JD\u0010\u0005\u001a\u00020\u00062:\u0010\u0007\u001a6\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\bj\u0002`\u000fH\u0002J`\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0012\u001a\u00020\u00132:\u0010\u0007\u001a6\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\bj\u0002`\u000f\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/EmojiJsonParser;", "", "()V", "ESTIMATED_EMOJI_COUNT", "", "buildEmojiSourceFromNode", "Lcom/devbeans/io/chat/utils/avatar/ParsedEmojiData;", "uriFactory", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "sprite", "format", "Landroid/net/Uri;", "Lcom/devbeans/io/chat/utils/avatar/UriFactory;", "parse", "Lkotlin/Result;", "body", "Ljava/io/InputStream;", "parse-gIAlu-s", "(Ljava/io/InputStream;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "verify", "", "app_debug"})
public final class EmojiJsonParser {
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.avatar.EmojiJsonParser INSTANCE = null;
    private static final int ESTIMATED_EMOJI_COUNT = 3500;
    
    private EmojiJsonParser() {
        super();
    }
    
    @kotlin.jvm.JvmStatic
    public static final void verify(@org.jetbrains.annotations.NotNull
    java.io.InputStream body) {
    }
    
    private final com.devbeans.io.chat.utils.avatar.ParsedEmojiData buildEmojiSourceFromNode(kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, ? extends android.net.Uri> uriFactory) {
        return null;
    }
}