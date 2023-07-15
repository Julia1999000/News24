package com.news24.app.ui.fragment.photoviewer.adapter

import com.news24.app.ui.adapter.DiffAdapter
import javax.inject.Inject


class PhotoViewerAdapter @Inject constructor(
        photoViewModelDelegate: PhotoViewModelDelegate
): DiffAdapter() {

    init {
        delegatesManager.addDelegate(photoViewModelDelegate)
    }

}