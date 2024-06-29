package me.brunofelix.pmovie.feature.movie.presentation.view

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.collectAsLazyPagingItems
import me.brunofelix.pmovie.R
import me.brunofelix.pmovie.feature.movie.presentation.components.MovieContent
import me.brunofelix.pmovie.feature.movie.presentation.components.MovieTopAppBar
import me.brunofelix.pmovie.feature.movie.presentation.state.MovieState

@Composable
fun MovieUpcomingScreen(
    uiState: MovieState,
    navToMovieDetails: (id: Int) -> Unit
) {
    val movies = uiState.upcomingMovies.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            MovieTopAppBar(
                title = stringResource(R.string.upcoming)
            )
        },
        content = { innerPadding ->
            MovieContent(
                paging = movies,
                paddingValues = innerPadding,
                onClick = { id ->
                    navToMovieDetails(id)
                }
            )
        }
    )
}