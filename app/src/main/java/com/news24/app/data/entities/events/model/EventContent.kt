package com.news24.app.data.entities.events.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class EventContent (
		val type: ContentType,
		val content: String
)


enum class ContentType {
	@SerializedName("h")
	HEADER,
	@SerializedName("h2")
	HEADER2,
	@SerializedName("h3")
	HEADER3,
	@SerializedName("p")
	PARAGRAPH,
	@SerializedName("readOnSiteButton")
	IGNORE,
}