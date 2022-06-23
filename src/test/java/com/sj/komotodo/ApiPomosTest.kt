package com.sj.komotodo

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sj.komotodo.entity.ErrorMsg
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.time.Instant
import java.util.*

class ApiPomosTest {
    private lateinit var tokenTag: String
    private lateinit var service: APIService
    val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(APIService.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Before
    @Throws(Exception::class)
    fun setUp() {
        // You should store token in ${MODULE} root directory.
        val token = readFileDirectlyAsText("pomotodo.token")
        println(token)

        tokenTag = String.format("token %s", token)
        println(tokenTag)

        service = retrofit.create(
            APIService::class.java
        )
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
    }

    @Test
    fun testGetPomo() {
        try {
            val response = service.getPomo(
                tokenTag,
                "3748f405-55cf-4068-ab3e-82fedb34d36e"
            ).execute()
            if (response.isSuccessful) {
//                println(response.body())
                println(response.body()?.toLine())
            } else {
                // failed
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test
    fun testPostPomo() {
        val timeZone = TimeZone.getDefault()
        val endedAt = Instant.now().toEpochMilli()
        val startedAt: Long = endedAt - 60 * 1000 * 2
        val startedDate = Date(startedAt)
        val endedDate = Date(endedAt)
        println(startedDate.toISO8601())
        println(endedDate.toISO8601())

        try {
            val response = service.postPomo(
                tokenTag,
                timeZone.id,
                startedAt,
                endedAt,
                "<TEST>Create a Pomo"
            )!!.execute()
            println(response.raw())

            if (response.code() in 200..299) {
                val pomo = response.body()
                println(pomo)
                return
            }

            val gson = Gson()
            val type = object : TypeToken<ErrorMsg>() {}.type
            val errorResponse: ErrorMsg? =
                gson.fromJson(response.errorBody()!!.charStream(), type)
            println(errorResponse)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test
    fun testGetPomos() {
        val refDate = Date()
        val startedAt = Date(refDate.year, refDate.month, refDate.date - 1)

        try {
            val response = service.getPomos(
                tokenTag,
                startedAt.toISO8601(),
                null,
                null,
                null,
                false,
                false
            ).execute()
            if (response.isSuccessful) {
//                println(response.body())
                response.body()?.iterator()?.forEach {
                    println(it.toLine())
                }
            } else {
                // failed
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}