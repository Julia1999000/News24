package com.news24.app.ui.other.resources

import android.content.Context
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

}