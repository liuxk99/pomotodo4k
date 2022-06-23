package com.sj.komotodo

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sj.komotodo.entity.ErrorMsg
import junit.framework.Assert.fail
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class ApiAccountTest {
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
    fun testGetAccountValidToken() {
        try {
            val response = service.getAccount(tokenTag).execute()
            if (response.isSuccessful) {
                println(response.body())
            } else {
                fail()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test
    fun testGetAccountNoToken() {
        try {
            val response = service.getAccount("").execute()
            if (response.code() in 401..499) {
                val gson = Gson()
                val type = object : TypeToken<ErrorMsg>() {}.type
                val errorResponse: ErrorMsg? =
                    gson.fromJson(response.errorBody()!!.charStream(), type)
                println(errorResponse)
                if (errorResponse?.code.equals("NotAuthorized")) {
                    println("PASS")
                    return
                }
            }
            fail()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test
    fun testGetAccountInvalidToken() {
        try {
            val response = service.getAccount(tokenTag + "x").execute()
            if (response.code() in 401..499) {
                val gson = Gson()
                val type = object : TypeToken<ErrorMsg>() {}.type
                val errorResponse: ErrorMsg? =
                    gson.fromJson(response.errorBody()!!.charStream(), type)
                println(errorResponse)
                if (errorResponse?.code.equals("InvalidCredentials")) {
                    println("PASS")
                    return
                }
            }
            fail()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}