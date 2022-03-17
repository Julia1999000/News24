package com.news24.app.ui.fragment.base

import android.view.View
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import com.news24.app.components.AppContext
import com.news24.app.di.AppComponent
import com.news24.app.helpers.KeyboardHelper
import com.news24.app.ui.activity.base.BaseActivity
import com.news24.app.ui.navigation.RouterProvider
import com.news24.app.utils.DeviceUtils
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

	protected fun showSnackBar(message: String, actionText: String? = null, action: View.OnClickListener? = null, container: View? = null) {
		(activity as BaseActivity?)?.showSnackBar(message, actionText, action, container)
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


	//region ==================== Configuration ====================

	protected fun setMarginBelowStatusBar(inflatedView: View) {
		inflatedView.setOnApplyWindowInsetsListener { view, insets ->
			view.updateLayoutParams {
				(this as ViewGroup.MarginLayoutParams).topMargin += DeviceUtils.getStatusBarHeight(resources)
			}
			insets
		}
	}

	//endregion

}