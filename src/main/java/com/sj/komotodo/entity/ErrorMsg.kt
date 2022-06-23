package com.sj.komotodo.entity

import com.google.gson.annotations.SerializedName

data class ErrorMsg(
    @SerializedName("code")
    val code: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("documentation_url")
    val documentationUrl: String,
    @SerializedName("errors")
    val errors: List<ErrorInfo>,
    @SerializedName("message")
    val message: String
)