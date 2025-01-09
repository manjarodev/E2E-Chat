package com.devbeans.io.chat.utils.editor;

import java.lang.System;

/**
 * Renderer that can maintain a "selected" state
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/devbeans/io/chat/utils/editor/SelectableRenderer;", "Lcom/devbeans/io/chat/utils/Renderer;", "getSelectionBounds", "", "bounds", "Landroid/graphics/RectF;", "onSelected", "selected", "", "app_debug"})
public abstract interface SelectableRenderer extends com.devbeans.io.chat.utils.Renderer {
    
    public abstract void onSelected(boolean selected);
    
    /**
     * Get the sub bounds in local coordinates in case the selection should be shown smaller than full bounds
     */
    public abstract void getSelectionBounds(@org.jetbrains.annotations.NotNull
    android.graphics.RectF bounds);
}