package com.news24.app.ui.other.resources

import android.content.Context
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

interface ResourceProvider {

    fun getString(@StringRes stringResId: Int): String

    fun getString(@StringRes stringResId: Int, vararg formatArgs: Any): String

    fun getQuantityString(@PluralsRes pluralResId: Int, quantity: Int, vararg formatArgs: Any): String

    fun getWidthScreenDp(): Int

    fun getHeightScreenDp(): Int

    fun getWidthScreenPx(): Int

    fun getHeightScreenPx(): Int

    fun pxToDp(value: Float): Float

    fun dpToPx(value: Float): Float

    fun dpToPx(value: Int): Int

}