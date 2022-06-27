package com.news24.app.ui.adapter.delegates.textview

import androidx.annotation.Keep
import androidx.annotation.StyleRes
import com.news24.app.R
import com.news24.app.ui.adapter.ListViewModel


@Keep
data class TextViewModel(
        val text: String,
        @StyleRes val styleId: Int,
        val horizontalPaddingDp: Int = 0,
        val backgroundId: Int = R.color.transparent,
        val bottomPaddingDp: Int = 0,
) : ListViewModel