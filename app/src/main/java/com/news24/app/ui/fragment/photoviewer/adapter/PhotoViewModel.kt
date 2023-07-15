package com.news24.app.ui.fragment.photoviewer.adapter

import androidx.annotation.Keep
import com.news24.app.ui.adapter.ListViewModel


@Keep
data class PhotoViewModel(
        override var listItemId: String?,
        val url: String
): ListViewModel