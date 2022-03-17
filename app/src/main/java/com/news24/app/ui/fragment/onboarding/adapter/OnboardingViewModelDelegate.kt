package com.news24.app.ui.fragment.onboarding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.news24.app.databinding.ListItemOnboardingPageBinding
import com.news24.app.di.NamedDependencies
import com.news24.app.ui.adapter.BindingViewHolder
import com.news24.app.ui.adapter.ListViewModel
import javax.inject.Inject
import javax.inject.Named


class OnboardingViewModelDelegate @Inject constructor(
		@Named(NamedDependencies.ACTIVITY_CONTEXT) private val context: Context
) : AbsListItemAdapterDelegate<OnboardingViewModel, ListViewModel, BindingViewHolder<ListItemOnboardingPageBinding>>() {

	private val layoutInflater = LayoutInflater.from(context)

	//region ==================== Override ====================

	override fun isForViewType(item: ListViewModel, items: MutableList<ListViewModel>, position: Int): Boolean {
		return item is OnboardingViewModel
	}

	override fun onCreateViewHolder(parent: ViewGroup): BindingViewHolder<ListItemOnboardingPageBinding> {
		val fragmentBinding = ListItemOnboardingPageBinding.inflate(layoutInflater, parent, false)
		return BindingViewHolder(fragmentBinding)
	}

	override fun onBindViewHolder(item: OnboardingViewModel, viewHolder: BindingViewHolder<ListItemOnboardingPageBinding>, payloads: MutableList<Any>) {
		viewHolder.itemViewBinding.apply {
			ivImg.setImageResource(item.imageResId)
			tvDescription.text = item.description
		}
	}

	//endregion

}