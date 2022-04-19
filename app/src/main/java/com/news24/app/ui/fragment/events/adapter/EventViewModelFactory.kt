package com.news24.app.ui.fragment.events.adapter

import com.news24.app.data.entities.events.model.*
import com.news24.app.ui.fragment.events.adapter.article.ArticleViewModel
import com.news24.app.ui.fragment.events.adapter.broadcast.BroadcastViewModel
import com.news24.app.ui.fragment.events.adapter.broadcast.StatusBroadcast
import com.news24.app.ui.fragment.events.adapter.news.NewsViewModel
import com.news24.app.ui.fragment.events.adapter.photoalbum.PhotoAlbumViewModel


object EventViewModelFactory {

	fun makeEventViewModel(event: Event): BaseEventViewModel? {
		return when(event.type) {
			EventType.ARTICLE -> { makeArticleViewModel(event) }
			EventType.NEWS -> { makeNewsViewModel(event) }
			EventType.BROADCAST -> { makeBroadcastViewModel(event) }
			EventType.PHOTO_ALBUM -> { makePhotoAlbumViewModel(event) }
			EventType.IGNORE -> { null }
		}
	}

	private fun makeArticleViewModel(model: Event): ArticleViewModel {
		model.data as EventDataArticle
		return ArticleViewModel(
				listItemId = model.id,
				title = model.data.title,
				img = model.data.image ?: model.data.backgroundImage
		)
	}

	private fun makeNewsViewModel(model: Event): NewsViewModel {
		model.data as EventDataNews
		return NewsViewModel(
				listItemId = model.id,
				title = model.data.title,
				img = model.data.image ?: model.data.backgroundImage
		)
	}

	private fun makeBroadcastViewModel(model: Event): BroadcastViewModel {
		model.data as EventDataBroadcast
		return BroadcastViewModel(
				listItemId = model.id,
				title = model.data.title,
				img = model.data.backgroundImage,
				status = StatusBroadcast.START.takeIf { model.data.live } ?: StatusBroadcast.END
		)
	}

	private fun makePhotoAlbumViewModel(model: Event): PhotoAlbumViewModel {
		model.data as EventDataPhotoAlbum
		return PhotoAlbumViewModel(
				listItemId = model.id,
				title = model.data.title,
				img = model.data.backgroundImage,
				photoList = model.data.photoUrlList
		)
	}

}