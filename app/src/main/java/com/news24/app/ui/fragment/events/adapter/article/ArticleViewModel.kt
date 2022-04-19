package com.news24.app.ui.fragment.events.adapter.article

import androidx.annotation.Keep
import com.news24.app.ui.fragment.events.adapter.BaseEventViewModel
import com.news24.app.ui.fragment.events.adapter.SizeForm


@Keep
data class ArticleViewModel(
		override var listItemId: String?,
		var title: String,
		var img: String
): BaseEventViewModel {

	override var sizeForm: SizeForm = SizeForm.BIG_FORM

	override fun getSpanSize(): Int {
		return BaseEventViewModel.BIG_SPAN.takeIf { sizeForm == SizeForm.BIG_FORM }
				?: BaseEventViewModel.SMALL_SPAN
	}

}