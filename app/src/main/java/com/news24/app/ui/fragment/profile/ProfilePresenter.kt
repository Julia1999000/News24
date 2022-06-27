package com.news24.app.ui.fragment.profile

import com.news24.app.di.NamedDependencies
import com.news24.app.ui.other.resources.ResourceProvider
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject
import javax.inject.Named


@InjectViewState
class ProfilePresenter @Inject constructor(
		@Named(NamedDependencies.TAB_ROUTER) private val router: Router,
		private val resourceProvider: ResourceProvider
) : ProfileContract.Presenter() {

	//region ==================== MVP Presenter ====================

	override fun onFirstViewAttach() {
		super.onFirstViewAttach()

	}

	//endregion


	//region ==================== ProfileContract.Presenter ====================

	//endregion


	//region ===================== Internal ======================

	//endregion

}