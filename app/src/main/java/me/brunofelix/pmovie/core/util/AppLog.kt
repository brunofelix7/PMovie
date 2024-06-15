package me.brunofelix.pmovie.core.util

import timber.log.Timber

object AppLog {

    private const val LOG_INFO = "PMovie_INFO"
    private const val LOG_ERROR = "PMovie_ERROR"

    fun info(message: String) {
        Timber.tag(LOG_INFO).i("Info -> $message")
    }

    fun error(message: String) {
        Timber.tag(LOG_INFO).e("Error -> $message")
    }
}