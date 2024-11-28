package dev.brunofelix.pmovie.core.presentation.view.navigation

sealed class Screen(
    val title: String,
    val route: String
) {
    data object Popular : Screen("Populars","popular")
    data object Upcoming : Screen("Upcoming","upcoming")
    data object Favorite : Screen("Favorites","favorite")
}