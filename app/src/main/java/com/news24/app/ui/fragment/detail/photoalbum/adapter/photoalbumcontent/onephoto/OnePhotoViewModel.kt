package com.news24.app.ui.fragment.detail.photoalbum.adapter.photoalbumcontent.onephoto

import androidx.annotation.Keep
import com.news24.app.ui.adapter.GridListViewModel


@Keep
data class OnePhotoViewModel(
        override var listItemId: String?,
        override var spanSize: Int,
        val photoUrl: String
) : GridListViewModel