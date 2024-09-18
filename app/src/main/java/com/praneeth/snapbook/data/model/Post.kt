package com.praneeth.snapbook.data.model

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Post(
    val id: String = "",
    val content: String = "",
    val timestamp: Long = System.currentTimeMillis(),
    val imageUrl: String? = null
)

