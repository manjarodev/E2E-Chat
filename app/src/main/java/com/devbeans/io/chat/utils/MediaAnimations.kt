package com.devbeans.io.chat.utils

import android.view.animation.Interpolator
import androidx.interpolator.view.animation.FastOutSlowInInterpolator

object MediaAnimations {

    /**
     * Fast-In-Extra-Slow-Out Interpolator
     */
    @JvmStatic
    val interpolator: Interpolator = FastOutSlowInInterpolator()
}