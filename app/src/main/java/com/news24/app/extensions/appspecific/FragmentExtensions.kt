package com.news24.app.extensions.appspecific

import androidx.fragment.app.Fragment
import com.news24.app.ui.navigation.BackButtonListener

fun Fragment.isClickedInFragmentBackListener(): Boolean {
	return this is BackButtonListener && (this as BackButtonListener).onBackPressed()
}