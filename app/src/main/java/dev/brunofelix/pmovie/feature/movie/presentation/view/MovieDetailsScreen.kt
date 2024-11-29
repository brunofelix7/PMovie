package dev.brunofelix.pmovie.feature.movie.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.brunofelix.pmovie.core.presentation.components.EmptyData
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
                uiState?.let {
                    when (it) {
                        is MovieDetailsState.Loading -> {

                        }
                        is MovieDetailsState.Success -> {
                            Text(text = "${it.movie?.details?.overview}")
                        }
                        is MovieDetailsState.Error -> {
                            EmptyData(
                                message = it.message,
                                modifier = Modifier.padding(top = 64.dp)
                            )
                        }
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun MovieDetailsScreenPreview() {
    
}