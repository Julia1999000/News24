package com.news24.app.ui.fragment.base

import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
import androidx.core.view.updateLayoutParams
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.news24.app.R
import com.news24.app.components.AppContext
import com.news24.app.di.AppComponent
import com.news24.app.extensions.shared.doOnApplyWindowInsets
import com.news24.app.extensions.shared.setVisibility
import com.news24.app.helpers.KeyboardHelper
import com.news24.app.helpers.ResourceIdHelper.getDrawable
import com.news24.app.ui.activity.base.BaseScreenActivity
import com.news24.app.ui.navigation.RouterProvider
import moxy.MvpAppCompatFragment
import ru.terrakok.cicerone.Router


open class BaseFragment : MvpAppCompatFragment() {

    //region ==================== Lifecycle ====================

    override fun onPause() {
        super.onPause()
        KeyboardHelper.hideSoftKeyboard(activity)
    }

    //endregion


    //region ==================== Toast ====================

    protected fun showSnackBar(
        message: String,
        actionText: String? = null,
        action: View.OnClickListener? = null,
        container: View? = null
    ) {
        (activity as BaseScreenActivity?)?.showSnackBar(message, actionText, action, container)
    }

    //endregion


    //region ==================== DI ====================

    fun getAppComponent(): AppComponent {
        return AppContext.instance.appComponent
    }

    protected fun getParentRouter(): Router? {
        parentFragment?.let { parentFragment ->
            if (parentFragment is RouterProvider) {
                return parentFragment.getRouter()
            }
        }

        return null
    }

    //endregion


    //region ==================== Toolbar configuration ====================

    fun setupDisappearingToolbar(
        inflatedView: View,
        @StringRes titleId: Int?,
        @DrawableRes navigationIconId: Int?,
        navigationClickListener: View.OnClickListener?
    ) {
        setupToolbar(inflatedView, true, titleId?.let { resources.getString(it) },
            navigationIconId.getDrawable(inflatedView.context), navigationClickListener
        )
    }

    fun setupStableToolbar(
        inflatedView: View,
        @StringRes titleId: Int?,
        @DrawableRes navigationIconId: Int?,
        navigationClickListener: View.OnClickListener?
    ) {
        setupToolbar(inflatedView, false, titleId?.let { resources.getString(it) },
            navigationIconId.getDrawable(inflatedView.context), navigationClickListener
        )
    }

    fun setupDisappearingToolbar(
        inflatedView: View,
        title: CharSequence?,
        @DrawableRes navigationIconId: Int?,
        navigationClickListener: View.OnClickListener?
    ) {
        setupToolbar(inflatedView, true, title, navigationIconId.getDrawable(inflatedView.context),
            navigationClickListener
        )
    }

    fun setupStableToolbar(
        inflatedView: View,
        title: CharSequence?,
        @DrawableRes navigationIconId: Int?,
        navigationClickListener: View.OnClickListener?
    ) {
        setupToolbar(inflatedView, false, title, navigationIconId.getDrawable(inflatedView.context),
            navigationClickListener
        )
    }

    fun setupToolbar(
        inflatedView: View,
        disappearing: Boolean,
        title: CharSequence?,
        navigationIcon: Drawable?,
        navigationClickListener: View.OnClickListener?
    ) {
        val toolbar = inflatedView.findViewById<AppBarLayout>(R.id.toolbar)
        toolbar?.children?.firstOrNull()?.let {
            if (it is MaterialToolbar) {
                it.title = title ?: ""
                it.navigationIcon = navigationIcon
                it.setNavigationOnClickListener(navigationClickListener)

                (it.layoutParams as AppBarLayout.LayoutParams).apply {
                    scrollFlags = if (disappearing) {
                        (AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                                or AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
                                or AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP)
                    } else {
                        AppBarLayout.LayoutParams.SCROLL_FLAG_NO_SCROLL
                    }
                }
            }
        }
    }

    fun setTitleToolbar(inflatedView: View, title: CharSequence?) {
        val toolbar = inflatedView.findViewById<AppBarLayout>(R.id.toolbar)
        (toolbar?.children?.firstOrNull() as? MaterialToolbar)?.let {
            it.title = title
        }
    }

    fun setVisibilityToolbar(inflatedView: View, isVisible: Boolean) {
        val toolbar = inflatedView.findViewById<AppBarLayout>(R.id.toolbar)
        toolbar.setVisibility(isVisible)
    }

    fun applyWindowInsertsToToolbar(inflatedView: View) {
        val toolbar = inflatedView.findViewById<AppBarLayout>(R.id.toolbar)
        toolbar.doOnApplyWindowInsets { view, insets, padding ->
            toolbar.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                this.topMargin = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            }
        }
    }

    //endregion


    //region ===================== Show dialogs ======================

    fun showShareDialog(url: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "${resources.getString(R.string.sharing_title)} $url")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    //endregion


    //region ==================== Configuration ====================

    //endregion

}