package com.news24.app.ui.fragment.webview

import com.news24.app.ui.fragment.webview.model.WebViewParams
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject


@InjectViewState
class WebViewPresenter @Inject constructor(
        private val router: Router,
        private val params: WebViewParams
) : WebViewContract.Presenter() {

    //region ==================== MVP Presenter ====================

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showPage(params.url)
    }

    //endregion


    //region ==================== WebViewContract.Presenter ====================

    override fun onBackButtonClicked() {
        router.exit()
    }

    //endregion

}