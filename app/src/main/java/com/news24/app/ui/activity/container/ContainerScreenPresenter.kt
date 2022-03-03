package com.news24.app.ui.activity.container

import com.news24.app.di.NamedDependencies
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject
import javax.inject.Named

@InjectViewState
class ContainerScreenPresenter @Inject constructor(
		private val router: Router,
		@Named(NamedDependencies.START_SCREEN) private val startScreen: SupportAppScreen?
) : ContainerScreenContract.Presenter() {

	//region ==================== MVP Presenter ====================

	override fun onFirstViewAttach() {
		super.onFirstViewAttach()
		router.replaceScreen(startScreen)
	}

	//endregion


	//region ==================== ContainerScreenContract.Presenter ====================

	//endregion

}