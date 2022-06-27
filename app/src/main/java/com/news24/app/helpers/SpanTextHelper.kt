package com.news24.app.helpers

import android.content.Context
import android.os.Build
import android.text.ParcelableSpan
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.DynamicDrawableSpan
import android.text.style.ImageSpan
import androidx.annotation.DrawableRes


object SpanTextHelper {

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

    fun getSpannableStringBuilderWithAddedIcon(context: Context, @DrawableRes icon: Int, text: String):
            SpannableStringBuilder
    {
        val imageSpan = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ImageSpan(context, icon, DynamicDrawableSpan.ALIGN_CENTER)
        } else {
            ImageSpan(context, icon, DynamicDrawableSpan.ALIGN_BASELINE)
        }
        val spannableText = SpannableStringBuilder("*$text")
        spannableText.setSpan(imageSpan,0,1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannableText
    }
}