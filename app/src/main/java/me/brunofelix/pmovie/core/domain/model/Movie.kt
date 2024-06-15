package me.brunofelix.pmovie.core.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val voteAverage: Double,
    val movieDetails: MovieDetails? = null
)