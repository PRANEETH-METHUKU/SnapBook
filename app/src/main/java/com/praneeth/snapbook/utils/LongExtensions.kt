package com.praneeth.snapbook.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Long.convertMilliSecondsToDate(): String {
    val date = Date(this)
    val format = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH)
    return format.format(date)
}