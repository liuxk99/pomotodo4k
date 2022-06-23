package com.sj.komotodo.entity

import com.google.gson.annotations.SerializedName

data class ErrorInfo(
    @SerializedName("path")
    val path: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("message")
    val message: String
)