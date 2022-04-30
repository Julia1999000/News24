package com.news24.app.extensions.shared

import android.os.Build
import android.text.ParcelableSpan
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.widget.TextView
import androidx.annotation.StyleRes


fun TextView.setTextStyle(@StyleRes idStyle: Int) {
	if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
		this.setTextAppearance(this.context, idStyle)
	} else {
		this.setTextAppearance(idStyle)
	}
}

fun TextView.setTextWithSpan(text: String, spanText: String, styles: List<ParcelableSpan>) {
	this.text = getStylizedSpannableStringBuilder(text, spanText, styles)
}

fun getStylizedSpannableStringBuilder(text: String, spanText: String, styles: List<ParcelableSpan>):
		SpannableStringBuilder
{
	val sb = SpannableStringBuilder(text)
	val start = text.indexOf(spanText)
	val end = start + spanText.length
	styles.forEach {
		sb.setSpan(it, start, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
	}
	return sb
}