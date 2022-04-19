package com.news24.app.helpers

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue

object DimensHelper {

    fun dpToPx(context: Context, value: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.resources.displayMetrics)
    }

    fun dpToPx(context: Context, value: Int): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value.toFloat(), context.resources.displayMetrics).toInt()
    }

    fun pxToDp(context: Context, value: Float): Float {
        val metrics = context.resources.displayMetrics
        return value / (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
    }

    fun Int.dpToPx(context: Context): Int {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics
        ).toInt()
    }

}