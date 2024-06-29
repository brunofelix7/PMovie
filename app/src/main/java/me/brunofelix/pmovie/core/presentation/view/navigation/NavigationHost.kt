package me.brunofelix.pmovie.core.presentation.view.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.brunofelix.pmovie.feature.movie.presentation.view.MoviePopularScreen
import me.brunofelix.pmovie.feature.movie.presentation.view.MovieUpcomingScreen
import me.brunofelix.pmovie.feature.movie.presentation.viewmodel.MoviePopularViewModel
import me.brunofelix.pmovie.feature.movie.presentation.viewmodel.MovieUpcomingViewModel

@Composable
fun NavigationHost(
    navController: NavHostController
) {
    val popularViewModel: MoviePopularViewModel = hiltViewModel()
    val upcomingViewModel: MovieUpcomingViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Popular.route
    ) {
        composable(BottomNavItem.Popular.route) {
            MoviePopularScreen(
                uiState = popularViewModel.uiState,
                navToMovieDetails = {

                }
            )
        }
        composable(BottomNavItem.Upcoming.route) {
            MovieUpcomingScreen(
                uiState = upcomingViewModel.uiState,
                navToMovieDetails = {

                }
            )
        }
        composable(BottomNavItem.Favorite.route) {

        }
    }
}