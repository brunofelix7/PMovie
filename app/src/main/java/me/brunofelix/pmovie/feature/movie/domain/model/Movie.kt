package me.brunofelix.pmovie.feature.movie.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val voteAverage: Float,
    var movieDetails: MovieDetails? = null
)