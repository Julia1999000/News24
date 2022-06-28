package com.news24.app.ui.fragment.detail.news.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.news24.app.data.entities.events.model.*
import kotlinx.parcelize.Parcelize
import java.util.*


@Parcelize
@Keep
data class NewsScreenParams(
        val url: String,
        val id: String,
        val publishDate: Date,
        val backgroundImage: String,
        val title: String,
        val tags: List<EventTag>,
        val image: String?,
        val content: List<EventContent>
): Parcelable