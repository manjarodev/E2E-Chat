package com.devbeans.io.chat.utils.avatar;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u0012\u0010\f\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0010X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/devbeans/io/chat/utils/avatar/EmojiData;", "", "dataPages", "", "Lcom/devbeans/io/chat/utils/avatar/EmojiPageModel;", "getDataPages", "()Ljava/util/List;", "densities", "", "getDensities", "displayPages", "getDisplayPages", "format", "getFormat", "()Ljava/lang/String;", "jumboPages", "", "getJumboPages", "()Ljava/util/Map;", "obsolete", "Lcom/devbeans/io/chat/utils/avatar/ObsoleteEmoji;", "getObsolete", "app_debug"})
public abstract interface EmojiData {
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<java.lang.String> getDensities();
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getFormat();
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.devbeans.io.chat.utils.avatar.EmojiPageModel> getDisplayPages();
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.devbeans.io.chat.utils.avatar.EmojiPageModel> getDataPages();
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.Map<java.lang.String, java.lang.String> getJumboPages();
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.devbeans.io.chat.utils.avatar.ObsoleteEmoji> getObsolete();
}