package com.news24.app.ui.fragment.webview

import com.news24.app.ui.fragment.base.BaseDisposablePresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


interface WebViewContract {

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    interface View : MvpView {

        fun showPage(url: String)

    }


    abstract class Presenter : BaseDisposablePresenter<View>() {

        abstract fun onBackButtonClicked()

    }

}