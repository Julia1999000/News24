package com.news24.app.ui.fragment.events

import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.fragment.base.BaseDisposablePresenter
import com.news24.app.ui.fragment.base.view.ViewWithPreloader
import moxy.MvpView

import moxy.viewstate.strategy.alias.AddToEndSingle

interface EventsContract {


	interface View : MvpView, ViewWithPreloader {

		@AddToEndSingle
		fun showData(items: List<ListViewModel>)

	}


	abstract class Presenter : BaseDisposablePresenter<View>() {

		abstract fun onListItemClicked(item: ListViewModel)

		abstract fun onListScrolled(lastVisibleItemPosition: Int)

	}

}