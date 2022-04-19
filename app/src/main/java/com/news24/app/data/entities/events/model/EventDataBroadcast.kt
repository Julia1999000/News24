package com.news24.app.data.entities.events.model

import androidx.annotation.Keep


@Keep
data class EventDataBroadcast (
		override val backgroundImage: String,
		override val title: String,
		val tags: List<EventTag>,
		val liveEvents: List<BroadcastLiveEvent>,
		val live:Boolean
) : EventData()