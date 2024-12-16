package dev.brunofelix.core.domain.model.factory

import dev.brunofelix.pmovie.feature.movie.domain.model.Movie

class MovieFactory {

    fun create(poster: Poster) = when (poster) {
        Poster.JohnWick -> Movie(
            id = 1,
            title = "John Wick",
            voteAverage = 7.1F,
            imageUrl = "{url}"
        )
        Poster.Avengers -> Movie(
            id = 2,
            title = "Avengers",
            voteAverage = 7.9F,
            imageUrl = "{url}"
        )
        Poster.AlienRomulus -> Movie(
            id = 3,
            title = "Alien Romulus",
            voteAverage = 8.2F,
            imageUrl = "{url}"
        )
    }

    sealed class Poster {
        data object JohnWick : Poster()
        data object Avengers : Poster()
        data object AlienRomulus : Poster()
    }
}