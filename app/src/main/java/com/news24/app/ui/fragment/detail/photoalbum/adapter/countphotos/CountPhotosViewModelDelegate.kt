package com.news24.app.ui.fragment.detail.photoalbum.adapter.countphotos

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.news24.app.databinding.ListItemCountPhotosBinding
import com.news24.app.di.NamedDependencies
import com.news24.app.ui.adapter.BindingViewHolder
import com.news24.app.ui.adapter.ListViewModel
import javax.inject.Inject
import javax.inject.Named


class CountPhotosViewModelDelegate @Inject constructor(
        @Named(NamedDependencies.ACTIVITY_CONTEXT) private val context: Context
) : AbsListItemAdapterDelegate<CountPhotosViewModel, ListViewModel, BindingViewHolder<ListItemCountPhotosBinding>>() {

    private val layoutInflater = LayoutInflater.from(context)

    //region ==================== Override ====================

    override fun isForViewType(item: ListViewModel, items: MutableList<ListViewModel>, position: Int
    ): Boolean {
        return item is CountPhotosViewModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): BindingViewHolder<ListItemCountPhotosBinding> {
        val fragmentBinding = ListItemCountPhotosBinding.inflate(layoutInflater, parent, false)
        return BindingViewHolder(fragmentBinding)
    }

    override fun onBindViewHolder(item: CountPhotosViewModel, viewHolder: BindingViewHolder<ListItemCountPhotosBinding>, payloads: MutableList<Any>) {
        viewHolder.itemViewBinding.apply {
            tvNumber.text = item.number.toString()
        }
    }

    //endregion

}