package com.example.sndapicall.data.model

import com.squareup.moshi.Json

data class Response(

    @Json(name = "message")
    val dogList: List<String>
    )
