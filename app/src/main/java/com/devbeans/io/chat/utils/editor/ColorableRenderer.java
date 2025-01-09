package com.devbeans.io.chat.utils.editor;

import androidx.annotation.ColorInt;

import com.devbeans.io.chat.utils.Renderer;

/**
 * A renderer that can have its color changed.
 * <p>
 * For example, Lines and Text can change color.
 */
public interface ColorableRenderer extends Renderer {

    @ColorInt
    int getColor();

    void setColor(@ColorInt int color);
}
