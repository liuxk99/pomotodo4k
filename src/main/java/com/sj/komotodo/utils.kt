package com.sj.komotodo

import java.io.File

fun readFileDirectlyAsText(fileName: String): String
    = File(fileName).readText(Charsets.UTF_8)
