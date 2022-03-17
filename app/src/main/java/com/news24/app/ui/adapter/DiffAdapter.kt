package com.news24.app.ui.adapter

import androidx.recyclerview.widget.DiffUtil


open class DiffAdapter : BaseAdapter() {

	override fun swapItems(items: List<ListViewModel>) {
		val diffResult = DiffUtil.calculateDiff(ListViewModelDiffCallback(this.items, items))
		diffResult.dispatchUpdatesTo(this)

		this.items.clear()
		this.items.addAll(items)

	}
}