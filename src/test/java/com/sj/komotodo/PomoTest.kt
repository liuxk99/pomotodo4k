package com.sj.komotodo

import com.google.gson.Gson
import org.junit.After
import org.junit.Before
import org.junit.Test

class PomoTest {
    private val json_str = """
{
  "uuid": "deadcafe-dead-cafe-dead-cafedeadcafe",
  "created_at": "2016-08-06T10:00:00.000Z",
  "updated_at": "2016-08-06T10:00:00.000Z",
  "description": "Hello Pomotodo!",
  "started_at": "2016-08-06T10:00:00.000Z",
  "ended_at": "2016-08-06T10:00:00.000Z",
  "local_started_at": "2016-08-06T18:00:00.000Z",
  "local_ended_at": "2016-08-06T18:03:00.000Z",
  "length": 1500,
  "abandoned": false,
  "manual": false
}
       """.trimIndent()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testToString() {
        println(Gson().fromJson(json_str, Pomo::class.java))
    }

    @Test
    fun testToLine() {
        println(Gson().fromJson(json_str, Pomo::class.java).toLine())
    }
}