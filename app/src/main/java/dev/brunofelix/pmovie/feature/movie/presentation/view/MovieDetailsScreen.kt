package dev.brunofelix.pmovie.feature.movie.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.brunofelix.pmovie.feature.movie.presentation.components.details.MovieDetailsBackdropImage
import dev.brunofelix.pmovie.feature.movie.presentation.components.details.MovieDetailsTopBar
import dev.brunofelix.pmovie.feature.movie.presentation.state.MovieDetailsState

@Composable
fun MovieDetailsScreen(
    movieId: Int,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    uiState: MovieDetailsState?
) {
    Scaffold(
        topBar = {
            Box {

                MovieDetailsBackdropImage(uiState = uiState)
                MovieDetailsTopBar(
                    onBackClick = onBackClick
                )
            }

        },
        content = { innerPadding ->
            Column(
                modifier = modifier.padding(innerPadding)
            ) {
                Text(text = "Overview")
            }
        }
    )
}

@Preview
@Composable
private fun MovieDetailsScreenPreview() {
    
}