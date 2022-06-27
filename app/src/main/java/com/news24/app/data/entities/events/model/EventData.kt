package com.news24.app.data.entities.events.model

import android.os.Parcelable


abstract class EventData: Parcelable {
	abstract val backgroundImage: String
	abstract val title: String
}











