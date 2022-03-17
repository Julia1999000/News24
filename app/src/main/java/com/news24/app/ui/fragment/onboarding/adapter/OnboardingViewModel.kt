package com.news24.app.ui.fragment.onboarding.adapter

import androidx.annotation.DrawableRes
import androidx.annotation.Keep
import com.news24.app.ui.adapter.ListViewModel


@Keep
data class OnboardingViewModel(
		override var listItemId: String?,
		val description: String,
		@DrawableRes val imageResId: Int
) : ListViewModel