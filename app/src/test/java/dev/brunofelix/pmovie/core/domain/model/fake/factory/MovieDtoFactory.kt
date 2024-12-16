package dev.brunofelix.pmovie.core.domain.model.fake.factory

import dev.brunofelix.pmovie.core.domain.model.fake.FakeMovie
import dev.brunofelix.pmovie.core.data.remote.dto.ResultDto

class MovieDtoFactory {

    fun create(movie: FakeMovie) = when (movie) {
        FakeMovie.JohnWick -> ResultDto(
            id = 1,
            title = "John Wick",
            voteAverage = 7.1F,
            posterPath = "/{posterPath}"
        )
        FakeMovie.Avengers -> ResultDto(
            id = 2,
            title = "Avengers",
            voteAverage = 7.9F,
            posterPath = "/{posterPath}"
        )
        FakeMovie.AlienRomulus -> ResultDto(
            id = 3,
            title = "Alien Romulus",
            voteAverage = 8.2F,
            posterPath = "/{posterPath}"
        )
    }
}