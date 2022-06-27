package com.news24.app.ui.fragment.detail.news.adapter.tagscontainer

import androidx.annotation.Keep
import com.news24.app.data.entities.events.model.EventTag
import com.news24.app.ui.adapter.ListViewModel


@Keep
data class TagsContainerViewModel(
        override var listItemId: String?,
        var listTags: List<EventTag>,
        var heightPx: Int
): ListViewModel