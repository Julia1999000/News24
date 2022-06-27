package com.news24.app.ui.adapter.delegates.separator

import androidx.annotation.ColorRes
import androidx.annotation.Keep
import com.news24.app.ui.adapter.ListViewModel


@Keep
data class SeparatorViewModel(
        @ColorRes val colorResId: Int,
        val heightDp: Int = 0,
        val horizontalMarginDp: Int = 0
) : ListViewModel