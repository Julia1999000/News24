package com.news24.app.ui.fragment.events

import com.news24.app.ui.other.resources.ResourceProvider
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject


@InjectViewState
class EventsScreenPresenter @Inject constructor(
		private val router: Router,
		private val resourceProvider: ResourceProvider
) : EventsScreenContract.Presenter() {

	//region ==================== MVP Presenter ====================

	override fun onFirstViewAttach() {
		super.onFirstViewAttach()

	}

	//endregion


	//region ==================== EventsScreenContract.Presenter ====================

	//endregion


	//region ===================== Internal ======================

	//endregion

}