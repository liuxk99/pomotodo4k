package com.sj.komotodo

import java.io.File
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun readFileDirectlyAsText(fileName: String): String = File(fileName).readText(Charsets.UTF_8)

fun Date.toISO8601(): String {
    val iso8601SDF = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    val iso8601Date: DateFormat = SimpleDateFormat(iso8601SDF, Locale.getDefault())
    return iso8601Date.format(this)
}

fun Date.toISO8601(locale: Locale): String {
    val iso8601SDF = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    val iso8601Date: DateFormat = SimpleDateFormat(iso8601SDF, locale)
    return iso8601Date.format(this)
}