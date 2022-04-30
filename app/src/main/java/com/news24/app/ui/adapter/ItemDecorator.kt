package com.news24.app.ui.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject


class ItemDecorator @Inject constructor(): RecyclerView.ItemDecoration() {

	var itemOffset: Int = 0

	override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
		val pxValue = itemOffset

		outRect.top = pxValue
		outRect.bottom = pxValue
		outRect.left = pxValue
		outRect.right = pxValue
	}

}