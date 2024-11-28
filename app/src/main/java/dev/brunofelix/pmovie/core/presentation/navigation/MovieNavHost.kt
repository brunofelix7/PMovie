package dev.brunofelix.pmovie.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.brunofelix.pmovie.feature.movie.presentation.view.MoviePopularScreen
import dev.brunofelix.pmovie.feature.movie.presentation.view.MovieUpcomingScreen
import dev.brunofelix.pmovie.feature.movie.presentation.viewmodel.MoviePopularViewModel
import dev.brunofelix.pmovie.feature.movie.presentation.viewmodel.MovieUpcomingViewModel

@Composable
fun MovieNavHost(
    navController: NavHostController
) {
    val popularViewModel: MoviePopularViewModel = hiltViewModel()
    val upcomingViewModel: MovieUpcomingViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = MovieRoute.PopularScreen
    ) {
        composable<MovieRoute.PopularScreen> {
            MoviePopularScreen(
                uiState = popularViewModel.uiState,
                navToMovieDetails = {

                }
            )
        }
        composable<MovieRoute.UpcomingScreen> {
            MovieUpcomingScreen(
                uiState = upcomingViewModel.uiState,
                navToMovieDetails = {

                }
            )
        }
        composable<MovieRoute.FavoritesScreen> {

        }
    }
}