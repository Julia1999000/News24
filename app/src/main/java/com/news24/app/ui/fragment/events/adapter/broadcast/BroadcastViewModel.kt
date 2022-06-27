package com.news24.app.ui.fragment.events.adapter.broadcast

import androidx.annotation.Keep
import com.news24.app.ui.fragment.events.adapter.BaseEventViewModel
import com.news24.app.ui.fragment.events.adapter.SizeForm


@Keep
data class BroadcastViewModel(
		override var listItemId: String?,
		var title: String,
		var img: String,
		var status: StatusBroadcast
): BaseEventViewModel {

	override var sizeForm: SizeForm = SizeForm.BIG_FORM

	override fun getSpanSize(): Int {
		return BaseEventViewModel.BIG_SPAN
	}

}


enum class StatusBroadcast {
		START,
		END
}