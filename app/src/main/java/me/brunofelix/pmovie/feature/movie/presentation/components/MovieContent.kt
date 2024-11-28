package me.brunofelix.pmovie.feature.movie.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import me.brunofelix.pmovie.R
import me.brunofelix.pmovie.feature.movie.domain.model.Movie
import me.brunofelix.pmovie.core.presentation.components.ErrorView
import me.brunofelix.pmovie.core.presentation.components.LoadingView
import me.brunofelix.pmovie.core.presentation.ui.Colors

@Composable
fun MovieContent(
    modifier: Modifier = Modifier,
    paging: LazyPagingItems<Movie>?,
    paddingValues: PaddingValues,
    onClick: (id: Int) -> Unit
) {
    Box(
        modifier = modifier.background(Colors.blackPrimary)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = paddingValues,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            if (paging != null) {
                items(paging.itemCount) { index ->
                    val movie = paging[index]
                    movie?.let {
                        MovieItem(
                            movie = movie,
                            onItemClick = { id ->
                                onClick(id)
                            }
                        )
                    }
                }
                paging.apply {
                    when {
                        loadState.refresh is LoadState.Loading -> {
                            item(span = { GridItemSpan(maxLineSpan) }) {
                                LoadingView()
                            }
                        }
                        loadState.append is LoadState.Loading -> {
                            item(span = { GridItemSpan(maxLineSpan) }) {
                                LoadingView()
                            }
                        }
                        loadState.refresh is LoadState.Error -> {
                            item(span = { GridItemSpan(maxLineSpan) }) {
                                ErrorView(
                                    message = stringResource(R.string.connection_error),
                                    onRetry = { retry() }
                                )
                            }
                        }
                        loadState.append is LoadState.Error -> {
                            item(span = { GridItemSpan(maxLineSpan) }) {
                                ErrorView(
                                    message = stringResource(R.string.error),
                                    onRetry = { retry() }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MovieContentPreview() {
    MovieContent(
        paging = null,
        paddingValues = PaddingValues(),
        onClick = {}
    )
}