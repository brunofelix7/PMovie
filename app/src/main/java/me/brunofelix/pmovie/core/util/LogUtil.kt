package me.brunofelix.pmovie.core.util

import timber.log.Timber

fun logInfo(message: String) {
    Timber.tag("PMovie_INFO").i("Info -> $message")
}

fun logError(message: String) {
    Timber.tag("PMovie_ERROR").e("Error -> $message")
}