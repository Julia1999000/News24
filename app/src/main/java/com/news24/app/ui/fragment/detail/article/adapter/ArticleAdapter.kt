package com.news24.app.ui.fragment.detail.article.adapter

import com.news24.app.ui.adapter.DiffAdapter
import com.news24.app.ui.adapter.delegates.separator.SeparatorViewModelDelegate
import com.news24.app.ui.adapter.delegates.textview.TextViewModelDelegate
import com.news24.app.ui.fragment.detail.news.adapter.tagscontainer.TagsContainerViewModelDelegate
import javax.inject.Inject


class ArticleAdapter @Inject constructor(
        textViewModelDelegate: TextViewModelDelegate,
        separatorViewModelDelegate: SeparatorViewModelDelegate,
        tagsContainerViewModelDelegate: TagsContainerViewModelDelegate
): DiffAdapter() {

    init {
        delegatesManager.addDelegate(textViewModelDelegate)
        delegatesManager.addDelegate(separatorViewModelDelegate)
        delegatesManager.addDelegate(tagsContainerViewModelDelegate)
    }

}