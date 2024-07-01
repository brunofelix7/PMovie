package me.brunofelix.pmovie.core.data

sealed class ResultData<out T> {
    data object Loading : ResultData<Nothing>()
    data class Success<out T>(val data: T?) : ResultData<T>()
    data class Error(val e: Exception?) : ResultData<Nothing>()
}