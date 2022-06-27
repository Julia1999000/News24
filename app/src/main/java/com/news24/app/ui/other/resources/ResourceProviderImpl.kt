package com.news24.app.ui.other.resources

import android.content.Context
import com.news24.app.helpers.DimensHelper
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor(private val context: Context): ResourceProvider {

    override fun getString(stringResId: Int): String {
        return context.getString(stringResId)
    }

    override fun getString(stringResId: Int, vararg formatArgs: Any): String {
        return context.getString(stringResId, *formatArgs)
    }

    override fun getQuantityString(pluralResId: Int, quantity: Int, vararg formatArgs: Any): String {
        return context.resources.getQuantityString(pluralResId, quantity, *formatArgs)
    }

    override fun getWidthScreenDp(): Int {
        return DimensHelper.pxToDp(context, context.resources.displayMetrics.widthPixels.toFloat()).toInt()
    }

    override fun getHeightScreenDp(): Int {
        return DimensHelper.pxToDp(context, context.resources.displayMetrics.heightPixels.toFloat()).toInt()
    }

    override fun getHeightScreenPx(): Int {
        return context.resources.displayMetrics.heightPixels
    }

    override fun getWidthScreenPx(): Int {
        return context.resources.displayMetrics.widthPixels
    }

    override fun pxToDp(value: Float): Float {
        return DimensHelper.pxToDp(context, value)
    }

    override fun dpToPx(value: Float): Float {
        return DimensHelper.dpToPx(context, value)
    }

    override fun dpToPx(value: Int): Int {
        return DimensHelper.dpToPx(context, value)
    }

}