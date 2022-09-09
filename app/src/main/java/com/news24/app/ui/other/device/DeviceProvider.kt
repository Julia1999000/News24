package com.news24.app.ui.other.device


interface DeviceProvider {

    fun getWidthScreenDp(): Int

    fun getHeightScreenDp(): Int

    fun getWidthScreenPx(): Int

    fun getHeightScreenPx(): Int

}