package com.news24.app.ui.fragment.settings

import com.news24.app.ui.fragment.base.BaseDisposablePresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface SettingsScreenContract {

	@StateStrategyType(value = AddToEndSingleStrategy::class)
	interface View : MvpView {

	}


	abstract class Presenter : BaseDisposablePresenter<View>() {

	}

}