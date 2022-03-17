package com.news24.app.ui.fragment.profile

import com.news24.app.ui.other.resources.ResourceProvider
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject


@InjectViewState
class ProfileScreenPresenter @Inject constructor(
		private val router: Router,
		private val resourceProvider: ResourceProvider
) : ProfileScreenContract.Presenter() {

	//region ==================== MVP Presenter ====================

	override fun onFirstViewAttach() {
		super.onFirstViewAttach()

	}

	//endregion


	//region ==================== ProfileScreenContract.Presenter ====================

	//endregion


	//region ===================== Internal ======================

	//endregion

}