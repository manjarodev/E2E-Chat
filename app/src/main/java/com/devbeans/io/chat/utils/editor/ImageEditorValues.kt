package com.devbeans.io.chat.utils.editor

import com.devbeans.io.chat.app.AppSession

internal class ImageEditorValues {

    companion object {
        private const val KEY_IMAGE_EDITOR_MARKER_WIDTH = "image.editor.marker.width"
        private const val KEY_IMAGE_EDITOR_HIGHLIGHTER_WIDTH = "image.editor.highlighter.width"
        private const val KEY_IMAGE_EDITOR_BLUR_WIDTH = "image.editor.blur.width"
    }


    fun setMarkerPercentage(markerPercentage: Int) {
        AppSession.put(KEY_IMAGE_EDITOR_MARKER_WIDTH, markerPercentage)
    }

    fun setHighlighterPercentage(highlighterPercentage: Int) {
        AppSession.put(KEY_IMAGE_EDITOR_HIGHLIGHTER_WIDTH, highlighterPercentage)
    }

    fun setBlurPercentage(blurPercentage: Int) {
        AppSession.put(KEY_IMAGE_EDITOR_BLUR_WIDTH, blurPercentage)
    }

    fun getMarkerPercentage(): Int = AppSession.getInt(KEY_IMAGE_EDITOR_MARKER_WIDTH, 0)

    fun getHighlighterPercentage(): Int = AppSession.getInt(KEY_IMAGE_EDITOR_HIGHLIGHTER_WIDTH, 0)

    fun getBlurPercentage(): Int = AppSession.getInt(KEY_IMAGE_EDITOR_BLUR_WIDTH, 0)

    fun getMarkerWidthRange(): Pair<Float, Float> = Pair(0.01f, 0.05f)

    fun getHighlighterWidthRange(): Pair<Float, Float> = Pair(0.03f, 0.08f)

    fun getBlurWidthRange(): Pair<Float, Float> = Pair(0.052f, 0.092f)
}
