package com.news24.app.ui.fragment.webview.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class WebViewParams(
    val url: String
) : Parcelable