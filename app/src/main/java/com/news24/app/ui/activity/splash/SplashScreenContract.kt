package com.news24.app.ui.activity.splash

import com.news24.app.ui.fragment.base.BaseDisposablePresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


interface SplashScreenContract {

	@StateStrategyType(value = AddToEndSingleStrategy::class)
	interface View : MvpView {

	}


	abstract class Presenter : BaseDisposablePresenter<View>() {

		abstract fun onScreenLoadedWithoutExtraParams()

		abstract fun onExtraParamsReceived(data: Map<String, Any>)

	}

}