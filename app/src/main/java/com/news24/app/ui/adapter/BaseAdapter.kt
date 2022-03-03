package com.news24.app.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager

open class BaseAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

	protected var delegatesManager: AdapterDelegatesManager<List<ListViewModel>> = AdapterDelegatesManager()

	var items: MutableList<ListViewModel> = ArrayList()
		private set

	override fun getItemViewType(position: Int): Int {
		return delegatesManager.getItemViewType(items, position)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
		return delegatesManager.onCreateViewHolder(parent, viewType)
	}

	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>) {
		delegatesManager.onBindViewHolder(items, position, holder, payloads)
	}

	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
		delegatesManager.onBindViewHolder(items, position, holder)
	}

	override fun getItemCount(): Int {
		return items.size
	}

	open fun swapItems(items: List<ListViewModel>) {
		this.items.clear()
		this.items.addAll(items)
		notifyDataSetChanged()
	}
}
