package com.news24.app.ui.fragment.base.view

import androidx.fragment.app.FragmentManager
import com.news24.app.ui.fragment.preloaderdialog.PreloaderDialogFragment


interface FragmentWithPreloader: ViewWithPreloader {

    fun getChildFragmentManager(): FragmentManager

    override fun showPreloader() {
        PreloaderDialogFragment.show(getChildFragmentManager())
    }

    override fun hidePreloader() {
        PreloaderDialogFragment.hide(getChildFragmentManager())
    }

}