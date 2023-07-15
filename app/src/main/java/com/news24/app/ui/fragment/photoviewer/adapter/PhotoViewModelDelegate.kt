package com.news24.app.ui.fragment.photoviewer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.news24.app.R
import com.news24.app.databinding.ListItemPhotoViewerPageBinding
import com.news24.app.di.NamedDependencies
import com.news24.app.helpers.ImageHelper
import com.news24.app.ui.adapter.BindingViewHolder
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.adapter.listener.ListItemClickListener
import javax.inject.Inject
import javax.inject.Named


class PhotoViewModelDelegate @Inject constructor(
        @Named(NamedDependencies.ACTIVITY_CONTEXT) private val context: Context,
        private val itemClickListener: ListItemClickListener? = null
): AbsListItemAdapterDelegate<PhotoViewModel, ListViewModel, BindingViewHolder<ListItemPhotoViewerPageBinding>>() {

    private val layoutInflater = LayoutInflater.from(context)

    //region ==================== Override ====================

    override fun isForViewType(item: ListViewModel, items: MutableList<ListViewModel>, position: Int): Boolean {
        return item is PhotoViewModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): BindingViewHolder<ListItemPhotoViewerPageBinding> {
        val fragmentBinding = ListItemPhotoViewerPageBinding.inflate(layoutInflater, parent, false)
        return BindingViewHolder(fragmentBinding)
    }

    override fun onBindViewHolder(item: PhotoViewModel, viewHolder: BindingViewHolder<ListItemPhotoViewerPageBinding>, payloads: MutableList<Any>) {
        viewHolder.itemViewBinding.apply {
            if (itemClickListener != null) {
                root.setOnClickListener { itemClickListener.onListItemClicked(item) }
            } else {
                root.setOnClickListener(null)
            }
            ImageHelper.loadImageByUrlToImageView(item.url, ivPhoto, ImageHelper.CENTER_INSIDE)
        }
    }

    //endregion
}