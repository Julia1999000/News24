package com.news24.app.ui.fragment.webview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.news24.app.R
import com.news24.app.databinding.FragmentWebViewBinding
import com.news24.app.helpers.SpanTextHelper
import com.news24.app.ui.fragment.base.BaseFragment
import com.news24.app.ui.fragment.webview.model.WebViewParams
import com.news24.app.ui.fragment.webview.webviewclient.CustomWebViewClient
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider


class WebViewFragment : BaseFragment(), WebViewContract.View {

    @InjectPresenter
    lateinit var presenter: WebViewContract.Presenter

    @Inject
    lateinit var presenterProvider: Provider<WebViewContract.Presenter>

    @Inject
    lateinit var webViewClient: CustomWebViewClient

    private val fragmentBinding by lazy { FragmentWebViewBinding.inflate(layoutInflater) }

    //region ==================== Fragment creation ====================

    companion object {
        private const val KEY_PARAMS = "KEY_PARAMS"

        fun newInstance(webViewParams: WebViewParams): WebViewFragment {
            val fragment = WebViewFragment()
            fragment.arguments = Bundle().apply {
                putParcelable(KEY_PARAMS, webViewParams)
            }
            return fragment
        }
    }

    //endregion


    //region ==================== Lifecycle ====================

    override fun onCreate(savedInstanceState: Bundle?) {
        configureDI()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI(view)
    }

    //endregion


    //region ==================== UI handlers ====================

    private val btnBackClickListener = View.OnClickListener { presenter.onBackButtonClicked() }

    //endregion


    //region ==================== WebViewContract.View ====================

    override fun showPage(url: String) {
        fragmentBinding.wvContainer.loadUrl(url)
    }

    //endregion


    //region ==================== DI ====================

    private fun configureDI() {
        val params = requireArguments().getParcelable<WebViewParams>(KEY_PARAMS)!!
        val component = getAppComponent().plus(WebViewModule(params, getParentRouter()))
        component.inject(this)
    }

    @ProvidePresenter
    internal fun providePresenter(): WebViewContract.Presenter {
        return presenterProvider.get()
    }

    //endregion


    //region ==================== UI ====================

    private fun initUI(view: View) {
        val title = SpanTextHelper.getSpannableStringBuilderWithAddedIcon(requireContext(), R.drawable.ic_top,
            resources.getString(R.string.common_top))
        setupStableToolbar(view, title, R.drawable.ic_back, btnBackClickListener)

        fragmentBinding.apply {
            wvContainer.webViewClient = webViewClient
        }

    }

    //endregion

}