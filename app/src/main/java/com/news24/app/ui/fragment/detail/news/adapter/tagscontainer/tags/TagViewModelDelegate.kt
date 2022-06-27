package com.news24.app.ui.fragment.detail.news.adapter.tagscontainer.tags

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.news24.app.R
import com.news24.app.databinding.ListItemTagBinding
import com.news24.app.di.NamedDependencies
import com.news24.app.helpers.ImageHelper
import com.news24.app.ui.adapter.BindingViewHolder
import com.news24.app.ui.adapter.ListViewModel
import javax.inject.Inject
import javax.inject.Named


class TagViewModelDelegate @Inject constructor(
        @Named(NamedDependencies.ACTIVITY_CONTEXT) private val context: Context
) : AbsListItemAdapterDelegate<TagViewModel, ListViewModel, BindingViewHolder<ListItemTagBinding>>() {

    private val layoutInflater = LayoutInflater.from(context)

    //region ==================== Override ====================

    override fun isForViewType(item: ListViewModel, items: MutableList<ListViewModel>, position: Int): Boolean {
        return item is TagViewModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): BindingViewHolder<ListItemTagBinding> {
        val fragmentBinding = ListItemTagBinding.inflate(layoutInflater, parent, false)
        return BindingViewHolder(fragmentBinding)
    }

    override fun onBindViewHolder(item: TagViewModel, viewHolder: BindingViewHolder<ListItemTagBinding>, payloads: MutableList<Any>) {
        viewHolder.itemViewBinding.apply {
           ImageHelper.loadImageByUrlToImageView(item.image, ivTagImage, ImageHelper.CENTER_CROP, R.color.grey_F3)
        }
    }

    //endregion

}