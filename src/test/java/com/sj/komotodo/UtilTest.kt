package com.sj.komotodo

import org.junit.Test
import java.time.Instant
import java.time.OffsetDateTime
import java.util.*

class UtilTest {

    @org.junit.Before
    fun setUp() {
    }

    @org.junit.After
    fun tearDown() {
    }

    @org.junit.Test
    fun testDateToISO8601_01() {
        val date = Date()
        println(date.toISO8601())
        println(date.toISO8601(Locale.ENGLISH))
    }

    @org.junit.Test
    fun testDateToISO8601_02() {
        val timeZone = TimeZone.getDefault()
        println(timeZone)

        val endedAt = System.currentTimeMillis()
        val startedAt: Long = endedAt - 60 * 1000 * 2
        val startedDate = Date(startedAt)
        val endedDate = Date(endedAt)
        println(startedDate.toISO8601())
        println(endedDate.toISO8601())
    }

    @Test
    fun testTime() {
        val instant = Instant.now()
        println(instant)
        val date = Date()
        println(date.toISO8601())
    }

}
