package br.com.baseapplication.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Pokemon(
    @Json(name = "name")
    val name: String?,
    @Json(name = "url")
    val url: String?
)