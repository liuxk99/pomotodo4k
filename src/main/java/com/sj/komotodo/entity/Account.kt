package com.sj.komotodo.entity

import com.google.gson.annotations.SerializedName
import java.util.*

/*
https://pomotodo.github.io/api-doc/#api-Account-GetCurrentAccount
HTTP/1.1 200 OK
{
  "username": "example",
  "email": "example@example.com",
  "timezone": "Asia/Shanghai",
  "pro_expires_time": "2017-01-01T00:00:00.000Z",
  "register_time": "2015-06-21T19:38:06.960Z"
}
* */
data class Account(
    @SerializedName("username") val username: String,
    @SerializedName("email") val email: String,
    @SerializedName("timezone") val timezone: String,
    @SerializedName("pro_expires_time") val pro_expires_time: Date,
    @SerializedName("register_time") val register_time: Date
)