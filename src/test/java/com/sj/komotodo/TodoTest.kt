package com.sj.komotodo

import com.google.gson.Gson

class TodoTest {
    val json_str = """
    {
        "uuid": "ac753187-2f22-4b5c-b716-f1fcecfb4410",
        "created_at": "2016-08-06T06:48:52.000Z",
        "updated_at": "2016-08-06T06:51:12.000Z",
        "description": "Catch some little Monsters",
        "notice": null,
        "pin": false,
        "completed": false,
        "completed_at": null,
        "repeat_type": "none",
        "remind_time": null,
        "estimated_pomo_count": null,
        "costed_pomo_count": 0,
        "sub_todos": [
        "81921b2e-8b54-46cf-bb47-0d3c3c7e8302",
        "ff59811e-4c53-404f-a842-9590b632616f"
        ]
    }
    """

    @org.junit.Before
    fun setUp() {
    }

    @org.junit.After
    fun tearDown() {
    }

    @org.junit.Test
    fun testToString() {
        val gson = Gson()
        val todo = gson.fromJson(json_str, Todo::class.java)
        println(todo)
    }
}
