package com.news24.app.utils

import android.app.Activity
import android.content.res.Resources
import android.os.Build
import android.util.DisplayMetrics
import kotlin.math.ceil

object DeviceUtils {

	fun getStatusBarHeight(resources: Resources): Int {
		val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
		return if (resourceId > 0) {
			resources.getDimensionPixelSize(resourceId)
		} else {
			ceil(((if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) 24 else 25) * resources.displayMetrics.density).toDouble()).toInt()
		}
	}

	fun getWindowWeight(activity: Activity): Int {
		val displayMetrics = DisplayMetrics()
		activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
		return displayMetrics.widthPixels
	}

	fun getActionBarHeight(activity: Activity): Int {
		var actionBarHeight = 0
		val styledAttributes = activity.theme.obtainStyledAttributes(intArrayOf(androidx.appcompat.R.attr.actionBarSize))
		actionBarHeight = styledAttributes.getDimension(0, 0f).toInt()
		styledAttributes.recycle()
		return actionBarHeight
	}

	fun getNavigationBarHeight(resources: Resources): Int {
		var result = 0
		val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
		if (resourceId > 0) {
			result = resources.getDimensionPixelSize(resourceId)
		}
		return result
	}

}