package com.news24.app.ui.fragment.detail.photoalbum.adapter.countphotos

import androidx.annotation.Keep
import com.news24.app.ui.adapter.ListViewModel


@Keep
data class CountPhotosViewModel(
        override var listItemId: String?,
        var number: Int
) : ListViewModel