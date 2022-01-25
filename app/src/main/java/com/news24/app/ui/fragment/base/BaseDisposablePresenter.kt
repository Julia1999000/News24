package com.news24.app.ui.fragment.base

import moxy.MvpPresenter
import moxy.MvpView

/**
 * Holds [Disposable] object and perform disposal in onDestroy()
 */
abstract class BaseDisposablePresenter<T : MvpView> : MvpPresenter<T>() {

	override fun onDestroy() {

	}

}