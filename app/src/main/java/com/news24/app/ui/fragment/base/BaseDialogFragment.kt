package com.news24.app.ui.fragment.base

import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import com.news24.app.components.AppContext
import com.news24.app.di.AppComponent
import com.news24.app.helpers.KeyboardHelper
import com.news24.app.ui.activity.base.BaseScreenActivity
import com.news24.app.ui.navigation.RouterProvider
import moxy.MvpAppCompatDialogFragment
import ru.terrakok.cicerone.Router


open class BaseDialogFragment : MvpAppCompatDialogFragment() {

    //region ==================== Lifecycle ====================

    override fun onPause() {
        super.onPause()
        KeyboardHelper.hideSoftKeyboard(activity)
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

    //region ==================== Toast ====================

    protected fun showSnackBar(
        message: String,
        actionText: String? = null,
        action: View.OnClickListener? = null,
        container: View? = null
    ) {
        (activity as BaseScreenActivity?)?.showSnackBar(message, actionText, action, container)
    }

    protected fun showToastMessage(message: String?) {
        message?.let {
            activity?.let {
                Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
            }

        }
    }

    protected fun showToastMessage(@StringRes stringResId: Int) {
        activity?.let {
            Toast.makeText(it, stringResId, Toast.LENGTH_SHORT).show()
        }
    }

    //endregion

}