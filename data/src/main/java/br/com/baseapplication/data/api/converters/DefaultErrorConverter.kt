package br.com.baseapplication.data.api.converters

import br.com.baseapplication.entity.ApiError
import okhttp3.ResponseBody
import java.io.IOException

class DefaultErrorConverter : ErrorConverter() {

    override fun convertError(error: ResponseBody): String? {
        return try {
            val apiError = moshi.adapter(ApiError::class.java).fromJson(error.string())
            apiError?.error ?: apiError?.message
        } catch (e: IOException) {
            null
        }
    }
}
