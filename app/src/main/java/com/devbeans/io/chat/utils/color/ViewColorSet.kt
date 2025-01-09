package com.devbeans.io.chat.utils.color

import android.content.Context
import android.os.Parcelable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.devbeans.io.chat.R
import kotlinx.parcelize.Parcelize

/**
 * Represents a set of colors to be applied to the foreground and background of a view.
 *
 * Supports mixing color ints and color resource ids.
 */
@Parcelize
data class ViewColorSet(
  val foreground: ViewColor,
  val background: ViewColor
) : Parcelable {
  companion object {
    val PRIMARY = ViewColorSet(
      foreground = ViewColor.ColorResource(R.color.white),
      background = ViewColor.ColorResource(R.color.colorPrimary)
    )

    fun forCustomColor(@ColorInt customColor: Int): ViewColorSet {
      return ViewColorSet(
        foreground = ViewColor.ColorResource(R.color.white),
        background = ViewColor.ColorValue(customColor)
      )
    }
  }

  @Parcelize
  sealed class ViewColor : Parcelable {

    @ColorInt
    abstract fun resolve(context: Context): Int

    @Parcelize
    data class ColorValue(@ColorInt val colorInt: Int) : ViewColor() {
      override fun resolve(context: Context): Int {
        return colorInt
      }
    }

    @Parcelize
    data class ColorResource(@ColorRes val colorRes: Int) : ViewColor() {
      override fun resolve(context: Context): Int {
        return ContextCompat.getColor(context, colorRes)
      }
    }
  }
}
