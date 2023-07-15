package com.news24.app.ui.fragment.photoviewer

import android.os.Bundle
import android.view.*
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.updateLayoutParams
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.news24.app.R
import com.news24.app.databinding.FragmentPhotoViewerBinding
import com.news24.app.extensions.shared.doOnApplyWindowInsets
import com.news24.app.helpers.DimensHelper.dpToPx
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.adapter.listener.ListItemClickListener
import com.news24.app.ui.fragment.base.BaseFragment
import com.news24.app.ui.fragment.photoviewer.adapter.PhotoPagerAdapter
import com.news24.app.ui.fragment.photoviewer.adapter.PhotoViewModel
import com.news24.app.ui.fragment.photoviewer.adapter.PhotoViewerAdapter
import com.news24.app.ui.fragment.photoviewer.model.PhotoViewerScreenParams
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider


class PhotoViewerFragment : BaseFragment(), PhotoViewerContract.View {

    @InjectPresenter
    lateinit var presenter: PhotoViewerContract.Presenter

    @Inject
    lateinit var presenterProvider: Provider<PhotoViewerContract.Presenter>

    @Inject
    lateinit var adapter: PhotoViewerAdapter

    @Inject
    lateinit var adapterVP: PhotoPagerAdapter

    private val fragmentBinding by lazy { FragmentPhotoViewerBinding.inflate(layoutInflater) }

    private var isToolbarShown = true

    private var systemUiVisibilityStatus = 0

    //region ===================== Fragment creation ======================

    companion object {
        private const val KEY_PARAMS = "KEY_PARAMS"
        private const val MARGIN_PAGE_DP = 10

        fun newInstance(params: PhotoViewerScreenParams): PhotoViewerFragment {
            val fragment = PhotoViewerFragment()
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

    private val btnBackClickListener = View.OnClickListener { presenter.onBackClicked() }

    private val pagerCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            setPositionInToolbar(position)
        }
    }

    private val itemClickListener = object : ListItemClickListener {
        override fun onListItemClicked(delegateViewModel: ListViewModel) {
            if (isToolbarShown) {
                hideSystemUI()
                //hideToolbar()
            } else {
                showSystemUI()
                //showToolbar()
            }
            isToolbarShown = !isToolbarShown


/*            ((requireActivity().window.decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_HIDE_NAVIGATION) == 0).let {
                if (it) {
                    //hideToolbar()
                    hideSystemUI()
                } else {
                    showSystemUI()
                   // showToolbar()
                }
            }*/

        }
    }

    private val onPageChangeCallback = object : ViewPager.SimpleOnPageChangeListener() {
        override fun onPageSelected(position: Int) {
            setPositionInToolbar(position)
        }
    }

    //endregion


    //region ==================== PhotoViewerContract.View ====================

    override fun showItemList(items: List<PhotoViewModel>) {
        adapter.swapItems(items)
    }

    override fun setCurrentItem(position: Int) {
        fragmentBinding.photosSlider.setCurrentItem(position, false)
        setPositionInToolbar(position)
    }

    //endregion


    //region ===================== DI ======================

    private fun configureDI() {
        val params = requireArguments().getParcelable<PhotoViewerScreenParams>(KEY_PARAMS)!!

        val component =
            getAppComponent().plus(PhotoViewerModule(requireActivity(), params, itemClickListener))
        component.inject(this)
    }

    @ProvidePresenter
    internal fun providePresenter(): PhotoViewerContract.Presenter {
        return presenterProvider.get()
    }

    //endregion


    //region ===================== UI ======================

