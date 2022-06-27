package com.news24.app.ui.fragment.preloaderdialog

import com.news24.app.ui.fragment.base.BaseDisposablePresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


interface PreloaderDialogContract {

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    interface View : MvpView {

    }

    abstract class Presenter : BaseDisposablePresenter<View>() {

    }

}