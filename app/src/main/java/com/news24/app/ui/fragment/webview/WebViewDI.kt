package com.news24.app.ui.fragment.webview

import com.news24.app.ui.fragment.webview.model.WebViewParams
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import ru.terrakok.cicerone.Router


@Subcomponent(modules = [WebViewModule::class])
interface WebViewComponent {

    fun inject(fragment: WebViewFragment)

}


@Module
class WebViewModule(
    private val params: WebViewParams,
    private val router: Router? = null
) {

    @Provides
    fun provideParams(): WebViewParams {
        return params
    }

    @Provides
    fun presenter(presenter: WebViewPresenter): WebViewContract.Presenter {
        return presenter
    }

}