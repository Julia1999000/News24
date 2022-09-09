package com.news24.app.ui.fragment.events.adapter.news

import androidx.annotation.Keep
import com.news24.app.ui.fragment.events.adapter.BaseEventViewModel
import com.news24.app.ui.fragment.events.adapter.SizeForm


@Keep
data class NewsViewModel(
		override var listItemId: String?,
		var title: String,
		var img: String
): BaseEventViewModel {

	override var sizeForm: SizeForm = SizeForm.BIG_FORM

	override var spanSize: Int
		get() = BaseEventViewModel.BIG_SPAN.takeIf { sizeForm == SizeForm.BIG_FORM }
					?: BaseEventViewModel.SMALL_SPAN
		set(value) { }

}