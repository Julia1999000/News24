package com.news24.app.data.entities.events.paginator

import io.reactivex.Observable

interface Paginator<T> {

	fun isCanLoadNext(): Boolean

	fun loadNext()

	fun eventObservable(): Observable<PaginatorEvent>

	fun reset()

}