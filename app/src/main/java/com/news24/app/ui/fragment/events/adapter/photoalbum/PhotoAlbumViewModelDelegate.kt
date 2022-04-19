package com.news24.app.ui.fragment.events.adapter.photoalbum

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.news24.app.R
import com.news24.app.databinding.ListItemPhotoAlbumBinding
import com.news24.app.di.NamedDependencies
import com.news24.app.extensions.shared.setPaddingExceptTop
import com.news24.app.extensions.shared.setTextStyle
import com.news24.app.helpers.ImageHelper
import com.news24.app.ui.adapter.BindingViewHolder
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.adapter.listener.ListItemClickListener
import com.news24.app.ui.fragment.events.adapter.SizeForm
import javax.inject.Inject
import javax.inject.Named


class PhotoAlbumViewModelDelegate @Inject constructor(
		@Named(NamedDependencies.ACTIVITY_CONTEXT) private val context: Context,
		private val itemClickListener: ListItemClickListener? = null
) : AbsListItemAdapterDelegate<PhotoAlbumViewModel, ListViewModel, BindingViewHolder<ListItemPhotoAlbumBinding>>() {

	private val layoutInflater = LayoutInflater.from(context)

	companion object {
		private const val BIG_FORM_DIMENSION_RATIO = "h, 1:1"
		private const val SMALL_FORM_DIMENSION_RATIO = "h, 175:290"
	}

	//region ==================== Override ====================

	override fun isForViewType(item: ListViewModel, items: MutableList<ListViewModel>, position: Int): Boolean {
		return item is PhotoAlbumViewModel
	}

	override fun onCreateViewHolder(parent: ViewGroup): BindingViewHolder<ListItemPhotoAlbumBinding> {
		val fragmentBinding = ListItemPhotoAlbumBinding.inflate(layoutInflater, parent, false)
		return BindingViewHolder(fragmentBinding)
	}

	override fun onBindViewHolder(item: PhotoAlbumViewModel, viewHolder: BindingViewHolder<ListItemPhotoAlbumBinding>, payloads: MutableList<Any>) {
		viewHolder.itemViewBinding.apply {
			if (itemClickListener != null) {
				root.setOnClickListener { itemClickListener.onListItemClicked(item) }
			} else {
				root.setOnClickListener(null)
			}

			if (item.sizeForm == SizeForm.BIG_FORM) {
				(ivBackPhotoAlbumLast.layoutParams as ConstraintLayout.LayoutParams).dimensionRatio =
						BIG_FORM_DIMENSION_RATIO
				tvHeaderPhotoAlbum.setPaddingExceptTop(15)
				tvHeaderPhotoAlbum.setTextStyle(R.style.S18BoldWhite)
			} else {
				(ivBackPhotoAlbumLast.layoutParams as ConstraintLayout.LayoutParams).dimensionRatio =
						SMALL_FORM_DIMENSION_RATIO
				tvHeaderPhotoAlbum.setPaddingExceptTop(8)
				tvHeaderPhotoAlbum.setTextStyle(R.style.S14BoldWhite)
			}

			tvCountPhotos.text = item.countPhoto.toString()
			tvHeaderPhotoAlbum.text = item.title
			ImageHelper.loadImageByUrlToImageView(item.photoList[0], ivImgPhotoAlbum, ImageHelper.CENTER_CROP, R.color.grey_F3)
			ImageHelper.loadImageByUrlToImageView(item.photoList[1], ivBackPhotoAlbumCenter, ImageHelper.CENTER_CROP, R.color.grey_F3)
			ImageHelper.loadImageByUrlToImageView(item.photoList[2], ivBackPhotoAlbumLast, ImageHelper.CENTER_CROP, R.color.grey_F3)
		}
	}

	//endregion

}