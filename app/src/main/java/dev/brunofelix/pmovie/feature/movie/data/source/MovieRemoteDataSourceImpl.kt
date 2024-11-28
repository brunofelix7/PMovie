package dev.brunofelix.pmovie.feature.movie.data.source

import dev.brunofelix.pmovie.core.data.remote.MovieApi
import dev.brunofelix.pmovie.feature.movie.data.paging.MoviePopularPagingSource
import dev.brunofelix.pmovie.feature.movie.data.paging.MovieUpcomingPagingSource
import dev.brunofelix.pmovie.feature.movie.domain.source.MovieRemoteDataSource
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val api: MovieApi
) : MovieRemoteDataSource {
    override fun getPopularPagingSource() = MoviePopularPagingSource(this)

    override fun getUpcomingPagingSource() = MovieUpcomingPagingSource(this)

    override suspend fun getPopular(page: Int) = api.getPopulars(page)

    override suspend fun getUpcoming(page: Int) = api.getUpcoming(page)
}