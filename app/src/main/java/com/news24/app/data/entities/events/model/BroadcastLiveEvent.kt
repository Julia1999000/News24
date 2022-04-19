package com.news24.app.data.entities.events.model

import androidx.annotation.Keep
import java.util.*

@Keep
data class BroadcastLiveEvent (
		val publishDate: Date,
		val content: List<EventContent>
)