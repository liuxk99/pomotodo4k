package com.sj.komotodo

import com.sj.komotodo.entity.Account
import com.sj.komotodo.entity.Pomo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @GET("account")
    fun getAccount(
        @Header("Authorization") token: String
    ): Call<Account>

    @GET("pomos/{uuid}")
    fun getPomo(
        @Header("Authorization") token: String,
        @Path("uuid") uuid: String
    ): Call<Pomo>

    @GET("pomos?limit=40")
    fun getPomos(
        @Header("Authorization") token: String,
        @Query("started_later_than") started_later_than: String?,
        @Query("started_earlier_thanoptional") started_earlier_thanoptional: String?,
        @Query("ended_later_thanoptional") ended_later_thanoptional: String?,
        @Query("ended_earlier_thanoptional") ended_earlier_thanoptional: String?,
        @Query("abandoned") abandoned: Boolean?,
        @Query("manual") manual: Boolean?
    ): Call<List<Pomo>>

    companion object {
        const val baseUrl = "https://api.pomotodo.com/1/"
    }
}