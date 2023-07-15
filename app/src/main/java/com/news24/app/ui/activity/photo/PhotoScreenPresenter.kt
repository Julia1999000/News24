package com.news24.app.ui.activity.photo

import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject


@InjectViewState
class PhotoScreenPresenter @Inject constructor(
        private val router: Router,
        private val startScreen: SupportAppScreen?
): PhotoScreenContract.Presenter() {

    //region ==================== MVP Presenter ====================

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(startScreen)
    }

    //endregion


    //region ==================== PhotoScreenContract.Presenter ====================

    //endregion

}