package com.news24.app.data.entities.events.model

import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize


@Keep
@Parcelize
data class EventDataNews (
		override val backgroundImage: String,
		override val title: String,
		val sport: String,
		val tags: List<EventTag>,
		val image: String?,
		val content: List<EventContent>
) : EventData()