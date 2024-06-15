package me.brunofelix.pmovie.core.extension

import me.brunofelix.pmovie.BuildConfig

fun String?.toPostUrl() = "${BuildConfig.BASE_URL_IMAGE}$this"

fun String?.toBackdropUrl() = "${BuildConfig.BASE_URL_IMAGE}$this"