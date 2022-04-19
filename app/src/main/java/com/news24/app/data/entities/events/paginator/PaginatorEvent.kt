package com.news24.app.data.entities.events.paginator

import androidx.annotation.Keep


@Keep
sealed class PaginatorEvent {

	@Keep
	data class EventError(
			val throwable: Throwable
	): PaginatorEvent()

	@Keep
	data class EventSuccess(
			val dataList: List<*>
	): PaginatorEvent()

}