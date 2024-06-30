package me.brunofelix.pmovie.core.util

import timber.log.Timber

fun logInfo(message: String) {
    Timber.tag("APP_LOG").i("Info -> $message")
}

fun logError(message: String) {
    Timber.tag("APP_LOG").e("Error -> $message")
}