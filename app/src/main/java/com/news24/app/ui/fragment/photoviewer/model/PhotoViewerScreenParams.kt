package com.news24.app.ui.fragment.photoviewer.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize


@Keep
@Parcelize
data class PhotoViewerScreenParams(
        val urlList: List<String>,
        val selectedUrl: String
): Parcelable