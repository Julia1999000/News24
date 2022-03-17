package com.news24.app.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


class BindingViewHolder<T : ViewBinding> constructor(
		val itemViewBinding: T
) : RecyclerView.ViewHolder(itemViewBinding.root) {

}
