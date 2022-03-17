package com.news24.app.ui.fragment.settings

import com.news24.app.ui.other.resources.ResourceProvider
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject


@InjectViewState
class SettingsScreenPresenter @Inject constructor(
		private val router: Router,
		private val resourceProvider: ResourceProvider
) : SettingsScreenContract.Presenter() {

	//region ==================== MVP Presenter ====================

	override fun onFirstViewAttach() {
		super.onFirstViewAttach()

	}

	//endregion


	//region ==================== SettingsScreenContract.Presenter ====================

	//endregion


	//region ===================== Internal ======================

	//endregion

}