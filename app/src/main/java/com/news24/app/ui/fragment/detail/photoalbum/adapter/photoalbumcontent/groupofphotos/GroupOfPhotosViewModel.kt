package com.news24.app.ui.fragment.detail.photoalbum.adapter.photoalbumcontent.groupofphotos

import androidx.annotation.Keep
import com.news24.app.ui.adapter.GridListViewModel
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.fragment.detail.photoalbum.adapter.photoalbumcontent.onephoto.OnePhotoViewModel


@Keep
data class GroupOfPhotosViewModel(
        override var listItemId: String?,
        override var spanSize: Int,
        val topLeftPhoto: OnePhotoViewModel,
        val topRightPhoto: OnePhotoViewModel,
        val bottomLeftPhoto: OnePhotoViewModel,
        val bottomRightPhoto: OnePhotoViewModel
) : GridListViewModel