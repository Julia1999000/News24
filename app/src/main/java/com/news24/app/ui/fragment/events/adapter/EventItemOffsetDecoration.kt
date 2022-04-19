package com.news24.app.ui.fragment.events.adapter

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.news24.app.di.NamedDependencies
import com.news24.app.helpers.DimensHelper.dpToPx
import javax.inject.Inject
import javax.inject.Named

class EventItemOffsetDecoration @Inject constructor(
		@Named(NamedDependencies.ACTIVITY_CONTEXT) private val context: Context
): RecyclerView.ItemDecoration() {

	companion object {
		const val EVENT_ITEM_OFFSET_DECORATION_DP = 1
	}

	override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
		val pxValue = EVENT_ITEM_OFFSET_DECORATION_DP.dpToPx(context)

		outRect.top = pxValue
		outRect.bottom = pxValue
		outRect.left = pxValue
		outRect.right = pxValue
	}

}