package me.brunofelix.pmovie.core.util

sealed class ResultData<out T> {
    data object Loading : ResultData<Nothing>()
    data class Success<out T>(val data: T?) : ResultData<T>()
    data class Error<T>(val e: Exception?) : ResultData<Nothing>()
}