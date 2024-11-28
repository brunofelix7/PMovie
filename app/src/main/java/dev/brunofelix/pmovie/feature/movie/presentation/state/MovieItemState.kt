package dev.brunofelix.pmovie.feature.movie.presentation.state

sealed class MovieItemState {
    data object Loading : MovieItemState()
    data object Success : MovieItemState()
    data object Error : MovieItemState()
}