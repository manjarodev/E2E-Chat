package com.devbeans.io.chat.utils.components.menu;

import java.lang.System;

/**
 * A custom context menu that will show next to an anchor view and display several options. Basically a PopupMenu with custom UI and positioning rules.
 *
 * This will prefer showing the menu underneath the anchor, but if there's not enough space in the container, it will show it above the anchor and reverse the
 * order of the menu items. If there's not enough room for either, it'll show it centered above the anchor. If there's not enough room then, it'll center it,
 * chop off the part that doesn't fit, and make the menu scrollable.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0003)*+BY\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0002\u0010\u0012J\b\u0010(\u001a\u00020\u0000H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'\u00a8\u0006,"}, d2 = {"Lcom/devbeans/io/chat/utils/components/menu/ChatContextMenu;", "Landroid/widget/PopupWindow;", "anchor", "Landroid/view/View;", "container", "Landroid/view/ViewGroup;", "items", "", "Lcom/devbeans/io/chat/utils/views/ActionItem;", "baseOffsetX", "", "baseOffsetY", "horizontalPosition", "Lcom/devbeans/io/chat/utils/components/menu/ChatContextMenu$HorizontalPosition;", "verticalPosition", "Lcom/devbeans/io/chat/utils/components/menu/ChatContextMenu$VerticalPosition;", "onDismiss", "Ljava/lang/Runnable;", "(Landroid/view/View;Landroid/view/ViewGroup;Ljava/util/List;IILcom/devbeans/io/chat/utils/components/menu/ChatContextMenu$HorizontalPosition;Lcom/devbeans/io/chat/utils/components/menu/ChatContextMenu$VerticalPosition;Ljava/lang/Runnable;)V", "getAnchor", "()Landroid/view/View;", "getBaseOffsetX", "()I", "getBaseOffsetY", "getContainer", "()Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "contextMenuList", "Lcom/devbeans/io/chat/utils/views/ContextMenuList;", "getHorizontalPosition", "()Lcom/devbeans/io/chat/utils/components/menu/ChatContextMenu$HorizontalPosition;", "getItems", "()Ljava/util/List;", "getOnDismiss", "()Ljava/lang/Runnable;", "getVerticalPosition", "()Lcom/devbeans/io/chat/utils/components/menu/ChatContextMenu$VerticalPosition;", "show", "Builder", "HorizontalPosition", "VerticalPosition", "app_debug"})
public final class ChatContextMenu extends android.widget.PopupWindow {
    @org.jetbrains.annotations.NotNull
    private final android.view.View anchor = null;
    @org.jetbrains.annotations.NotNull
    private final android.view.ViewGroup container = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.devbeans.io.chat.utils.views.ActionItem> items = null;
    private final int baseOffsetX = 0;
    private final int baseOffsetY = 0;
    @org.jetbrains.annotations.NotNull
    private final com.devbeans.io.chat.utils.components.menu.ChatContextMenu.HorizontalPosition horizontalPosition = null;
    @org.jetbrains.annotations.NotNull
    private final com.devbeans.io.chat.utils.components.menu.ChatContextMenu.VerticalPosition verticalPosition = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Runnable onDismiss = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    private final com.devbeans.io.chat.utils.views.ContextMenuList contextMenuList = null;
    
    private ChatContextMenu(android.view.View anchor, android.view.ViewGroup container, java.util.List<com.devbeans.io.chat.utils.views.ActionItem> items, int baseOffsetX, int baseOffsetY, com.devbeans.io.chat.utils.components.menu.ChatContextMenu.HorizontalPosition horizontalPosition, com.devbeans.io.chat.utils.components.menu.ChatContextMenu.VerticalPosition verticalPosition, java.lang.Runnable onDismiss) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.view.View getAnchor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.view.ViewGroup getContainer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.devbeans.io.chat.utils.views.ActionItem> getItems() {
        return null;
    }
    
    public final int getBaseOffsetX() {
        return 0;
    }
    
    public final int getBaseOffsetY() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.utils.components.menu.ChatContextMenu.HorizontalPosition getHorizontalPosition() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.devbeans.io.chat.utils.components.menu.ChatContextMenu.VerticalPosition getVerticalPosition() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Runnable getOnDismiss() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    private final com.devbeans.io.chat.utils.components.menu.ChatContextMenu show() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/devbeans/io/chat/utils/components/menu/ChatContextMenu$HorizontalPosition;", "", "(Ljava/lang/String;I)V", "START", "END", "app_debug"})
    public static enum HorizontalPosition {
        /*public static final*/ START /* = new START() */,
        /*public static final*/ END /* = new END() */;
        
        HorizontalPosition() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/devbeans/io/chat/utils/components/menu/ChatContextMenu$VerticalPosition;", "", "(Ljava/lang/String;I)V", "ABOVE", "BELOW", "app_debug"})
    public static enum VerticalPosition {
        /*public static final*/ ABOVE /* = new ABOVE() */,
        /*public static final*/ BELOW /* = new BELOW() */;
        
        VerticalPosition() {
        }
    }
    
    /**
     * @param anchor The view to put the pop-up on
     * @param container A parent of [anchor] that represents the acceptable boundaries of the popup
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/devbeans/io/chat/utils/components/menu/ChatContextMenu$Builder;", "", "anchor", "Landroid/view/View;", "container", "Landroid/view/ViewGroup;", "(Landroid/view/View;Landroid/view/ViewGroup;)V", "getAnchor", "()Landroid/view/View;", "getContainer", "()Landroid/view/ViewGroup;", "horizontalPosition", "Lcom/devbeans/io/chat/utils/components/menu/ChatContextMenu$HorizontalPosition;", "offsetX", "", "offsetY", "onDismiss", "Ljava/lang/Runnable;", "verticalPosition", "Lcom/devbeans/io/chat/utils/components/menu/ChatContextMenu$VerticalPosition;", "offsetPx", "preferredHorizontalPosition", "preferredVerticalPosition", "show", "Lcom/devbeans/io/chat/utils/components/menu/ChatContextMenu;", "items", "", "Lcom/devbeans/io/chat/utils/views/ActionItem;", "app_debug"})
    public static final class Builder {
        @org.jetbrains.annotations.NotNull
        private final android.view.View anchor = null;
        @org.jetbrains.annotations.NotNull
        private final android.view.ViewGroup container = null;
        private java.lang.Runnable onDismiss;
        private int offsetX = 0;
        private int offsetY = 0;
        private com.devbeans.io.chat.utils.components.menu.ChatContextMenu.HorizontalPosition horizontalPosition = com.devbeans.io.chat.utils.components.menu.ChatContextMenu.HorizontalPosition.START;
        private com.devbeans.io.chat.utils.components.menu.ChatContextMenu.VerticalPosition verticalPosition = com.devbeans.io.chat.utils.components.menu.ChatContextMenu.VerticalPosition.BELOW;
        
        public Builder(@org.jetbrains.annotations.NotNull
        android.view.View anchor, @org.jetbrains.annotations.NotNull
        android.view.ViewGroup container) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.view.View getAnchor() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.view.ViewGroup getContainer() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.components.menu.ChatContextMenu.Builder onDismiss(@org.jetbrains.annotations.NotNull
        java.lang.Runnable onDismiss) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.components.menu.ChatContextMenu.Builder offsetX(int offsetPx) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.components.menu.ChatContextMenu.Builder offsetY(int offsetPx) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.components.menu.ChatContextMenu.Builder preferredHorizontalPosition(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.components.menu.ChatContextMenu.HorizontalPosition horizontalPosition) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.components.menu.ChatContextMenu.Builder preferredVerticalPosition(@org.jetbrains.annotations.NotNull
        com.devbeans.io.chat.utils.components.menu.ChatContextMenu.VerticalPosition verticalPosition) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.devbeans.io.chat.utils.components.menu.ChatContextMenu show(@org.jetbrains.annotations.NotNull
        java.util.List<com.devbeans.io.chat.utils.views.ActionItem> items) {
            return null;
        }
    }
}