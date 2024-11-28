package dev.brunofelix.pmovie.feature.movie.domain.model

data class MovieDetails(
    val genres: List<Genre>?,
    val overview: String,
    val backdropPath: String,
    val releaseDate: String,
    val duration: Int,
    val voteCount: Int,
)