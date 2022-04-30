package com.news24.app.data.entities.events.paginator

import com.news24.app.data.entities.events.EventsService
import com.news24.app.data.entities.events.model.Event
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import timber.log.Timber
import java.util.*
import javax.inject.Inject


class EventsPaginator @Inject constructor(
		private val eventsService: EventsService
) : Paginator<Event> {

	companion object {
		private const val LIMIT = 20
	}

	private var subject = BehaviorSubject.create<PaginatorEvent>()
	private var canLoadNext: Boolean = true
	private var accumulator: MutableList<Event> = mutableListOf()
	private var loadDisposable: Disposable? = null
	private var beforeId: String? = null
	private var beforeDate: Date? = null

	//region ===================== Paginator ======================

	override fun isCanLoadNext(): Boolean {
		return canLoadNext
	}

	override fun loadNext() {
		if (!canLoadNext || loadDisposable != null) {
			return
		}
		beforeId = accumulator.lastOrNull()?.id
		beforeDate = accumulator.lastOrNull()?.publishDate

		loadDisposable = eventsService.getEventsList(LIMIT, beforeId, beforeDate)
				.subscribeOn(Schedulers.io())
				.subscribe({
					accumulator.addAll(it)
					canLoadNext = it.size >= LIMIT
					loadDisposable = null
					subject.onNext(PaginatorEvent.EventSuccess(accumulator))
				}, { throwable ->
					loadDisposable = null
					Timber.w(throwable)
					canLoadNext = false
					subject.onNext(PaginatorEvent.EventError(throwable))
				})

	}

	override fun eventObservable(): Observable<PaginatorEvent> {
		return subject
	}

	override fun reset() {
		accumulator = mutableListOf()
		canLoadNext = true
		loadDisposable = null
	}

	//endregion


	//region ===================== Public ======================

	//endregion
}