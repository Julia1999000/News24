package com.news24.app.ui.activity.main

import com.news24.app.ui.fragment.base.BaseDisposablePresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.terrakok.cicerone.Screen


interface MainScreenContract {

	@StateStrategyType(value = AddToEndSingleStrategy::class)
	interface View : MvpView {

		companion object {
			const val TAB_EVENTS = "TAB_EVENTS"
			const val TAB_SETTINGS = "TAB_SETTINGS"
			const val TAB_PROFILE = "TAB_PROFILE"
		}

		fun navigateTo(screen: Screen)

		fun activateTab(tab: String)

		fun clearTabStack(tab: String)

	}


	abstract class Presenter : BaseDisposablePresenter<View>() {

		abstract fun onBackPressed()

	}

}