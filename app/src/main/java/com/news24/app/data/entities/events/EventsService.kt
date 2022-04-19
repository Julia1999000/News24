package com.news24.app.data.entities.events

import com.news24.app.data.entities.events.model.Event
import io.reactivex.Single
import java.util.*


interface EventsService {

	fun getEventsList(limit: Int, beforeId: String?, before: Date?): Single<List<Event>>

}