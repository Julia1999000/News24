package com.news24.app.ui.fragment.events

import com.news24.app.data.entities.events.model.*
import com.news24.app.data.entities.events.paginator.EventsPaginator
import com.news24.app.data.entities.events.paginator.PaginatorEvent
import com.news24.app.di.NamedDependencies
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.fragment.detail.article.model.ArticleScreenParams
import com.news24.app.ui.fragment.detail.broadcast.model.BroadcastScreenParams
import com.news24.app.ui.fragment.detail.news.model.NewsScreenParams
import com.news24.app.ui.fragment.detail.photoalbum.model.PhotoAlbumScreenParams
import com.news24.app.ui.fragment.events.adapter.BaseEventViewModel
import com.news24.app.ui.fragment.events.adapter.EventViewModelFactory
import com.news24.app.ui.fragment.events.adapter.SizeForm
import com.news24.app.ui.fragment.events.adapter.article.ArticleViewModel
import com.news24.app.ui.fragment.events.adapter.broadcast.BroadcastViewModel
import com.news24.app.ui.fragment.events.adapter.broadcast.StatusBroadcast
import com.news24.app.ui.fragment.events.adapter.news.NewsViewModel
import com.news24.app.ui.fragment.events.adapter.photoalbum.PhotoAlbumViewModel
import com.news24.app.ui.navigation.Screens
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import timber.log.Timber
import java.util.*
import javax.inject.Inject
import javax.inject.Named


