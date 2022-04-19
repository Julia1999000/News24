package com.news24.app.data.entities.events

import com.news24.app.data.entities.events.model.Event
import io.reactivex.Single
import java.util.*
import javax.inject.Inject


class EventsServiceImpl @Inject constructor(
		//private val apiClient: ApiClient
): EventsService {

	override fun getEventsList(limit: Int, beforeId: String?, before: Date?): Single<List<Event>> {
		// TODO
		return Single.just(EventsMockData.getItemsList())
	}

}