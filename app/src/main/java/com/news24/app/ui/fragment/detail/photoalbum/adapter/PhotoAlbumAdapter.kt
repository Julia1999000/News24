package com.news24.app.ui.fragment.detail.photoalbum.adapter

import com.news24.app.ui.adapter.DiffAdapter
import com.news24.app.ui.adapter.delegates.separator.SeparatorViewModelDelegate
import com.news24.app.ui.adapter.delegates.textview.TextViewModelDelegate
import com.news24.app.ui.fragment.detail.news.adapter.tagscontainer.TagsContainerViewModelDelegate
import com.news24.app.ui.fragment.detail.photoalbum.adapter.countphotos.CountPhotosViewModelDelegate
import com.news24.app.ui.fragment.detail.photoalbum.adapter.photoalbumcontent.groupofphotos.GroupOfPhotosViewModelDelegate
import com.news24.app.ui.fragment.detail.photoalbum.adapter.photoalbumcontent.onephoto.OnePhotoViewModelDelegate
import javax.inject.Inject


class PhotoAlbumAdapter @Inject constructor(
        textViewModelDelegate: TextViewModelDelegate,
        separatorViewModelDelegate: SeparatorViewModelDelegate,
        countPhotosViewModelDelegate: CountPhotosViewModelDelegate,
        groupOfPhotosViewModelDelegate: GroupOfPhotosViewModelDelegate,
        onePhotoViewModelDelegate: OnePhotoViewModelDelegate
) : DiffAdapter() {

    init {
        delegatesManager.addDelegate(textViewModelDelegate)
        delegatesManager.addDelegate(separatorViewModelDelegate)
        delegatesManager.addDelegate(countPhotosViewModelDelegate)
        delegatesManager.addDelegate(groupOfPhotosViewModelDelegate)
        delegatesManager.addDelegate(onePhotoViewModelDelegate)
    }

}