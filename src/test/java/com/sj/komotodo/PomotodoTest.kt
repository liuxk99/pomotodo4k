package com.sj.komotodo

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File

fun readFileDirectlyAsText(fileName: String): String = File(fileName).readText(Charsets.UTF_8)

class PomotodoTest {
    @Before
    @Throws(Exception::class)
    fun setUp() {
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
    }

    @Test
    fun testGetPomos() {
        // You should store token in ${MODULE} root directory.
        val token: String = readFileDirectlyAsText("pomotodo.token")
        println(token)

    }
}