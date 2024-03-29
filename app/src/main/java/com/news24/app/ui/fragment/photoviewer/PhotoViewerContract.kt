package com.news24.app.ui.fragment.photoviewer

import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.fragment.base.BaseDisposablePresenter
import com.news24.app.ui.fragment.photoviewer.adapter.PhotoViewModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


interface PhotoViewerContract {

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    interface View : MvpView {

        fun showItemList(items: List<PhotoViewModel>)

        fun setCurrentItem(position: Int)

    }


    abstract class Presenter : BaseDisposablePresenter<View>() {

        abstract fun onBackClicked()

    }

}