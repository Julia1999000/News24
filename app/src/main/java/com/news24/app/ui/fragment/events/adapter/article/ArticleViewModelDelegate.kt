package com.news24.app.ui.fragment.events.adapter.article

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.news24.app.R
import com.news24.app.databinding.ListItemArticleBinding
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


class ArticleViewModelDelegate @Inject constructor(
		@Named(NamedDependencies.ACTIVITY_CONTEXT) private val context: Context,
		private val itemClickListener: ListItemClickListener? = null
) : AbsListItemAdapterDelegate<ArticleViewModel, ListViewModel, BindingViewHolder<ListItemArticleBinding>>() {

	private val layoutInflater = LayoutInflater.from(context)

	companion object {
		private const val BIG_FORM_DIMENSION_RATIO = "h, 1:1"
		private const val SMALL_FORM_DIMENSION_RATIO = "h, 175:290"
	}

	//region ==================== Override ====================

	override fun isForViewType(item: ListViewModel, items: MutableList<ListViewModel>, position: Int): Boolean {
		return item is ArticleViewModel
	}

	override fun onCreateViewHolder(parent: ViewGroup): BindingViewHolder<ListItemArticleBinding> {
		val fragmentBinding = ListItemArticleBinding.inflate(layoutInflater, parent, false)
		return BindingViewHolder(fragmentBinding)
	}

	override fun onBindViewHolder(item: ArticleViewModel, viewHolder: BindingViewHolder<ListItemArticleBinding>, payloads: MutableList<Any>) {
		viewHolder.itemViewBinding.apply {
			if (itemClickListener != null) {
				root.setOnClickListener { itemClickListener.onListItemClicked(item) }
			} else {
				root.setOnClickListener(null)
			}

			if (item.sizeForm == SizeForm.BIG_FORM) {
				(ivBackground.layoutParams as ConstraintLayout.LayoutParams).dimensionRatio =
						BIG_FORM_DIMENSION_RATIO
				tvHeader.setPaddingExceptTop(15)
				tvHeader.setTextStyle(R.style.S18BoldWhite)
			} else {
				(ivBackground.layoutParams as ConstraintLayout.LayoutParams).dimensionRatio =
						SMALL_FORM_DIMENSION_RATIO
				tvHeader.setPaddingExceptTop(8)
				tvHeader.setTextStyle(R.style.S14BoldWhite)
			}

			tvHeader.text = item.title
			ImageHelper.loadImageByUrlToImageView(item.img, ivBackground, ImageHelper.CENTER_CROP,
				R.color.grey_79, successAction = { shimmerContainer.hideShimmer() })
		}
	}

	//endregion

}