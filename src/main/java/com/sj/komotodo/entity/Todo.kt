package com.sj.komotodo.entity

import com.google.gson.annotations.SerializedName

/*
Refer:
https://pomotodo.github.io/api-doc/#api-Todo-GetTodo
[
    {
        "uuid": "ac753187-2f22-4b5c-b716-f1fcecfb4410",
        "created_at": "2016-08-06T06:48:52.000Z",
        "updated_at": "2016-08-06T06:51:12.000Z",
        "description": "Catch some little Monsters",
        "notice": null,
        "pin": false,
        "completed": false,
        "completed_at": null,
        "repeat_type": "none",
        "remind_time": null,
        "estimated_pomo_count": null,
        "costed_pomo_count": 0,
        "sub_todos": [
        "81921b2e-8b54-46cf-bb47-0d3c3c7e8302",
        "ff59811e-4c53-404f-a842-9590b632616f"
        ]
    }
]
*/

data class Todo (
    @SerializedName("uuid") val uuid : String,
    @SerializedName("created_at") val created_at : String,
    @SerializedName("updated_at") val updated_at : String,
    @SerializedName("description") val description : String,
    @SerializedName("notice") val notice : String,
    @SerializedName("pin") val pin : Boolean,
    @SerializedName("completed") val completed : Boolean,
    @SerializedName("completed_at") val completed_at : String,
    @SerializedName("repeat_type") val repeat_type : String,
    @SerializedName("remind_time") val remind_time : String,
    @SerializedName("estimated_pomo_count") val estimated_pomo_count : String,
    @SerializedName("costed_pomo_count") val costed_pomo_count : Int,
    @SerializedName("sub_todos") val sub_todos : List<String>
)
