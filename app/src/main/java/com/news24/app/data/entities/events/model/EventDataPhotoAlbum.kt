package com.news24.app.data.entities.events.model

import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize


@Keep
@Parcelize
data class EventDataPhotoAlbum (
		override val backgroundImage: String,
		override val title: String,
		val sport: String,
		val photoUrlList: List<String>
) : EventData()