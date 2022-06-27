package com.news24.app.ui.fragment.detail.news.adapter.tagscontainer.tags

import androidx.annotation.Keep
import com.news24.app.ui.adapter.ListViewModel


@Keep
data class TagViewModel(
        override var listItemId: String?,
        var image: String
): ListViewModel