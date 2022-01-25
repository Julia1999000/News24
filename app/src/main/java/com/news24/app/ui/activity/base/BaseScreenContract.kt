package com.news24.app.ui.activity.base

import com.news24.app.ui.fragment.base.BaseDisposablePresenter
import moxy.MvpView

interface BaseScreenContract {

	interface View : MvpView {

	}


	abstract class Presenter : BaseDisposablePresenter<View>() {

	}

}