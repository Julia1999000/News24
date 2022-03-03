package com.news24.app.ui.adapter

import androidx.recyclerview.widget.DiffUtil

class ListViewModelDiffCallback(
		private var oldList: List<ListViewModel>? = null,
		private var newList: List<ListViewModel>? = null
): DiffUtil.Callback() {

	override fun getOldListSize(): Int {
		return oldList?.size ?: 0
	}

	override fun getNewListSize(): Int {
		return newList?.size ?: 0
	}

	override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
		val oldModel = oldList?.get(oldItemPosition)
		val newModel = newList?.get(newItemPosition)

		if (oldModel?.listItemId != null && newModel?.listItemId != null) {
			return oldModel.listItemId?.equals(newModel.listItemId) ?: false
		}

		return oldModel?.equals(newModel) ?: false
	}

	override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
		val oldModel = oldList?.get(oldItemPosition)
		val newModel = newList?.get(newItemPosition)

		return oldModel?.equals(newModel) ?: false
	}

	override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
		val oldModel = oldList?.get(oldItemPosition) ?: return null
		val newModel = newList?.get(newItemPosition) ?: return null

		return Change(oldModel, newModel)
	}

}