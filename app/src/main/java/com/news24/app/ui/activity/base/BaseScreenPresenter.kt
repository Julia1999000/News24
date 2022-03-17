package com.news24.app.ui.activity.base

import moxy.InjectViewState
import javax.inject.Inject


@InjectViewState
class BaseScreenPresenter @Inject constructor() : BaseScreenContract.Presenter() {

	//region ==================== MVP Presenter ====================

	override fun attachView(view: BaseScreenContract.View?) {
		super.attachView(view)
	}

	override fun detachView(view: BaseScreenContract.View?) {
		super.detachView(view)
	}

	//endregion


	//region ===================== BaseScreenContract.Presenter ======================

	//endregion

}