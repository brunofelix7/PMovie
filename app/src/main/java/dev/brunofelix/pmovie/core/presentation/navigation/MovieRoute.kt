package dev.brunofelix.pmovie.core.presentation.navigation

import kotlinx.serialization.Serializable

sealed class MovieRoute {

    @Serializable
    data object PopularScreen : MovieRoute()

    @Serializable
    data object UpcomingScreen : MovieRoute()

    @Serializable
    data object FavoritesScreen : MovieRoute()
}