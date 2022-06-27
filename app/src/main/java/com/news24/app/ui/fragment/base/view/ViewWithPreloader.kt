package com.news24.app.ui.fragment.base.view

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(value = AddToEndSingleStrategy::class)
interface ViewWithPreloader {

    fun showPreloader()

    fun hidePreloader()

}