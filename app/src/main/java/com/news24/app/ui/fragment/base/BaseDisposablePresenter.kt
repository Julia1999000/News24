package com.news24.app.ui.fragment.base

import com.news24.app.utils.RxUtils
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter
import moxy.MvpView


/**
 * Holds [Disposable] object and perform disposal in onDestroy()
 */
abstract class BaseDisposablePresenter<T : MvpView> : MvpPresenter<T>() {

	protected var compositeDisposable = CompositeDisposable()

	override fun onDestroy() {
		super.onDestroy()
		RxUtils.disposeIfNeeded(compositeDisposable)
	}

}