package me.brunofelix.pmovie.core.presentation.view.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.brunofelix.pmovie.feature.movie.presentation.view.MoviePopularScreen
import me.brunofelix.pmovie.feature.movie.presentation.viewmodel.MoviePopularViewModel

@Composable
fun NavigationHost(
    navController: NavHostController
) {
    val viewModel: MoviePopularViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Popular.route
    ) {
        composable(BottomNavItem.Popular.route) {
            MoviePopularScreen(
                uiState = viewModel.uiState,
                navToMovieDetails = {

                }
            )
        }
        composable(BottomNavItem.Upcoming.route) {

        }
        composable(BottomNavItem.Favorite.route) {

        }
    }
}