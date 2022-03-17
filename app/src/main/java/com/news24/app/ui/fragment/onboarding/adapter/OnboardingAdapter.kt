package com.news24.app.ui.fragment.onboarding.adapter

import com.news24.app.ui.adapter.DiffAdapter
import javax.inject.Inject


class OnboardingAdapter @Inject constructor(
		onboardingViewModelDelegate: OnboardingViewModelDelegate
) : DiffAdapter() {

	init {
		delegatesManager.addDelegate(onboardingViewModelDelegate)
	}

}