package com.news24.app.ui.activity.main

import com.news24.app.ui.activity.main.MainScreenContract.View.Companion.TAB_EVENTS
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject


@InjectViewState
class MainScreenPresenter @Inject constructor(
		private val router: Router
) : MainScreenContract.Presenter() {


	//region ==================== MVP Presenter ====================

	override fun onFirstViewAttach() {
		super.onFirstViewAttach()

		viewState.activateTab(TAB_EVENTS)
	}

	//endregion


	//region ==================== MainScreenContract.Presenter ====================

	override fun onBackPressed() {
		router.exit()
	}

	//endregion


	//region ===================== Internal ======================

	//endregion

}