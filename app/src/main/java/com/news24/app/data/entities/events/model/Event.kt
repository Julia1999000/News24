package com.news24.app.data.entities.events.model

import androidx.annotation.Keep
import java.util.*

@Keep
data class Event (
		val url: String,
		val id: String,
		val type: EventType,
		val publishDate: Date,
		val data : EventData?
)