package com.news24.app.ui.fragment.onboarding

import com.news24.app.R
import com.news24.app.data.entities.app.AppService
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.fragment.onboarding.adapter.OnboardingViewModel
import com.news24.app.ui.navigation.Screens
import com.news24.app.ui.other.resources.ResourceProvider
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject


@InjectViewState
class OnboardingPresenter @Inject constructor(
		private val router: Router,
		private val resourceProvider: ResourceProvider,
		private val appService: AppService
) : OnboardingContract.Presenter() {

	companion object {
		private const val FIRST_PAGE_SLIDER_ID = "FIRST_PAGE_SLIDER_ID"
		private const val SECOND_PAGE_SLIDER_ID = "SECOND_PAGE_SLIDER_ID"
		private const val THIRD_PAGE_SLIDER_ID = "THIRD_PAGE_SLIDER_ID"
		private const val FOURTH_PAGE_SLIDER_ID = "FOURTH_PAGE_SLIDER_ID"

	}

	//region ==================== MVP Presenter ====================

	override fun onFirstViewAttach() {
		super.onFirstViewAttach()
		appService.setShouldShowOnboardingScreen(false)

		val viewModels = arrayListOf<ListViewModel>()

		viewModels.add(OnboardingViewModel(FIRST_PAGE_SLIDER_ID,
				resourceProvider.getString(R.string.onboarding_description_first),
				R.drawable.ic_onboarding_first))

		viewModels.add(OnboardingViewModel(SECOND_PAGE_SLIDER_ID,
				resourceProvider.getString(R.string.onboarding_description_second),
				R.drawable.ic_onboarding_second))

		viewModels.add(OnboardingViewModel(THIRD_PAGE_SLIDER_ID,
				resourceProvider.getString(R.string.onboarding_description_third),
				R.drawable.ic_onboarding_third))

		viewModels.add(OnboardingViewModel(FOURTH_PAGE_SLIDER_ID,
				resourceProvider.getString(R.string.onboarding_description_fourth),
				R.drawable.ic_onboarding_fourth))

		viewState.showItemList(viewModels)

	}

	//endregion


	//region ==================== OnboardingContract.Presenter ====================

	override fun onSkipButtonClicked() {
		router.replaceScreen(Screens.MainContainerScreen())
	}

	//endregion


	//region ===================== Internal ======================

	//endregion

}