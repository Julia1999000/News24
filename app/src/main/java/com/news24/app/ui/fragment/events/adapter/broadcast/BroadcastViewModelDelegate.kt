package com.news24.app.ui.fragment.events.adapter.broadcast

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.news24.app.R
import com.news24.app.databinding.ListItemBroadcastBinding
import com.news24.app.di.NamedDependencies
import com.news24.app.helpers.ImageHelper
import com.news24.app.ui.adapter.BindingViewHolder
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.adapter.listener.ListItemClickListener
import javax.inject.Inject
import javax.inject.Named


class BroadcastViewModelDelegate @Inject constructor(
		@Named(NamedDependencies.ACTIVITY_CONTEXT) private val context: Context,
		private val itemClickListener: ListItemClickListener? = null
) : AbsListItemAdapterDelegate<BroadcastViewModel, ListViewModel, BindingViewHolder<ListItemBroadcastBinding>>() {

	private val layoutInflater = LayoutInflater.from(context)

	//region ==================== Override ====================

	override fun isForViewType(item: ListViewModel, items: MutableList<ListViewModel>, position: Int): Boolean {
		return item is BroadcastViewModel
	}

	override fun onCreateViewHolder(parent: ViewGroup): BindingViewHolder<ListItemBroadcastBinding> {
		val fragmentBinding = ListItemBroadcastBinding.inflate(layoutInflater, parent, false)
		return BindingViewHolder(fragmentBinding)
	}

	override fun onBindViewHolder(item: BroadcastViewModel, viewHolder: BindingViewHolder<ListItemBroadcastBinding>, payloads: MutableList<Any>) {
		viewHolder.itemViewBinding.apply {
			if (itemClickListener != null) {
				root.setOnClickListener { itemClickListener.onListItemClicked(item) }
			} else {
				root.setOnClickListener(null)
			}

			if(item.status == StatusBroadcast.START) {
				tvLiveLogoTxt.setBackgroundResource(R.drawable.background_live_start)
				tvLiveLogoTxt.setTextColor(ContextCompat.getColor(context, R.color.white))
				tvUnderLiveLogoTxt.text = null
			} else {
				tvLiveLogoTxt.setBackgroundResource(R.drawable.background_live_end)
				tvLiveLogoTxt.setTextColor(ContextCompat.getColor(context, R.color.black))
				tvUnderLiveLogoTxt.setText(R.string.live_end)
			}

			tvHeader.text = item.title
			ImageHelper.loadImageByUrlToImageView(item.img, ivBackground, ImageHelper.CENTER_CROP, R.color.grey_F3)
		}
	}

	//endregion

}