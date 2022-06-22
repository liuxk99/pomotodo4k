package com.sj.komotodo

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

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
data class Pomo(
    @SerializedName("uuid") val uuid: String,
    @SerializedName("created_at") val created_at: Date,
    @SerializedName("updated_at") val updated_at: Date,
    @SerializedName("description") val description: String = "",
    @SerializedName("started_at") val started_at: Date,
    @SerializedName("ended_at") val ended_at: Date,
    @SerializedName("local_started_at") val local_started_at: Date,
    @SerializedName("local_ended_at") val local_ended_at: Date,
    @SerializedName("length") val length: Int,
    @SerializedName("abandoned") val abandoned: Boolean = false,
    @SerializedName("manual") val manual: Boolean = true
) {

    override fun toString(): String {
        val LF = "\n"
        val sb = StringBuilder("[" + this.javaClass.name + "] {${LF}")
        run {
            sb.append(" uuid: ${uuid}${LF}")
            sb.append(" created_at: ${created_at}${LF}")
            sb.append(" updated_at: ${updated_at}${LF}")
            sb.append(" description: ${description}${LF}")
            sb.append(" started_at: ${started_at}${LF}")
            sb.append(" ended_at: ${ended_at}${LF}")
            sb.append(" local_started_at: ${local_started_at}${LF}")
            sb.append(" local_ended_at: ${local_ended_at}${LF}")
            sb.append(" length: ${length}${LF}")
            sb.append(" abandoned: ${abandoned}${LF}")
            sb.append(" manual: ${manual}${LF}")
        }
        sb.append("}").append(LF)
        return sb.toString()
    }

    fun toLine(): String {
        val sb = java.lang.StringBuilder()
        run {
            val dateStr: String = SimpleDateFormat("yyyy-MM-dd").format(local_started_at)
            val beginStr: String = SimpleDateFormat("hh:mm:ss").format(local_started_at)
            val endStr: String = SimpleDateFormat("hh:mm:ss").format(local_ended_at)
            sb.append("  ${dateStr} ${beginStr}~${endStr} (${length}:seconds) '${description}'")
        }
        return sb.toString()
    }

}