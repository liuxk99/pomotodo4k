package com.sj.komotodo

import com.sj.komotodo.entity.Account
import com.sj.komotodo.entity.Pomo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface APIService {
    @GET("account")
    fun getAccount(
        @Header("Authorization") token: String
    ): Call<Account>

    @GET("pomos?limit=40")
    fun getPomos(
        @Header("Authorization") token: String?,
        @Query("abandoned") abandoned: Boolean,
        @Query("manual") manual: Boolean
    ): Call<List<Pomo>>

    companion object {
        const val baseUrl = "https://api.pomotodo.com/1/"
    }
}