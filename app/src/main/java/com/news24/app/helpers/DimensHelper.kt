package com.news24.app.helpers

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue

object DimensHelper {

    fun dpToPx(context: Context, value: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.resources.displayMetrics)
    }

    fun dpToPx(context: Context, value: Int): Int {
        return dpToPx(context, value.toFloat()).toInt()
    }

    fun Int.dpToPx(context: Context): Int {
        return dpToPx(context, this.toFloat()).toInt()
    }

    fun Float.dpToPx(context: Context): Float {
        return dpToPx(context, this)
    }

    fun pxToDp(context: Context, value: Float): Float {
        val metrics = context.resources.displayMetrics
        return value / (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
    }

    fun pxToDp(context: Context, value: Int): Int {
        return pxToDp(context, value.toFloat()).toInt()
    }

    fun Int.pxToDp(context: Context): Int {
        return pxToDp(context, this.toFloat()).toInt()
    }

    fun Float.pxToDp(context: Context): Float {
        return pxToDp(context, this)
    }

}