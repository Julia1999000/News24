package com.news24.app.ui.fragment.events.adapter

import com.news24.app.ui.adapter.ListViewModel


interface BaseEventViewModel : ListViewModel {

	var sizeForm: SizeForm

	fun getSpanSize(): Int

	companion object {
		const val SMALL_SPAN = 1
		const val BIG_SPAN = 2
	}

}


enum class SizeForm {
	SMALL_FORM,
	BIG_FORM
}

