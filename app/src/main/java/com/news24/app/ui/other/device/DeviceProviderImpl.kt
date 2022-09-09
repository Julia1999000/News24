package com.news24.app.ui.other.device

import android.content.Context
import com.news24.app.helpers.DimensHelper
import javax.inject.Inject


class DeviceProviderImpl @Inject constructor(private val context: Context): DeviceProvider {

    override fun getWidthScreenDp(): Int {
        return DimensHelper.pxToDp(context, getWidthScreenPx())
    }

    override fun getHeightScreenDp(): Int {
        return DimensHelper.pxToDp(context, getHeightScreenPx())
    }

    override fun getHeightScreenPx(): Int {
        return context.resources.displayMetrics.heightPixels
    }

    override fun getWidthScreenPx(): Int {
        return context.resources.displayMetrics.widthPixels
    }

}