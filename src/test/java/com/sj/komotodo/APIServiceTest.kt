package com.sj.komotodo

import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.*

class APIServiceTest {
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
    fun testGetAccount() {
        try {
            val response = service.getAccount(tokenTag).execute()
            if (response.isSuccessful) {
                println(response.body())
            } else {
                // failed
            }
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