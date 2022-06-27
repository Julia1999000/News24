package com.news24.app.extensions.shared

import android.os.Build
import android.text.ParcelableSpan
import android.widget.TextView
import androidx.annotation.StyleRes
import com.news24.app.helpers.SpanTextHelper


fun TextView.setTextStyle(@StyleRes idStyle: Int) {

	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
		this.setTextAppearance(idStyle)
	} else {
		this.setTextAppearance(this.context, idStyle)
	}
}

fun TextView.setTextWithSpan(text: String, spanText: String, styles: List<ParcelableSpan>) {
	this.text = SpanTextHelper.getStylizedSpannableStringBuilder(text, spanText, styles)
}