    private fun initUI(view: View) {
    /*  requireActivity().window.decorView.setOnSystemUiVisibilityChangeListener(object : View.OnSystemUiVisibilityChangeListener {
    override fun onSystemUiVisibilityChange(visibility: Int) {
        if ((visibility and  View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
            // TODO: The system bars are visible. Make any desired

        } else {
            // TODO: The system bars are NOT visible. Make any desired

        }
    }
    })*/

        systemUiVisibilityStatus = requireActivity().window.decorView.systemUiVisibility
        applyWindowInsertsToToolbar(view)
        setupStableToolbar(view, null as String?, R.drawable.ic_back, btnBackClickListener)

        fragmentBinding.apply {
            photosSlider.setPageTransformer(
                MarginPageTransformer(
                    MARGIN_PAGE_DP.dpToPx(
                        requireContext()
                    )
                )
            )
            photosSlider.adapter = adapter
            photosSlider.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER
            //photosSlider.addOnPageChangeListener(onPageChangeCallback)
            photosSlider.registerOnPageChangeCallback(pagerCallback)
        }

/*        requireActivity().window.decorView.setOnSystemUiVisibilityChangeListener { flags ->
            (flags and View.SYSTEM_UI_FLAG_HIDE_NAVIGATION == 0).let { visible ->
            controlsView.animate()
                .alpha(1.takeIf {visible} ?: 0)
                .translationY(0.takeIf {visible} ?: controlsView.getHeight())
            }
        }*/

/*        requireActivity().window.decorView.setOnApplyWindowInsetsListener { v, insets ->
            if (insets.isVisible(WindowInsetsCompat.Type.navigationBars())) {

            }
            return@setOnApplyWindowInsetsListener insets
        }*/


/*
        fragmentBinding.photosSlider.isClickable = true
        val clickDetector: GestureDetector = GestureDetector(requireContext(), object : SimpleOnGestureListener() {
                override fun onSingleTapUp(e: MotionEvent): Boolean {
                    val visible = (requireActivity().window.decorView.systemUiVisibility
                            and View.SYSTEM_UI_FLAG_HIDE_NAVIGATION) == 0
                    if (visible) {
                        hideSystemUI()
                    } else {
                        showSystemUI()
                    }
                    return true
                }
            })
        fragmentBinding.photosSlider.setOnTouchListener { v, event -> clickDetector.onTouchEvent(event) }
        */
    }

    private fun setPositionInToolbar(position: Int) {
        val title = resources.getString(R.string.photo_viewer_toolbar, position + 1, adapter.itemCount)
        setTitleToolbar(fragmentBinding.root, title)
    }

    private fun showToolbar() {
        setVisibilityToolbar(fragmentBinding.root, true)
    }

    private fun hideToolbar() {
        setVisibilityToolbar(fragmentBinding.root, false)
    }

    private fun hideSystemUI() {
        val windowInsetsControllerCompat = ViewCompat.getWindowInsetsController(fragmentBinding.root)
        windowInsetsControllerCompat?.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsControllerCompat?.hide(WindowInsetsCompat.Type.systemBars())

        val windowInsetsCompat = ViewCompat.getRootWindowInsets(fragmentBinding.root)
        val displayCutout = windowInsetsCompat?.displayCutout

        val s = 4

      /* requireActivity().window.decorView.systemUiVisibility = (
                systemUiVisibilityStatus or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_IMMERSIVE

                )*/

        /*
               if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                   val controller: WindowInsetsController? = requireActivity().window.insetsController
                   controller?.hide(WindowInsets.Type.statusBars())
               } else {
                   requireActivity().window.decorView.systemUiVisibility =
                       (View.SYSTEM_UI_FLAG_FULLSCREEN
                               or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                               or View.SYSTEM_UI_FLAG_IMMERSIVE
                               or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                               or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                               or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                               )
               }*/

        //requireActivity().window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    private fun showSystemUI() {
        val windowInsetsControllerCompat = ViewCompat.getWindowInsetsController(fragmentBinding.root)
        windowInsetsControllerCompat?.show(WindowInsetsCompat.Type.systemBars())

        //requireActivity().window.decorView.systemUiVisibility = systemUiVisibilityStatus
    }

    //endregion

}