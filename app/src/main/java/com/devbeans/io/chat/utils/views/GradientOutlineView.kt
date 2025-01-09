package com.devbeans.io.chat.utils.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.devbeans.io.chat.R

class GradientOutlineView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var cornerRadius: Float = 0f

    private var startColor: Int = ContextCompat.getColor(context, android.R.color.transparent)
    private var centerColor: Int = ContextCompat.getColor(context, android.R.color.transparent)
    private var endColor: Int = ContextCompat.getColor(context, android.R.color.transparent)
    private var orientation: Int = 0
    private val rectF = RectF()

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.GradientOutlineView,
            defStyleAttr,
            0
        ).apply {
            try {
                cornerRadius =
                    getDimension(R.styleable.GradientOutlineView_gradientOutlineCornerRadius, 0f)
                paint.strokeWidth =
                    getDimension(R.styleable.GradientOutlineView_gradientOutlineStrokeWidth, 0f)

                startColor =
                    getColor(R.styleable.GradientOutlineView_gradientOutlineStartColor, startColor)
                centerColor = getColor(
                    R.styleable.GradientOutlineView_gradientOutlineCenterColor,
                    centerColor
                )
                endColor =
                    getColor(R.styleable.GradientOutlineView_gradientOutlineEndColor, endColor)
                orientation = getInt(R.styleable.GradientOutlineView_gradientOutlineOrientation, 0)

                paint.style = Paint.Style.STROKE
            } finally {
                recycle()
            }
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        val shader = when (orientation) {
            0 -> LinearGradient(
                0f,
                0f,
                w.toFloat(),
                0f,
                intArrayOf(startColor, centerColor, endColor),
                null,
                Shader.TileMode.CLAMP
            )

            else -> LinearGradient(
                0f,
                0f,
                0f,
                h.toFloat(),
                intArrayOf(startColor, centerColor, endColor),
                null,
                Shader.TileMode.CLAMP
            )
        }

        paint.shader = shader
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val strokeWidth = paint.strokeWidth
        rectF.set(strokeWidth, strokeWidth, width - strokeWidth, height - strokeWidth)
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint)
    }
}
