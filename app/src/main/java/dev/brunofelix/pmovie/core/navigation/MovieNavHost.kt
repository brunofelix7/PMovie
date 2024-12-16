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
import dev.brunofelix.pmovie.feature.movie.presentation.viewmodel.MovieViewModel

@Composable
fun MovieNavHost(
    navController: NavHostController
) {
    val viewModel: MovieViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = MovieRoute.PopularScreen
    ) {
        /**
         * Popular movies screen
         */
        composable<MovieRoute.PopularScreen>{
            MoviePopularScreen(
                uiState = viewModel.popularsUiState,
                onItemClick = { movieId ->
                    viewModel.getDetails(movieId)
                    navController.navigate(MovieRoute.DetailsScreen(movieId))
                }
            )
        }

        /**
         * Upcoming movies screen
         */
        composable<MovieRoute.UpcomingScreen>{
            MovieUpcomingScreen(
                uiState = viewModel.upcomingUiState,
                onItemClick = { movieId ->
                    viewModel.getDetails(movieId)
                    navController.navigate(MovieRoute.DetailsScreen(movieId))
                }
            )
        }

        /**
         * Favorite movies screen
         */
        composable<MovieRoute.FavoritesScreen>{
            // TODO: Add favorites screen
        }

        /**
         * Details screen
         */
        composable<MovieRoute.DetailsScreen>(
            enterTransition = TransitionAnimation.enterTransition,
            exitTransition = TransitionAnimation.exitTransition,
            popEnterTransition = TransitionAnimation.popEnterTransition,
            popExitTransition = TransitionAnimation.popExitTransition
        ) { backStackEntry ->
            val route = backStackEntry.toRoute<MovieRoute.DetailsScreen>()
            MovieDetailsScreen(
                movieId = route.movieId,
                uiState = viewModel.movieDetails.value,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}