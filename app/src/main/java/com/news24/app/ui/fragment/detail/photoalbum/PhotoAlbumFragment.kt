package com.news24.app.ui.fragment.detail.photoalbum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.doOnLayout
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.news24.app.R
import com.news24.app.databinding.FragmentPhotoAlbumBinding
import com.news24.app.extensions.shared.doOnApplyWindowInsets
import com.news24.app.extensions.shared.setVisibility
import com.news24.app.helpers.DimensHelper.dpToPx
import com.news24.app.helpers.DimensHelper.pxToDp
import com.news24.app.helpers.ImageHelper
import com.news24.app.helpers.SpanTextHelper
import com.news24.app.ui.adapter.GridListViewModel
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.adapter.listener.ListItemClickListener
import com.news24.app.ui.fragment.base.BaseFragment
import com.news24.app.ui.fragment.detail.photoalbum.adapter.PhotoAlbumAdapter
import com.news24.app.ui.fragment.detail.photoalbum.model.PhotoAlbumScreenParams
import com.news24.app.ui.widget.EventActionPanelView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider


class PhotoAlbumFragment : BaseFragment(), PhotoAlbumContract.View {

    @InjectPresenter
    lateinit var presenter: PhotoAlbumContract.Presenter

    @Inject
    lateinit var presenterProvider: Provider<PhotoAlbumContract.Presenter>

    @Inject
    lateinit var adapter: PhotoAlbumAdapter

    private val fragmentBinding by lazy { FragmentPhotoAlbumBinding.inflate(layoutInflater) }

    //region ===================== Fragment creation ======================

    companion object {
        private const val KEY_PARAMS = "KEY_PARAMS"
        const val CONTENT_COLUMNS_COUNT = 2
        private const val TOP_CORNER_RADIUS_DP = 16
        private const val BOTTOM_CORNER_RADIUS_PX = 0f

        fun newInstance(params: PhotoAlbumScreenParams): PhotoAlbumFragment {
            val fragment = PhotoAlbumFragment()
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

    private val itemClickListener = object : ListItemClickListener {
        override fun onListItemClicked(delegateViewModel: ListViewModel) {
            presenter.onListItemClicked(delegateViewModel)
        }
    }

    private val actionPanelListener = object : EventActionPanelView.EventActionPanelListener {
        override fun onReadFurther() {
            presenter.onReadFurtherClicked()
        }

        override fun onShareClicked() {
            presenter.onShareClicked()
        }
    }

    private val btnBackClickListener = View.OnClickListener { presenter.onBackClicked() }

    private val onPhotosSpanSizeProvider = object: GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
            return (adapter.items[position] as? GridListViewModel)?.spanSize ?: CONTENT_COLUMNS_COUNT
        }
    }

    private val scrollChangedListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            fragmentBinding.apply {
                val layoutManager = rvContent.layoutManager as GridLayoutManager
                val lastVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition()
                if (lastVisibleItemPosition  > 0 && lastVisibleItemPosition >= adapter.itemCount - 1) {
                    hideGradientBottom()
                } else {
                    showGradientBottom()
                }

                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                upperFlashingGradient.setVisibility(firstVisibleItemPosition > 0)
            }
        }
    }

    //endregion


    //region ==================== PhotoAlbumContract.View ====================

    override fun showBackground(imgBack: String) {
        ImageHelper.loadImageByUrlToImageView(imgBack, fragmentBinding.ivBackground, ImageHelper.CENTER_CROP)
    }

    override fun showData(list: List<ListViewModel>) {
        adapter.swapItems(list)
    }

    override fun sharePhotoAlbum(url: String) {
        showShareDialog(url)
    }

    //endregion


    //region ===================== DI ======================

    private fun configureDI() {
        val params = requireArguments().getParcelable<PhotoAlbumScreenParams>(KEY_PARAMS)!!

        val component = getAppComponent().plus(PhotoAlbumModule(requireActivity(), itemClickListener, params))
        component.inject(this)
    }

    @ProvidePresenter
    internal fun providePresenter(): PhotoAlbumContract.Presenter {
        return presenterProvider.get()
    }

    //endregion


    //region ===================== UI ======================

    private fun initUI(view: View) {
        val title = SpanTextHelper.getSpannableStringBuilderWithAddedIcon(requireContext(), R.drawable.ic_top,
            resources.getString(R.string.common_top)
        )
        setupStableToolbar(view, title, R.drawable.ic_back, btnBackClickListener)

        fragmentBinding.apply {
            TOP_CORNER_RADIUS_DP.dpToPx(requireContext()).toFloat().let { radius ->
                contentContainer.setCorners(radius, radius, BOTTOM_CORNER_RADIUS_PX, BOTTOM_CORNER_RADIUS_PX)
            }

            val gridLayoutManager =  GridLayoutManager(context, CONTENT_COLUMNS_COUNT)
            gridLayoutManager.spanSizeLookup = onPhotosSpanSizeProvider
            rvContent.layoutManager = gridLayoutManager
            rvContent.adapter = adapter
            rvContent.addOnScrollListener(scrollChangedListener)

            bottomPanel.listener = actionPanelListener
            bottomPanel.doOnApplyWindowInsets { view, insets, padding ->
                bottomPanel.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                    this.bottomMargin = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom
                }
            }
            bottomPanel.doOnLayout {
                presenter.setOffset(it.height.pxToDp(requireContext()))
            }
        }
    }

    private fun hideGradientBottom() {
        fragmentBinding.lowerFlashingGradient.setVisibility(false)
    }

    private fun showGradientBottom() {
        fragmentBinding.lowerFlashingGradient.setVisibility(true)
    }

    //endregion

}