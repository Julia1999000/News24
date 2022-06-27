package com.news24.app.ui.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat


class RoundedView : FrameLayout {

    private val clipPath = Path()

    private lateinit var paint: Paint

    private var topLeftRadius = 0f
    private var topRightRadius = 0f
    private var bottomRightRadius = 0f
    private var bottomLeftRadius = 0f


    //region ===================== Constructor ======================

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    //endregion


    override fun dispatchDraw(canvas: Canvas) {
        clipPath.reset()

        clipPath.moveTo(0f, height.toFloat() - bottomLeftRadius)
        clipPath.rLineTo(0f, -height.toFloat() + topLeftRadius + bottomLeftRadius)
        clipPath.rQuadTo(0f, -topLeftRadius, topLeftRadius, -topLeftRadius)
        clipPath.rLineTo(width.toFloat() - topLeftRadius - topRightRadius, 0f)
        clipPath.rQuadTo(topRightRadius, 0f, topRightRadius, topRightRadius)
        clipPath.rLineTo(0f, height.toFloat() - topRightRadius - bottomRightRadius)
        clipPath.rQuadTo(0f, bottomRightRadius, -bottomRightRadius, bottomRightRadius)
        clipPath.rLineTo(-width.toFloat() + bottomRightRadius + bottomLeftRadius, 0f)
        clipPath.rQuadTo(-bottomLeftRadius, 0f, -bottomLeftRadius, -bottomLeftRadius)
        clipPath.close()

        clipPath.lineTo(0f,  height.toFloat())
        clipPath.lineTo(width.toFloat(),  height.toFloat())
        clipPath.lineTo(width.toFloat(), 0f)
        clipPath.lineTo(0f, 0f)
        clipPath.lineTo(0f, height.toFloat())
        clipPath.close()

        val saveCount = canvas.saveLayer(RectF(0f, 0f, width.toFloat(), height.toFloat()), null)
        super.dispatchDraw(canvas)
        canvas.drawPath(clipPath, paint)
        canvas.restoreToCount(saveCount)
    }

    fun setCorners(topLeftCornerSize: Float,
                   topRightCornerSize: Float,
                   bottomRightCornerSize: Float,
                   bottomLeftCornerSize: Float) {
        topLeftRadius = topLeftCornerSize
        topRightRadius = topRightCornerSize
        bottomRightRadius = bottomRightCornerSize
        bottomLeftRadius = bottomLeftCornerSize
    }

    //region ===================== Internal ======================

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        setLayerType(View.LAYER_TYPE_HARDWARE, null)
        paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = ContextCompat.getColor(context, android.R.color.white)
            xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        }
    }

    //endregion

}