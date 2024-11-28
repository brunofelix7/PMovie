package dev.brunofelix.pmovie.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.toRoute
import dev.brunofelix.pmovie.feature.movie.presentation.view.MovieDetailsScreen
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
        composable<MovieRoute.PopularScreen>{
            MoviePopularScreen(
                uiState = popularViewModel.uiState,
                navToMovieDetails = {
                    navController.navigate(MovieRoute.DetailsScreen(it))
                }
            )
        }
        composable<MovieRoute.UpcomingScreen>{
            MovieUpcomingScreen(
                uiState = upcomingViewModel.uiState,
                navToMovieDetails = {
                    navController.navigate(MovieRoute.DetailsScreen(it))
                }
            )
        }
        composable<MovieRoute.FavoritesScreen>{
            // TODO: Add favorites screen
        }
        composable<MovieRoute.DetailsScreen>(
            enterTransition = TransitionAnimation.enterTransition,
            exitTransition = TransitionAnimation.exitTransition,
            popEnterTransition = TransitionAnimation.popEnterTransition,
            popExitTransition = TransitionAnimation.popExitTransition
        ) { backStackEntry ->
            val route = backStackEntry.toRoute<MovieRoute.DetailsScreen>()
            MovieDetailsScreen(id = route.id)
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}