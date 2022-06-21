package com.sj.komotodo

data class Pomo(val uuid:String,
                 val create_at: String,
                 val update_at: String,
                 val description: String,
                 val started_at: String,
                 val ended_at: String,
                 val local_started_at: String,
                 val local_ended_at: String,
                 val length: Int,
                 val abandoned: Boolean = false,
                 val manual: Boolean = false
)
