package com.crincongtz.bestmovies.utils

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateTypeAdapter {

    @ToJson
    fun toJson(dateTime: Date): String {
        return dateTime.toString()
    }

    @FromJson
    internal fun fromJson(date: String): Date? {

        for (format in formats) {
            try {
                val simpleDateFormat = SimpleDateFormat(format, Locale.US)

                simpleDateFormat.timeZone = TimeZone.getTimeZone("GMT")

                return simpleDateFormat.parse(date)
            } catch (exception: Exception) {
            }
        }

        throw ParseException("Cannot parse date format $date", -1)
    }

    companion object {
        private val formats = arrayOf("yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd")
    }
}
