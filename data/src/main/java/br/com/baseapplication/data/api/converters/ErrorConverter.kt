package br.com.baseapplication.data.api.converters

import com.squareup.moshi.Moshi
import okhttp3.ResponseBody
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class ErrorConverter : KoinComponent {
    protected val moshi: Moshi by inject()
    abstract fun convertError(error: ResponseBody): String?
}
