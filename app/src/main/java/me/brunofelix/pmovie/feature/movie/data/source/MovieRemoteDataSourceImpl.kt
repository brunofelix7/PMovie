package me.brunofelix.pmovie.feature.movie.data.source

import me.brunofelix.pmovie.core.data.remote.MovieApi
import me.brunofelix.pmovie.feature.movie.data.paging.MoviePopularPagingSource
import me.brunofelix.pmovie.feature.movie.data.paging.MovieUpcomingPagingSource
import me.brunofelix.pmovie.feature.movie.domain.source.MovieRemoteDataSource
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val api: MovieApi
) : MovieRemoteDataSource {
    override fun getPopularPagingSource() = MoviePopularPagingSource(this)

    override fun getUpcomingPagingSource() = MovieUpcomingPagingSource(this)

    override suspend fun getPopular(page: Int) = api.getPopulars(page)

    override suspend fun getUpcoming(page: Int) = api.getUpcoming(page)
}