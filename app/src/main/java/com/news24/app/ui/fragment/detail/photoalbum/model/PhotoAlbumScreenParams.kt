package com.news24.app.ui.fragment.detail.photoalbum.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import java.util.*


@Parcelize
@Keep
data class PhotoAlbumScreenParams(
        val url: String,
        val id: String,
        val publishDate: Date,
        val backgroundImage: String,
        val title: String,
        val photoUrlList: List<String>
) : Parcelable