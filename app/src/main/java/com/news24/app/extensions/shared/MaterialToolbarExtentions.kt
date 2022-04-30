package com.news24.app.extensions.shared

import android.text.ParcelableSpan
import com.google.android.material.appbar.MaterialToolbar


fun MaterialToolbar.setTextWithSpan(text: String, spanText: String, styles: List<ParcelableSpan>) {
    this.title = getStylizedSpannableStringBuilder(text, spanText, styles)
}
