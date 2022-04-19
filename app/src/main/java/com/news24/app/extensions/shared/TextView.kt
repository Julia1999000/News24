package com.news24.app.extensions.shared

import android.os.Build
import android.widget.TextView
import androidx.annotation.StyleRes


fun TextView.setTextStyle(@StyleRes idStyle: Int) {
	/*if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
		this.setTextAppearance(this.context, idStyle)
	} else {
		this.setTextAppearance(idStyle)
	}*/
}
