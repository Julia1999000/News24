package com.news24.app.ui.fragment.events

import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.fragment.base.BaseDisposablePresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface EventsScreenContract {

	@StateStrategyType(value = AddToEndSingleStrategy::class)
	interface View : MvpView {

		fun showItemList(items: List<ListViewModel>)

	}


	abstract class Presenter : BaseDisposablePresenter<View>() {

	}

}