package com.news24.app.ui.fragment.events

import com.news24.app.data.entities.events.model.Event
import com.news24.app.data.entities.events.paginator.EventsPaginator
import com.news24.app.data.entities.events.paginator.PaginatorEvent
import com.news24.app.di.NamedDependencies
import com.news24.app.ui.adapter.ListViewModel
import com.news24.app.ui.fragment.events.adapter.BaseEventViewModel
import com.news24.app.ui.fragment.events.adapter.EventViewModelFactory
import com.news24.app.ui.fragment.events.adapter.SizeForm
import com.news24.app.ui.fragment.events.adapter.article.ArticleViewModel
import com.news24.app.ui.fragment.events.adapter.broadcast.BroadcastViewModel
import com.news24.app.ui.fragment.events.adapter.news.NewsViewModel
import com.news24.app.ui.fragment.events.adapter.photoalbum.PhotoAlbumViewModel
import com.news24.app.ui.other.resources.ResourceProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import timber.log.Timber
import java.util.ArrayList
import javax.inject.Inject
import javax.inject.Named


@InjectViewState
class EventsScreenPresenter @Inject constructor(
		@Named(NamedDependencies.TAB_ROUTER) private val router: Router,
		private val eventsPaginator: EventsPaginator,
		private val resourceProvider: ResourceProvider
) : EventsScreenContract.Presenter() {

	private var events: List<Event> = listOf()
	private var eventsViewModels: List<ListViewModel> = emptyList()
	private var eventsDisposable: Disposable? = null

	companion object {
		private const val LOAD_ADDITIONAL_ITEMS_THRESHOLD = 10
	}

	//region ==================== MVP Presenter ====================

	override fun onFirstViewAttach() {
		super.onFirstViewAttach()

		observeEventsPaginator()
		loadData()
	}

	//endregion


	//region ==================== EventsScreenContract.Presenter ====================

	override fun onListScrolled(lastVisibleItemPosition: Int) {
		if (hasThresholdBeenReached(lastVisibleItemPosition) && eventsPaginator.canLoadNext()) {
			eventsPaginator.loadNext()
		}
	}

	override fun onListItemClicked(item: ListViewModel) {
		when(item) {
			is ArticleViewModel -> {}
			is NewsViewModel -> {}
			is BroadcastViewModel -> {}
			is PhotoAlbumViewModel -> {}
			// TODO router.navigateTo(Screens ...)
		}
	}

	//endregion


	//region ===================== Internal ======================

	private fun loadData() {
		eventsPaginator.loadNext()
	}

	private fun observeEventsPaginator() {
		// TODO viewState.showPreloader()
		eventsDisposable = eventsPaginator.eventObservable()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe({
					// TODO viewState.hidePreloader()
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
					//TODO viewState.hidePreloader()
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
		viewState.showData(listViewModel)
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

	private fun hasThresholdBeenReached(lastVisiblePosition: Int): Boolean {
		return lastVisiblePosition > 0 && lastVisiblePosition >= eventsViewModels.size - LOAD_ADDITIONAL_ITEMS_THRESHOLD
	}

	//endregion

}