@InjectViewState
class EventsPresenter @Inject constructor(
		@Named(NamedDependencies.TAB_ROUTER) private val router: Router,
		private val eventsPaginator: EventsPaginator
) : EventsContract.Presenter() {

	private var events: List<Event> = listOf()
	private var eventsViewModels: List<ListViewModel> = emptyList()
	private var eventsDisposable: Disposable? = null
	private var lastVisibleItemPosition = 0

	companion object {
		private const val LOAD_ADDITIONAL_ITEMS_THRESHOLD = 10
	}

	//region ==================== MVP Presenter ====================

	override fun onFirstViewAttach() {
		super.onFirstViewAttach()

		observeEventsPaginator()
		viewState.showPreloader()
		loadData()
	}

	//endregion


	//region ==================== EventsContract.Presenter ====================

	override fun onListScrolled(lastVisibleItemPosition: Int) {
		this.lastVisibleItemPosition = lastVisibleItemPosition

		if (isCanToLoadData()) {
			eventsPaginator.loadNext()
		}
	}

	override fun onListItemClicked(item: ListViewModel) {
		events.find { item.listItemId == it.id }?.let { event ->
			when(item) {
				is ArticleViewModel -> {
					router.navigateTo(Screens.ContainerScreen(Screens.ArticleScreen(createArticleScreenParams(event))))
				}
				is NewsViewModel -> {
					router.navigateTo(Screens.ContainerScreen(Screens.NewsScreen(createNewsScreenParams(event))))
				}
				is BroadcastViewModel -> {
					router.navigateTo(Screens.ContainerScreen(Screens.BroadcastScreen(createBroadcastScreenParams(event))))
				}
				is PhotoAlbumViewModel -> {
					router.navigateTo(Screens.ContainerScreen(Screens.PhotoAlbumScreen(createPhotoAlbumScreenParams(event))))
				}
			}
		}
	}

	//endregion


	//region ===================== Internal ======================

	private fun loadData() {
		eventsPaginator.loadNext()
	}

	private fun observeEventsPaginator() {
		eventsDisposable = eventsPaginator.eventObservable()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe({
					viewState.hidePreloader()
					when (it) {
						is PaginatorEvent.EventSuccess -> {
							this.events = it.dataList.map { item -> item as Event }
							showItemList()
						}
						is PaginatorEvent.EventError -> {
							Timber.w(it.throwable)
							// TODO viewState.showErrorMessage(message)
						}
					}
				}, { throwable ->
					Timber.w(throwable)
					viewState.hidePreloader()
					// TODO viewState.showErrorMessage(message)
				})
		eventsDisposable?.let { compositeDisposable.add(it) }
	}

	private fun showItemList() {
		val listViewModel = ArrayList<ListViewModel>()

		events.forEach {
			EventViewModelFactory.makeEventViewModel(it)?.let { viewModel -> listViewModel.add(viewModel) }
		}
		configViewModelSize(listViewModel)
		eventsViewModels = listViewModel
		viewState.showData(eventsViewModels)
	}

	private fun configViewModelSize(listViewModel: ArrayList<ListViewModel>) {
		var pos = 0
		val lenList = listViewModel.size
		while (pos < lenList) {
			var i = 0
			var isHaveBroad = false
			loop@ while (i < 3 && pos < lenList) {
				if (listViewModel[pos] is BroadcastViewModel) {
					isHaveBroad = true
					when(i) {
						1 -> {
							(listViewModel[pos - i] as BaseEventViewModel).sizeForm = SizeForm.BIG_FORM
						}
						2 -> {
							(listViewModel[pos - i] as BaseEventViewModel).sizeForm = SizeForm.SMALL_FORM
							(listViewModel[pos - i + 1] as BaseEventViewModel).sizeForm = SizeForm.SMALL_FORM
						}
					}
					pos ++
					break@loop
				}
				pos ++
				i ++
			}

			if(!isHaveBroad) {
				if(i == 3) {
					(listViewModel[pos - 3] as BaseEventViewModel).sizeForm = SizeForm.SMALL_FORM
					(listViewModel[pos - 2] as BaseEventViewModel).sizeForm = SizeForm.SMALL_FORM
					(listViewModel[pos - 1] as BaseEventViewModel).sizeForm = SizeForm.BIG_FORM
				} else {
					for(j in 0 until i) {
						(listViewModel[pos - i + j] as BaseEventViewModel).sizeForm = SizeForm.BIG_FORM
					}
				}
			}
		}
	}

	private fun isCanToLoadData(): Boolean {
		return isHasThresholdBeenReached() && eventsPaginator.isCanLoadNext()
	}

	private fun isHasThresholdBeenReached(): Boolean {
		return lastVisibleItemPosition > 0 && lastVisibleItemPosition >= eventsViewModels.size - LOAD_ADDITIONAL_ITEMS_THRESHOLD
	}

	private fun createArticleScreenParams(event: Event): ArticleScreenParams {
		event.data as EventDataArticle
		return ArticleScreenParams(
			url =  event.url,
			id = event.id,
			publishDate = event.publishDate,
			backgroundImage = event.data.backgroundImage,
			title = event.data.title,
			tags = event.data.tags,
			image = event.data.image,
			content =  event.data.content
		)
	}

	private fun createNewsScreenParams(event: Event): NewsScreenParams {
		event.data as EventDataNews
		return NewsScreenParams(
			url =  event.url,
			id = event.id,
			publishDate = event.publishDate,
			backgroundImage = event.data.backgroundImage,
			title = event.data.title,
			tags = event.data.tags,
			image = event.data.image,
			content =  event.data.content
		)
	}

	private fun createBroadcastScreenParams(event: Event): BroadcastScreenParams {
		event.data as EventDataBroadcast
		return BroadcastScreenParams(
			url =  event.url,
			id = event.id,
			publishDate = event.publishDate,
			backgroundImage = event.data.backgroundImage,
			title = event.data.title,
			tags = event.data.tags,
			liveEvents = event.data.liveEvents,
			live = StatusBroadcast.START.takeIf { event.data.live } ?: StatusBroadcast.END
		)
	}

	private fun createPhotoAlbumScreenParams(event: Event): PhotoAlbumScreenParams {
		event.data as EventDataPhotoAlbum
		return PhotoAlbumScreenParams(
			url =  event.url,
			id = event.id,
			publishDate = event.publishDate,
			backgroundImage = event.data.backgroundImage,
			title = event.data.title,
			photoUrlList = event.data.photoUrlList
		)
	}

	//endregion

}