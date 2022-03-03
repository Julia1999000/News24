package com.news24.app.ui.activity.splash

import com.news24.app.data.entities.app.AppService
import com.news24.app.ui.navigation.Screens
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class SplashScreenPresenter @Inject constructor(
		private val router: Router,
		private val appService: AppService
) : SplashScreenContract.Presenter() {

	//region ==================== MVP Presenter ====================

	override fun onFirstViewAttach() {
		super.onFirstViewAttach()
	}

	//endregion


	//region ==================== SplashScreenContract.Presenter ====================

	override fun onScreenLoadedWithoutExtraParams() {
		checkAuthStatusAndPerformActionIfAuthorized {
			router.newRootScreen(Screens.MainScreen())
		}
	}

	override fun onExtraParamsReceived(data: Map<String, Any>) {
		checkAuthStatusAndPerformActionIfAuthorized {
			router.newRootScreen(Screens.MainScreen())
		}
	}

	//endregion


	//region ===================== Internal ======================

	private fun checkAuthStatusAndPerformActionIfAuthorized(action: () -> Unit) {

		if (appService.isShouldShowOnboardingScreen()) {
			router.replaceScreen(Screens.ContainerScreen(Screens.OnboardingScreen()))
		} else {
			action()
		}

	}

	//endregion

}


