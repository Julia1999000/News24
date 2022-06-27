package com.news24.app.ui.fragment.detail.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.news24.app.R
import com.news24.app.databinding.FragmentArticleBinding
import com.news24.app.extensions.shared.setVisibility
import com.news24.app.helpers.DimensHelper.dpToPx
import com.news24.app.helpers.ImageHelper
import com.news24.app.helpers.SpanTextHelper
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.fragment.base.BaseFragment
import com.news24.app.ui.fragment.detail.article.adapter.ArticleAdapter
import com.news24.app.ui.fragment.detail.article.model.ArticleScreenParams
import com.news24.app.ui.widget.EventActionPanelView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider


class ArticleFragment: BaseFragment(), ArticleContract.View {

    @InjectPresenter
    lateinit var presenter: ArticleContract.Presenter

    @Inject
    lateinit var presenterProvider: Provider<ArticleContract.Presenter>

    @Inject
    lateinit var adapter: ArticleAdapter

    private val fragmentBinding by lazy { FragmentArticleBinding.inflate(layoutInflater) }

    //region ===================== Fragment creation ======================

    companion object {
        private const val KEY_PARAMS = "KEY_PARAMS"
        private const val TOP_CORNER_RADIUS_DP = 16
        private const val BOTTOM_CORNER_RADIUS_PX = 0f

        fun newInstance(params: ArticleScreenParams): ArticleFragment {
            val fragment = ArticleFragment()
            fragment.arguments = Bundle().apply {
                putParcelable(KEY_PARAMS, params)
            }

            return fragment
        }
    }

    //endregion


    //region ===================== Lifecycle ======================

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

    private val actionPanelListener = object : EventActionPanelView.EventActionPanelListener {
        override fun onReadFurther() {
            presenter.onReadFurtherClicked()
        }

        override fun onShareClicked() {
            presenter.onShareClicked()
        }
    }

    private val btnBackClickListener = View.OnClickListener { presenter.onBackClicked() }

    private val scrollChangedListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            fragmentBinding.rvContent.let {
                val layoutManager = fragmentBinding.rvContent.layoutManager as LinearLayoutManager
                val lastVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition()
                presenter.onScrollChange(lastVisibleItemPosition)
            }
        }
    }

    //endregion


    //region ==================== ArticleContract.View ====================

    override fun setTestHeader(text: String) {
        fragmentBinding.tvTest.text = text
    }

    override fun showBackground(imgBack: String) {
        ImageHelper.loadImageByUrlToImageView(imgBack, fragmentBinding.ivBackground, ImageHelper.CENTER_CROP)
    }

    override fun showData(list: List<ListViewModel>) {
        adapter.swapItems(list)
    }

    override fun shareArticle(url: String) {
        showShareDialog(url)
    }

    override fun hideGradientBottom() {
        fragmentBinding.lowerFlashingGradient.setVisibility(false)
    }

    override fun showGradientBottom() {
        fragmentBinding.lowerFlashingGradient.setVisibility(true)
    }

    //endregion


    //region ===================== DI ======================

    private fun configureDI() {
        val params = requireArguments().getParcelable<ArticleScreenParams>(KEY_PARAMS)!!

        val component = getAppComponent().plus(ArticleModule(requireActivity(), params))
        component.inject(this)
    }

    @ProvidePresenter
    internal fun providePresenter(): ArticleContract.Presenter {
        return presenterProvider.get()
    }

    //endregion


    //region ===================== UI ======================

    private fun initUI(view: View) {
        val title = SpanTextHelper.getSpannableStringBuilderWithAddedIcon(requireContext(), R.drawable.ic_top,
            resources.getString(R.string.common_top))
        setupStableToolbar(view, title, R.drawable.ic_back, btnBackClickListener)

        fragmentBinding.apply {
            TOP_CORNER_RADIUS_DP.dpToPx(requireContext()).toFloat().let { radius ->
                contentContainer.setCorners(radius, radius, BOTTOM_CORNER_RADIUS_PX, BOTTOM_CORNER_RADIUS_PX)
            }

            rvContent.layoutManager = LinearLayoutManager(context)
            rvContent.adapter = adapter
            rvContent.addOnScrollListener(scrollChangedListener)

            bottomPanel.listener = actionPanelListener
            bottomPanel.doOnLayout {
                presenter.setHeightListViewModel(tvTest.height, ivBackground.height)
            }
        }
    }

    //endregion


    //region ===================== Internal ======================


    //endregion

}