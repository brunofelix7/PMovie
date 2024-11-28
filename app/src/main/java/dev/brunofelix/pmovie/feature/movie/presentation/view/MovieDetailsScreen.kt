package dev.brunofelix.pmovie.feature.movie.presentation.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.brunofelix.pmovie.feature.movie.presentation.components.MovieDetailsTopBar

@Composable
fun MovieDetailsScreen(
    movieId: Int,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            MovieDetailsTopBar(
                onBackClick = onBackClick
            )
        },
        content = { innerPadding ->
            Text(
                text = "ID= $movieId",
                modifier = Modifier.padding(innerPadding)
            )
        }
    )
}

@Preview
@Composable
private fun MovieDetailsScreenPreview() {
    
}