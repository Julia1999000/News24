package com.news24.app.helpers

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewTreeObserver
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import com.news24.app.R

object KeyboardHelper {

	fun hideSoftKeyboard(activity: Activity?) {
		if (activity == null) {
			return
		}

		if (activity.currentFocus != null) {
			val inputManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
			inputManager.hideSoftInputFromWindow(activity.currentFocus!!.windowToken,
					InputMethodManager.HIDE_NOT_ALWAYS)
		} else {
			activity.window.setSoftInputMode(
					WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
		}
	}

	fun removeKeyboardListener(rootView: View) {
		val listener = rootView.getTag(R.id.keyboard_listener_id)
		if (listener != null && listener is ViewTreeObserver.OnGlobalLayoutListener) {
			rootView.viewTreeObserver.removeOnGlobalLayoutListener(listener)
		}
	}

	fun showSoftKeyboard(activity: Context?, view: View) {
		if (activity != null) {
			val inputManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
			inputManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
		}
	}

}