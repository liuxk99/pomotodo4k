package com.sj.komotodo

import com.google.gson.annotations.SerializedName

/*
https://pomotodo.github.io/api-doc/#api-Pomo-GetPomo
HTTP/1.1 200 OK

{
  "uuid": "deadcafe-dead-cafe-dead-cafedeadcafe",
  "created_at": "2016-08-06T10:00:00.000Z",
  "updated_at": "2016-08-06T10:00:00.000Z",
  "description": "Hello Pomotodo!",
  "started_at": "2016-08-06T10:00:00.000Z",
  "ended_at": "2016-08-06T10:00:00.000Z",
  "local_started_at": "2016-08-06T18:00:00.000Z",
  "local_ended_at": "2016-08-06T18:00:00.000Z",
  "length": 1500,
  "abandoned": false,
  "manual": false
}
 */
data class Pomo (
    @SerializedName("uuid") val uuid : String,
    @SerializedName("created_at") val created_at : String,
    @SerializedName("updated_at") val updated_at : String,
    @SerializedName("description") val description : String = "",
    @SerializedName("started_at") val started_at : String,
    @SerializedName("ended_at") val ended_at : String,
    @SerializedName("local_started_at") val local_started_at : String,
    @SerializedName("local_ended_at") val local_ended_at : String,
    @SerializedName("length") val length : Int,
    @SerializedName("abandoned") val abandoned : Boolean = false,
    @SerializedName("manual") val manual : Boolean = true
)