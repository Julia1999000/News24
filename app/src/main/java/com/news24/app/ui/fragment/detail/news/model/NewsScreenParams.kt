package com.news24.app.ui.fragment.detail.news.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.news24.app.data.entities.events.model.*
import kotlinx.parcelize.Parcelize
import java.util.*


@Keep
@Parcelize
class NewsScreenParams(private val event: Event): Parcelable {

    val url: String
        get() = event.url

    val id: String
        get() = event.id

    val publishDate: Date
        get() = event.publishDate

    val backgroundImage: String
        get() = event.data?.backgroundImage ?: ""

    val title: String
        get() = event.data?.title ?: ""

    val tags: List<EventTag>
        get() = (event.data as? EventDataNews)?.tags ?: listOf()

    val image: String?
        get() = (event.data as? EventDataNews)?.image

    val content: List<EventContent>
        get() = (event.data as? EventDataNews)?.content ?: listOf()

}