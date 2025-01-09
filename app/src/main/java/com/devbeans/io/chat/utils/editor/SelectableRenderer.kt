package com.devbeans.io.chat.utils.editor

import android.graphics.RectF
import com.devbeans.io.chat.utils.Renderer

/**
 * Renderer that can maintain a "selected" state
 */
interface SelectableRenderer : Renderer {
    fun onSelected(selected: Boolean)

    /**
     * Get the sub bounds in local coordinates in case the selection should be shown smaller than full bounds
     */
    fun getSelectionBounds(bounds: RectF)
}
