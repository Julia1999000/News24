package com.news24.app.helpers

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

object ResourceIdHelper {

    fun Int?.getDrawable(context: Context): Drawable? {
        return this?.let { ContextCompat.getDrawable(context, it) }
    }

}