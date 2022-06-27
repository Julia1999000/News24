package com.news24.app.ui.fragment.detail.news.adapter.tagscontainer.tags

import com.news24.app.ui.adapter.DiffAdapter
import javax.inject.Inject


class TagsAdapter @Inject constructor(
       tagViewModelDelegate: TagViewModelDelegate
): DiffAdapter() {

    init {
        delegatesManager.addDelegate(tagViewModelDelegate)
    }

}