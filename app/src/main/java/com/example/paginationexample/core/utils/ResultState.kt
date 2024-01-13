package com.example.paginationexample.core.utils

import java.lang.Exception

sealed class ResultState<T>(val data: T? = null, val exception: Exception? = null) {
    class Success<T>(data: T) : ResultState<T>(data = data)
    class Failure<T>(exception: Exception) : ResultState<T>(exception = exception)
}