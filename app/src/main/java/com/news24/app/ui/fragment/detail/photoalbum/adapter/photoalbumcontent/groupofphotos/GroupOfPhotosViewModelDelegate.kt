package com.news24.app.ui.fragment.detail.photoalbum.adapter.photoalbumcontent.groupofphotos

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.news24.app.R
import com.news24.app.databinding.ListItemGroupOfPhotosBinding
import com.news24.app.di.NamedDependencies
import com.news24.app.helpers.ImageHelper
import com.news24.app.ui.adapter.BindingViewHolder
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.adapter.listener.ListItemClickListener
import javax.inject.Inject
import javax.inject.Named


class GroupOfPhotosViewModelDelegate  @Inject constructor(
        @Named(NamedDependencies.ACTIVITY_CONTEXT) private val context: Context,
        private val itemClickListener: ListItemClickListener? = null
) : AbsListItemAdapterDelegate<GroupOfPhotosViewModel, ListViewModel, BindingViewHolder<ListItemGroupOfPhotosBinding>>() {

    private val layoutInflater = LayoutInflater.from(context)

    //region ==================== Override ====================

    override fun isForViewType(
        item: ListViewModel, items: MutableList<ListViewModel>, position: Int
    ): Boolean {
        return item is GroupOfPhotosViewModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): BindingViewHolder<ListItemGroupOfPhotosBinding> {
        val fragmentBinding = ListItemGroupOfPhotosBinding.inflate(layoutInflater, parent, false)
        return BindingViewHolder(fragmentBinding)
    }

    override fun onBindViewHolder(
        item: GroupOfPhotosViewModel, viewHolder: BindingViewHolder<ListItemGroupOfPhotosBinding>, payloads: MutableList<Any>
    ) {
        viewHolder.itemViewBinding.apply {
            if (itemClickListener != null) {
                ivTopLeftPhoto.setOnClickListener { itemClickListener.onListItemClicked(item.topLeftPhoto) }
                ivTopRightPhoto.setOnClickListener { itemClickListener.onListItemClicked(item.topRightPhoto) }
                ivBottomLeftPhoto.setOnClickListener { itemClickListener.onListItemClicked(item.bottomLeftPhoto) }
                ivBottomRightPhoto.setOnClickListener { itemClickListener.onListItemClicked(item.bottomRightPhoto) }
            } else {
                root.setOnClickListener(null)
            }

            ImageHelper.loadImageByUrlToImageView(item.topLeftPhoto.photoUrl, ivTopLeftPhoto,
                ImageHelper.CENTER_CROP, R.color.grey_79)
            ImageHelper.loadImageByUrlToImageView(item.topRightPhoto.photoUrl, ivTopRightPhoto,
                ImageHelper.CENTER_CROP, R.color.grey_79)
            ImageHelper.loadImageByUrlToImageView(item.bottomLeftPhoto.photoUrl, ivBottomLeftPhoto,
                ImageHelper.CENTER_CROP, R.color.grey_79)
            ImageHelper.loadImageByUrlToImageView(item.bottomRightPhoto.photoUrl, ivBottomRightPhoto,
                ImageHelper.CENTER_CROP, R.color.grey_79)
        }
    }

    //endregion

}