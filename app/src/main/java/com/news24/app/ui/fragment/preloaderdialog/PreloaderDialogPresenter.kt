package com.news24.app.ui.fragment.preloaderdialog

import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject


@InjectViewState
class PreloaderDialogPresenter @Inject constructor(private val router: Router) : PreloaderDialogContract.Presenter() {

    //region ==================== MVP Presenter ====================

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }

    //endregion


    //region ==================== PreloaderDialogContract.Presenter ====================

    //endregion

}