package me.brunofelix.pmovie.core.presentation.ui.navigation

sealed class Screen(val route: String) {
    data object Popular : Screen("popular")
    data object Upcoming : Screen("upcoming")
    data object Favorite : Screen("favorite")
}