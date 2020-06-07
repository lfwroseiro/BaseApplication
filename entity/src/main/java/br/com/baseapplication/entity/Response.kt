package br.com.baseapplication.entity

sealed class Response<out T> {
    object Empty : Response<Nothing>()
    data class Success<T>(val body: T) : Response<T>()
    sealed class Error : Response<Nothing>() {
        data class BadRequest(val errorMessage: String) : Error()
        data class Unauthorized(val errorMessage: String) : Error()
        data class Unexpected(val errorMessage: String) : Error()
    }
}