package com.news24.app.ui.fragment.events.adapter

import com.news24.app.ui.adapter.DiffAdapter
import com.news24.app.ui.fragment.events.adapter.article.ArticleViewModelDelegate
import com.news24.app.ui.fragment.events.adapter.broadcast.BroadcastViewModelDelegate
import com.news24.app.ui.fragment.events.adapter.news.NewsViewModelDelegate
import com.news24.app.ui.fragment.events.adapter.photoalbum.PhotoAlbumViewModelDelegate
import javax.inject.Inject


class EventsAdapter @Inject constructor(
		articleViewModelDelegate: ArticleViewModelDelegate,
		broadcastViewModelDelegate: BroadcastViewModelDelegate,
		newsViewModelDelegate: NewsViewModelDelegate,
		photoAlbumViewModelDelegate: PhotoAlbumViewModelDelegate,
) : DiffAdapter() {

	init {
		delegatesManager.addDelegate(articleViewModelDelegate)
		delegatesManager.addDelegate(broadcastViewModelDelegate)
		delegatesManager.addDelegate(newsViewModelDelegate)
		delegatesManager.addDelegate(photoAlbumViewModelDelegate)
	}

}