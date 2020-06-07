package br.com.baseapplication.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiError(
    @Json(name = "error") val error: String? = null,
    @Json(name = "message") val message: String? = null
)
