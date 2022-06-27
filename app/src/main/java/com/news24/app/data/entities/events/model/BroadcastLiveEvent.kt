package com.news24.app.data.entities.events.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import java.util.*

@Keep
@Parcelize
data class BroadcastLiveEvent (
		val publishDate: Date,
		val content: List<EventContent>
): Parcelable