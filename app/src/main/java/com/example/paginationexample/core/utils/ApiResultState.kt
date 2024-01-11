package com.example.paginationexample.core.utils

import java.lang.Exception

sealed class ApiResultState<out T> {
    data class Success<out T>(val data: T) : ApiResultState<T>()
    data class Failure(val exception: Exception) : ApiResultState<Nothing>()

      fun onSuccess(block: (T) -> Unit): ApiResultState<T> {
        if (this is Success) {
            block(this.data)
        }
        return this
    }

    fun onFailure(block: (Exception) -> Unit): ApiResultState<T> {
        if (this is Failure) {
            block(this.exception)
        }
        return this
    }

}