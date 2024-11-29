package dev.brunofelix.pmovie.feature.movie.presentation.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.brunofelix.pmovie.feature.movie.presentation.components.MovieDetailsTopBar
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
            MovieDetailsTopBar(
                onBackClick = onBackClick
            )
        },
        content = { innerPadding ->
            Text(
                text = "uiState= $uiState",
                modifier = Modifier.padding(innerPadding)
            )
        }
    )
}

@Preview
@Composable
private fun MovieDetailsScreenPreview() {
    
}