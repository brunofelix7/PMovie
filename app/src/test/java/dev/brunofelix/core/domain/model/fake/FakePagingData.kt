package dev.brunofelix.core.domain.model.fake

import androidx.paging.PagingData
import dev.brunofelix.core.domain.model.factory.MovieFactory
import dev.brunofelix.pmovie.feature.movie.domain.model.Movie

object FakePagingData {

    val fakeMovies: PagingData<Movie> = PagingData.from(
        listOf(
            MovieFactory().create(MovieFactory.Poster.JohnWick),
            MovieFactory().create(MovieFactory.Poster.Avengers),
            MovieFactory().create(MovieFactory.Poster.AlienRomulus)
        )
    )
}