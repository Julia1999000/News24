package com.news24.app.ui.fragment.detail.broadcast.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.news24.app.data.entities.events.model.BroadcastLiveEvent
import com.news24.app.data.entities.events.model.EventTag
import com.news24.app.ui.fragment.events.adapter.broadcast.StatusBroadcast
import kotlinx.parcelize.Parcelize
import java.util.*


@Parcelize
@Keep
data class BroadcastScreenParams(
        val url: String,
        val id: String,
        val publishDate: Date,
        val backgroundImage: String,
        val title: String,
        val tags: List<EventTag>,
        val liveEvents: List<BroadcastLiveEvent>,
        val live: StatusBroadcast
): Parcelable