package dev.brunofelix.pmovie.feature.movie.presentation.components.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.brunofelix.pmovie.core.presentation.components.EmptyImage
import dev.brunofelix.pmovie.core.presentation.components.LoadingView
import dev.brunofelix.pmovie.feature.movie.presentation.state.MovieDetailsState

@Composable
fun MovieDetailsBackdropImage(
    modifier: Modifier = Modifier,
    uiState: MovieDetailsState?
) {
    val backdropPath = remember { mutableStateOf<String?>("") }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(backdropPath.value)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.Center)
        )
        uiState?.let {
            when (it) {
                is MovieDetailsState.Loading -> {
                    LoadingView()
                }
                is MovieDetailsState.Success -> {
                    backdropPath.value = it.movie?.details?.backdropPath
                    if (backdropPath.value?.isEmpty() == true) {
                        EmptyImage()
                    }
                }
                is MovieDetailsState.Error -> {
                    EmptyImage()
                }
            }
        }
    }
}