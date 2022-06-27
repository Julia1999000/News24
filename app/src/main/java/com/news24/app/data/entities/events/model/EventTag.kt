package com.news24.app.data.entities.events.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize


@Keep
@Parcelize
data class EventTag (
		val id: String,
		val imageUrl: String
): Parcelable