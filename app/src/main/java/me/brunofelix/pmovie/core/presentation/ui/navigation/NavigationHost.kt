package me.brunofelix.pmovie.core.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Popular.route
    ) {
        composable(BottomNavItem.Popular.route) {

        }
        composable(BottomNavItem.Upcoming.route) {

        }
        composable(BottomNavItem.Favorite.route) {

        }
    }
}