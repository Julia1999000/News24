package com.news24.app.ui.fragment.preloaderdialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.airbnb.lottie.LottieAnimationView
import com.news24.app.R
import com.news24.app.databinding.FragmentPreloaderDialogBinding
import com.news24.app.ui.fragment.base.BaseDialogFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider


class PreloaderDialogFragment : BaseDialogFragment(), PreloaderDialogContract.View {

    @InjectPresenter
    lateinit var presenter: PreloaderDialogContract.Presenter

    @Inject
    lateinit var presenterProvider: Provider<PreloaderDialogContract.Presenter>

    private lateinit var progressIndicator: LottieAnimationView

    private val fragmentBinding by lazy { FragmentPreloaderDialogBinding.inflate(layoutInflater) }

    private var mStartTime: Long = -1L

    private var mPostedHide = false

    private var mPostedShow = false

    private var mDismissed = false

    private val mDelayedHide = Runnable {
        mPostedHide = false
        mStartTime = -1
        val parentFragmentManager = this.mParentFragmentManager
        (parentFragmentManager?.findFragmentByTag(FRAGMENT_TAG) as? PreloaderDialogFragment)?.let {
            it.dismissAllowingStateLoss()
            parentFragmentManager.executePendingTransactions()
        }
    }

    private val mDelayedShow = Runnable {
        mPostedShow = false
        if (!mDismissed) {
            mStartTime = System.currentTimeMillis()
            view?.visibility = View.VISIBLE
        }
    }

    private var mParentFragmentManager: FragmentManager? = null


    //region ==================== Fragment creation and static methods ====================

    companion object {

        private const val MIN_SHOW_TIME = 200L // ms
        private const val MIN_DELAY = 200L // ms

        private const val FRAGMENT_TAG = "preloader_fragment_tag"

        fun newInstance(): PreloaderDialogFragment {
            val args = Bundle()

            val fragment = PreloaderDialogFragment()
            fragment.arguments = args

            return fragment
        }

        fun show(fragmentManager: FragmentManager) {
            val preloaderFragment = fragmentManager.findFragmentByTag(FRAGMENT_TAG) as? PreloaderDialogFragment
            if (preloaderFragment == null) {
                newInstance().show(fragmentManager, FRAGMENT_TAG)
                fragmentManager.executePendingTransactions()
            } else {
                Timber.w("Preloader fragment already exist!")
            }
        }

        fun hide(fragmentManager: FragmentManager) {
            (fragmentManager.findFragmentByTag(FRAGMENT_TAG) as? PreloaderDialogFragment).let {
                it?.remove(fragmentManager)
            }
        }
    }

    //endregion


    //region ==================== Lifecycle ====================

    override fun onAttach(context: Context) {
        super.onAttach(context)
        removeCallbacks()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        configureDI()
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.FullScreenDialog)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI(view)
        show()
    }

    override fun onStart() {
        super.onStart()
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog!!.window!!.setLayout(width, height)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onDetach() {
        super.onDetach()
        removeCallbacks()
    }

    //endregion


    //region ==================== DI ====================

    private fun configureDI() {
        val component = getAppComponent().plus(PreloaderDialogModule())
        component.inject(this)
    }

    @ProvidePresenter
    internal fun providePresenter(): PreloaderDialogContract.Presenter {
        return presenterProvider.get()
    }

    //endregion

    //region ==================== UI ====================

    private fun initUI(view: View) {
        progressIndicator = fragmentBinding.animationView
    }

    private fun removeCallbacks() {
        view?.removeCallbacks(mDelayedHide)
        view?.removeCallbacks(mDelayedShow)
        this.mParentFragmentManager = null
    }

    /**
     * Removes the progress fragment if it is visible. The progress fragment will not be
     * removed until it has been shown for at least a minimum show time. If the
     * progress fragment was not yet visible, cancels showing the progress fragment.
     */
    public fun remove(parentFragmentManager: FragmentManager? = null) {
        mDismissed = true
        view?.removeCallbacks(mDelayedShow)
        this.mParentFragmentManager = null
        val diff = System.currentTimeMillis() - mStartTime
        if (diff >= MIN_SHOW_TIME || mStartTime == -1L) {
            // The progress view has been shown long enough
            // OR was not shown yet. If it wasn't shown yet,
            // it will just never be shown.
            (parentFragmentManager?.findFragmentByTag(FRAGMENT_TAG) as? PreloaderDialogFragment)?.let {
                it.dismissAllowingStateLoss()
                parentFragmentManager.executePendingTransactions()
            }
        } else {
            // The progress fragment is shown, but not long enough,
            // so put a delayed message in to remove it when its been
            // shown long enough.
            if (!mPostedHide) {
                this.mParentFragmentManager = parentFragmentManager
                view?.postDelayed(mDelayedHide, MIN_SHOW_TIME - diff)
                mPostedHide = true
            }
        }
    }

    /**
     * Show the progress fragment after waiting for a minimum delay. If
     * during that time, remove() is called, the fragment is never made visible.
     */
    private fun show() {
        // Reset the start time.
        mStartTime = -1
        mDismissed = false
        view?.removeCallbacks(mDelayedHide)
        if (!mPostedShow) {
            view?.postDelayed(mDelayedShow, MIN_DELAY)
            mPostedShow = true
        }
    }

    //endregion

}