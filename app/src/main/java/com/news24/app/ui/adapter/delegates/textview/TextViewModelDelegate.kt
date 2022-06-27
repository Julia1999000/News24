package com.news24.app.ui.adapter.delegates.textview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.news24.app.databinding.ListItemTextBinding
import com.news24.app.di.NamedDependencies
import com.news24.app.extensions.shared.setTextStyle
import com.news24.app.helpers.DimensHelper.dpToPx
import com.news24.app.ui.adapter.BindingViewHolder
import com.news24.app.ui.adapter.ListViewModel
import javax.inject.Inject
import javax.inject.Named


class TextViewModelDelegate @Inject constructor(
    @Named(NamedDependencies.ACTIVITY_CONTEXT) private val context: Context
) : AbsListItemAdapterDelegate<TextViewModel, ListViewModel, BindingViewHolder<ListItemTextBinding>>() {

    private val layoutInflater = LayoutInflater.from(context)

    //region ==================== Override ====================

    override fun isForViewType(
        item: ListViewModel,
        items: MutableList<ListViewModel>,
        position: Int
    ): Boolean {
        return item is TextViewModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): BindingViewHolder<ListItemTextBinding> {
        val fragmentBinding = ListItemTextBinding.inflate(layoutInflater, parent, false)
        return BindingViewHolder(fragmentBinding)
    }

    override fun onBindViewHolder(
        item: TextViewModel,
        viewHolder: BindingViewHolder<ListItemTextBinding>,
        payloads: MutableList<Any>
    ) {
        viewHolder.itemViewBinding.apply {
            tvTitleViewModel.text = item.text
            tvTitleViewModel.setTextStyle(item.styleId)
            val horizontalPaddingPx = item.horizontalPaddingDp.dpToPx(context)
            val bottomPaddingPx = item.bottomPaddingDp.dpToPx(context)
            tvTitleViewModel.setPadding(horizontalPaddingPx, 0, horizontalPaddingPx, bottomPaddingPx)
            tvTitleViewModel.setBackgroundResource(item.backgroundId)
        }
    }

    //endregion

}