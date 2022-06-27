package com.news24.app.ui.fragment.detail.news.adapter.tagscontainer

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.LinearLayoutManager
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.news24.app.databinding.ListItemTagsContainerBinding
import com.news24.app.di.NamedDependencies
import com.news24.app.ui.adapter.BindingViewHolder
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.fragment.detail.news.adapter.tagscontainer.tags.TagViewModel
import com.news24.app.ui.fragment.detail.news.adapter.tagscontainer.tags.TagViewModelDelegate
import com.news24.app.ui.fragment.detail.news.adapter.tagscontainer.tags.TagsAdapter
import javax.inject.Inject
import javax.inject.Named


class TagsContainerViewModelDelegate @Inject constructor(
    @Named(NamedDependencies.ACTIVITY_CONTEXT) private val context: Context
) : AbsListItemAdapterDelegate<TagsContainerViewModel, ListViewModel, BindingViewHolder<ListItemTagsContainerBinding>>() {

    private val layoutInflater = LayoutInflater.from(context)

    private val adapter = TagsAdapter(TagViewModelDelegate(context))

    //region ==================== Override ====================

    override fun isForViewType(item: ListViewModel, items: MutableList<ListViewModel>, position: Int): Boolean {
        return item is TagsContainerViewModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): BindingViewHolder<ListItemTagsContainerBinding> {
        val fragmentBinding = ListItemTagsContainerBinding.inflate(layoutInflater, parent, false)
        return BindingViewHolder(fragmentBinding)
    }

    override fun onBindViewHolder(item: TagsContainerViewModel, viewHolder: BindingViewHolder<ListItemTagsContainerBinding>, payloads: MutableList<Any>) {
        viewHolder.itemViewBinding.apply {
            rvTags.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rvTags.adapter = adapter

            rvTags.updateLayoutParams {
                height = item.heightPx
            }

            val viewModels = arrayListOf<ListViewModel>()
            item.listTags.forEach { tag ->
                viewModels.add(TagViewModel(tag.id, tag.imageUrl))
            }
            adapter.swapItems(viewModels)
        }
    }

    //endregion

}