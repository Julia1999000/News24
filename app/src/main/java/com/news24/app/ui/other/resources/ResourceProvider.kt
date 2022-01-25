package com.news24.app.ui.other.resources

import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

interface ResourceProvider {

    fun getString(@StringRes stringResId: Int): String

    fun getString(@StringRes stringResId: Int, vararg formatArgs: Any): String

    fun getQuantityString(@PluralsRes pluralResId: Int, quantity: Int, vararg formatArgs: Any): String

    fun getWidthScreenDp(): Int

}