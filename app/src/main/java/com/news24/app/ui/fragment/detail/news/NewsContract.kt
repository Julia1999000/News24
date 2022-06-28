package com.news24.app.ui.fragment.detail.news

import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.fragment.base.BaseDisposablePresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType


interface NewsContract {

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    interface View: MvpView {

        fun showData(list: List<ListViewModel>)

        fun showBackground(imgBack: String)

        fun setTestHeader(text: String)

        @StateStrategyType(OneExecutionStateStrategy::class)
        fun shareNews(url: String)

    }


    abstract class Presenter: BaseDisposablePresenter<View>() {

        abstract fun onBackClicked()

        abstract fun onShareClicked()

        abstract fun onReadFurtherClicked()

        abstract fun setHeightListViewModel(heightHeaderPx: Int, heightBackPx: Int)

    }

}