package com.news24.app.ui.fragment.settings

import com.news24.app.di.NamedDependencies
import com.news24.app.ui.other.resources.ResourceProvider
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject
import javax.inject.Named


@InjectViewState
class SettingsScreenPresenter @Inject constructor(
		@Named(NamedDependencies.TAB_ROUTER) private val router: Router,
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