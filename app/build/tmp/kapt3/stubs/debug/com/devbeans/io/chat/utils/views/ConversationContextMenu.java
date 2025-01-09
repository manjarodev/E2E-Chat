package com.devbeans.io.chat.utils.views;

import java.lang.System;

/**
 * The context menu shown after long pressing a message in ConversationActivity.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/devbeans/io/chat/utils/views/ConversationContextMenu;", "Landroid/widget/PopupWindow;", "anchor", "Landroid/view/View;", "items", "", "Lcom/devbeans/io/chat/utils/views/ActionItem;", "(Landroid/view/View;Ljava/util/List;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "contextMenuList", "Lcom/devbeans/io/chat/utils/views/ContextMenuList;", "getMaxHeight", "", "getMaxWidth", "show", "", "offsetX", "offsetY", "app_debug"})
public final class ConversationContextMenu extends android.widget.PopupWindow {
    private final android.view.View anchor = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    private final com.devbeans.io.chat.utils.views.ContextMenuList contextMenuList = null;
    
    public ConversationContextMenu(@org.jetbrains.annotations.NotNull
    android.view.View anchor, @org.jetbrains.annotations.NotNull
    java.util.List<com.devbeans.io.chat.utils.views.ActionItem> items) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    public final int getMaxWidth() {
        return 0;
    }
    
    public final int getMaxHeight() {
        return 0;
    }
    
    public final void show(int offsetX, int offsetY) {
    }
}