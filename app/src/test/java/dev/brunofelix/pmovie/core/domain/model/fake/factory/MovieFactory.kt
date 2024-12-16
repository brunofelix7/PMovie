package dev.brunofelix.pmovie.core.domain.model.fake.factory

import dev.brunofelix.pmovie.core.domain.model.fake.FakeMovie
import dev.brunofelix.pmovie.feature.movie.domain.model.Movie

class MovieFactory {

    fun create(movie: FakeMovie) = when (movie) {
        FakeMovie.JohnWick -> Movie(
            id = 1,
            title = "John Wick",
            voteAverage = 7.1F,
            imageUrl = "https://image.tmdb.org/t/p/w1280/{posterPath}",
            details = null
        )
        FakeMovie.Avengers -> Movie(
            id = 2,
            title = "Avengers",
            voteAverage = 7.9F,
            imageUrl = "https://image.tmdb.org/t/p/w1280/{posterPath}",
            details = null
        )
        FakeMovie.AlienRomulus -> Movie(
            id = 3,
            title = "Alien Romulus",
            voteAverage = 8.2F,
            imageUrl = "https://image.tmdb.org/t/p/w1280/{posterPath}",
            details = null
        )
    }
}