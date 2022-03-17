package com.news24.app.extensions.shared

import android.graphics.Rect
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

fun View.doOnApplyWindowInsets(f: (View, WindowInsetsCompat, Rect) -> Unit) {
	val initialPadding = recordInitialPaddingForView(this)
	ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
		f(v, insets, initialPadding)
		insets
	}
	// request some insets
	requestApplyInsetsWhenAttached()
}

private fun recordInitialPaddingForView(view: View) = Rect(
		view.paddingLeft, view.paddingTop, view.paddingRight, view.paddingBottom
)

fun View.requestApplyInsetsWhenAttached() {
	if (isAttachedToWindow) {
		// We're already attached, just request as normal
		requestApplyInsets()
	} else {
		// We're not attached to the hierarchy, add a listener to
		// request when we are
		addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
			override fun onViewAttachedToWindow(v: View) {
				v.removeOnAttachStateChangeListener(this)
				v.requestApplyInsets()
			}

			override fun onViewDetachedFromWindow(v: View) = Unit
		})
	}
}
