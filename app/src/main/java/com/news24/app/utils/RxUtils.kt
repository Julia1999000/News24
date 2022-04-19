package com.news24.app.utils

import io.reactivex.disposables.Disposable


object RxUtils {

	fun disposeIfNeeded(disposable: Disposable) {
		if (shouldDispose(disposable)) {
			disposable.dispose()
		}
	}

	fun shouldDispose(disposable: Disposable?): Boolean {
		return disposable != null && !disposable.isDisposed
	}

}