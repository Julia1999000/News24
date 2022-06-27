package com.news24.app.ui.adapter.delegates.separator

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.news24.app.databinding.ListItemSeparatorBinding
import com.news24.app.di.NamedDependencies
import com.news24.app.helpers.DimensHelper.dpToPx
import com.news24.app.ui.adapter.BindingViewHolder
import com.news24.app.ui.adapter.ListViewModel
import javax.inject.Inject
import javax.inject.Named


class SeparatorViewModelDelegate @Inject constructor(
    @Named(NamedDependencies.ACTIVITY_CONTEXT) private val context: Context
) : AbsListItemAdapterDelegate<SeparatorViewModel, ListViewModel, BindingViewHolder<ListItemSeparatorBinding>>() {

    private val layoutInflater = LayoutInflater.from(context)

    //region ==================== Override ====================

    override fun isForViewType(item: ListViewModel, items: MutableList<ListViewModel>, position: Int): Boolean {
        return item is SeparatorViewModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): BindingViewHolder<ListItemSeparatorBinding> {
        val fragmentBinding = ListItemSeparatorBinding.inflate(layoutInflater, parent, false)
        return BindingViewHolder(fragmentBinding)
    }

    override fun onBindViewHolder(item: SeparatorViewModel, viewHolder: BindingViewHolder<ListItemSeparatorBinding>, payloads: MutableList<Any>) {
        viewHolder.itemViewBinding.apply {
            separator.setBackgroundResource(item.colorResId)
            root.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                height = item.heightDp.dpToPx(context)
                leftMargin = item.horizontalMarginDp.dpToPx(context)
                rightMargin = item.horizontalMarginDp.dpToPx(context)
            }
        }
    }

    //endregion

}