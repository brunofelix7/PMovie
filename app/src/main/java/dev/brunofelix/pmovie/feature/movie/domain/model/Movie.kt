package dev.brunofelix.pmovie.feature.movie.domain.model

import dev.brunofelix.pmovie.core.data.local.entity.MovieEntity

data class Movie(
    val id: Long = -1L,
    val title: String = "",
    val imageUrl: String = "",
    val voteAverage: Float = -1F,
    val details: MovieDetails? = null
) {
    fun toMovieEntity(): MovieEntity {
        return MovieEntity(
            id = id,
            title = title,
            imageUrl = imageUrl
        )
    }
}