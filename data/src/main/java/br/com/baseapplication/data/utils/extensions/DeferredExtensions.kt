package br.com.baseapplication.data.utils.extensions

import br.com.baseapplication.data.api.converters.DefaultErrorConverter
import br.com.baseapplication.data.api.converters.ErrorConverter
import br.com.baseapplication.entity.Response
import kotlinx.coroutines.Deferred

private const val EMPTY_TEXT = ""
private const val BAD_REQUEST = 400
private const val UNAUTHORIZED = 401
private const val FORBIDDEN = 403
private const val NOT_FOUND = 404
private const val TOKEN_EXPIRED = 409

suspend fun <T> Deferred<retrofit2.Response<T>>.convert(
    errorConverter: ErrorConverter = DefaultErrorConverter()
) = with(await()) {
    if (isSuccessful) {
        body()?.takeIf { it !is List<*> || it.isNotEmpty() }
            ?.let { Response.Success<T>(it) } ?: Response.Empty
    } else {
        val error = errorBody()?.let { errorConverter.convertError(it) } ?: EMPTY_TEXT
        when (code()) {
            BAD_REQUEST, NOT_FOUND -> Response.Error.BadRequest(error)
            UNAUTHORIZED, TOKEN_EXPIRED, FORBIDDEN -> Response.Error.Unauthorized(error)
            else -> Response.Error.Unexpected(error)
        }
    }
}
