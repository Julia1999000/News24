package com.news24.app.helpers

import java.text.SimpleDateFormat
import java.util.*

object FormatHelper {

    private const val SHORT_DATE_FORMAT = "dd MMMM"

    private const val FULL_DATE_FORMAT = "dd.MMMM.yyyy"

    private const val TIME_FORMAT = "HH:mm"

    //region ===================== Date ======================


    fun getFormattedDate(date: Date): String {
        return getFormattedDate(date, FULL_DATE_FORMAT)
    }

    fun getFormattedTime(date: Date): String {
        return getFormattedDate(date, TIME_FORMAT)
    }

    fun getFormattedDate(date: Date, format: String, timeZone: TimeZone? = null): String {
        val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
        if (timeZone != null) {
            simpleDateFormat.timeZone = timeZone
        }
        return simpleDateFormat.format(date)
    }

    //endregion

}