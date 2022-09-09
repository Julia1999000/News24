package com.news24.app.ui.fragment.events.adapter

import com.news24.app.ui.adapter.GridListViewModel


interface BaseEventViewModel : GridListViewModel {

	var sizeForm: SizeForm

	companion object {
		const val SMALL_SPAN = 1
		const val BIG_SPAN = 2
	}

}


enum class SizeForm {
		SMALL_FORM,
		BIG_FORM
}

