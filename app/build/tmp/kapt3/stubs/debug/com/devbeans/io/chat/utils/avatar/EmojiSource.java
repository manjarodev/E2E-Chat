package com.devbeans.io.chat.utils.avatar;

import java.lang.System;

/**
 * The entry point for the application to request Emoji data for custom emojis.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u00012B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t\u00a2\u0006\u0002\u0010\nR-\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u000e0\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u000eX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\u001f\u0010 R\u0012\u0010\"\u001a\u00020\rX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u001e\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0010R\u001b\u0010\'\u001a\u00020(8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010\u0012\u001a\u0004\b)\u0010*R\u0018\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u000eX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b.\u0010\u0016R\'\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010\u0012\u001a\u0004\b0\u0010\u0010\u00a8\u00063"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/EmojiSource;", "Lcom/devbeans/io/chat/utils/avatar/EmojiData;", "decodeScale", "", "emojiData", "emojiPageFactory", "Lkotlin/Function1;", "Landroid/net/Uri;", "Lcom/devbeans/io/chat/utils/avatar/EmojiPage;", "Lcom/devbeans/io/chat/utils/avatar/EmojiPageFactory;", "(FLcom/devbeans/io/chat/utils/avatar/EmojiData;Lkotlin/jvm/functions/Function1;)V", "canonicalToVariations", "", "", "", "getCanonicalToVariations", "()Ljava/util/Map;", "canonicalToVariations$delegate", "Lkotlin/Lazy;", "dataPages", "Lcom/devbeans/io/chat/utils/avatar/EmojiPageModel;", "getDataPages", "()Ljava/util/List;", "getDecodeScale", "()F", "densities", "getDensities", "displayPages", "getDisplayPages", "emojiTree", "Lcom/devbeans/io/chat/utils/avatar/EmojiTree;", "getEmojiTree", "()Lcom/devbeans/io/chat/utils/avatar/EmojiTree;", "emojiTree$delegate", "format", "getFormat", "()Ljava/lang/String;", "jumboPages", "getJumboPages", "maxEmojiLength", "", "getMaxEmojiLength", "()I", "maxEmojiLength$delegate", "obsolete", "Lcom/devbeans/io/chat/utils/avatar/ObsoleteEmoji;", "getObsolete", "variationsToCanonical", "getVariationsToCanonical", "variationsToCanonical$delegate", "Companion", "app_debug"})
public final class EmojiSource implements com.devbeans.io.chat.utils.avatar.EmojiData {
    private final float decodeScale = 0.0F;
    private final com.devbeans.io.chat.utils.avatar.EmojiData emojiData = null;
    private final kotlin.jvm.functions.Function1<android.net.Uri, com.devbeans.io.chat.utils.avatar.EmojiPage> emojiPageFactory = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy variationsToCanonical$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy canonicalToVariations$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy maxEmojiLength$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy emojiTree$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.avatar.EmojiSource.Companion Companion = null;
    private static final java.util.concurrent.atomic.AtomicReference<com.devbeans.io.chat.utils.avatar.EmojiSource> emojiSource = null;
    private static final java.util.concurrent.CountDownLatch emojiLatch = null;
    
    public EmojiSource(float decodeScale, @org.jetbrains.annotations.NotNull
    com.devbeans.io.chat.utils.avatar.EmojiData emojiData, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super android.net.Uri, ? extends com.devbeans.io.chat.utils.avatar.EmojiPage> emojiPageFactory) {
        super();
    }
    
    public final float getDecodeScale() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.String> getVariationsToCanonical() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> getCanonicalToVariations() {
        return null;
    }
    
    public final int getMaxEmojiLength() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.utils.avatar.EmojiTree getEmojiTree() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final com.devbeans.io.chat.utils.avatar.EmojiSource getLatest() {
        return null;
    }
    
    @androidx.annotation.WorkerThread
    @kotlin.jvm.JvmStatic
    public static final void refresh() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.util.List<java.lang.String> getDensities() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String getFormat() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.util.List<com.devbeans.io.chat.utils.avatar.EmojiPageModel> getDisplayPages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.util.List<com.devbeans.io.chat.utils.avatar.EmojiPageModel> getDataPages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.util.Map<java.lang.String, java.lang.String> getJumboPages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.util.List<com.devbeans.io.chat.utils.avatar.ObsoleteEmoji> getObsolete() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00078FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/EmojiSource$Companion;", "", "()V", "emojiLatch", "Ljava/util/concurrent/CountDownLatch;", "emojiSource", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/devbeans/io/chat/utils/avatar/EmojiSource;", "latest", "getLatest$annotations", "getLatest", "()Lcom/devbeans/io/chat/utils/avatar/EmojiSource;", "getEmojiSource", "loadAssetBasedEmojis", "loadRemoteBasedEmojis", "refresh", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.jvm.JvmStatic
        @java.lang.Deprecated
        public static void getLatest$annotations() {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.avatar.EmojiSource getLatest() {
            return null;
        }
        
        @androidx.annotation.WorkerThread
        @kotlin.jvm.JvmStatic
        public final void refresh() {
        }
        
        private final com.devbeans.io.chat.utils.avatar.EmojiSource getEmojiSource() {
            return null;
        }
        
        private final com.devbeans.io.chat.utils.avatar.EmojiSource loadRemoteBasedEmojis() {
            return null;
        }
        
        private final com.devbeans.io.chat.utils.avatar.EmojiSource loadAssetBasedEmojis() {
            return null;
        }
    }
}