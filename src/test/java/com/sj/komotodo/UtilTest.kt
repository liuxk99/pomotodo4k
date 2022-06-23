package com.sj.komotodo

import java.util.*

class UtilTest {

    @org.junit.Before
    fun setUp() {
    }

    @org.junit.After
    fun tearDown() {
    }

    @org.junit.Test
    fun testDateToISO8601() {
        val date = Date()
        println(date.toISO8601())
        println(date.toISO8601(Locale.ENGLISH))
    }
}
