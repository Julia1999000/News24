package com.news24.app.data.entities.events.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import java.util.*

@Keep
@Parcelize
data class Event (
		val url: String,
		val id: String,
		val type: EventType,
		val publishDate: Date,
		val data : EventData?
): Parcelable