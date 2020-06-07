package br.com.baseapplication.utils.extensions

inline fun <reified T> Any.cast() = takeIf { this is T }?.let { this as T }
    ?: throw ClassCastException()

inline fun <reified T> Any.nullableCast() = takeIf { this is T }?.let { this as T }
