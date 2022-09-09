package com.news24.app.ui.fragment.detail.photoalbum.adapter.photoalbumcontent.onephoto

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.news24.app.R
import com.news24.app.databinding.ListItemOnePhotoBinding
import com.news24.app.di.NamedDependencies
import com.news24.app.helpers.ImageHelper
import com.news24.app.ui.adapter.BindingViewHolder
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.adapter.listener.ListItemClickListener
import javax.inject.Inject
import javax.inject.Named


class OnePhotoViewModelDelegate @Inject constructor(
        @Named(NamedDependencies.ACTIVITY_CONTEXT) private val context: Context,
        private val itemClickListener: ListItemClickListener? = null
) : AbsListItemAdapterDelegate<OnePhotoViewModel, ListViewModel, BindingViewHolder<ListItemOnePhotoBinding>>() {

    private val layoutInflater = LayoutInflater.from(context)

    //region ==================== Override ====================

    override fun isForViewType(
        item: ListViewModel, items: MutableList<ListViewModel>, position: Int
    ): Boolean {
        return item is OnePhotoViewModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): BindingViewHolder<ListItemOnePhotoBinding> {
        val fragmentBinding = ListItemOnePhotoBinding.inflate(layoutInflater, parent, false)
        return BindingViewHolder(fragmentBinding)
    }

    override fun onBindViewHolder(
        item: OnePhotoViewModel, viewHolder: BindingViewHolder<ListItemOnePhotoBinding>, payloads: MutableList<Any>
    ) {
        viewHolder.itemViewBinding.apply {
            if (itemClickListener != null) {
                root.setOnClickListener { itemClickListener.onListItemClicked(item) }
            } else {
                root.setOnClickListener(null)
            }

            ImageHelper.loadImageByUrlToImageView(item.photoUrl, ivItemPhoto, ImageHelper.CENTER_CROP,
                R.color.grey_79)
        }
    }

    //endregion

}