package dev.brunofelix.pmovie.feature.movie.presentation.state

import dev.brunofelix.pmovie.feature.movie.domain.model.Movie

sealed class MovieDetailsState {
    data object Loading : MovieDetailsState()
    data class Success(val movie: Movie? = null) : MovieDetailsState()
    data class Error(val message: String? = "") : MovieDetailsState()
}