package me.brunofelix.pmovie.feature.movie.domain.source

import me.brunofelix.pmovie.core.data.remote.dto.MovieDto
import me.brunofelix.pmovie.feature.movie.paging.MoviePopularPagingSource
import me.brunofelix.pmovie.feature.movie.paging.MovieUpcomingPagingSource
import retrofit2.Response

interface MovieRemoteDataSource {
    fun getPopularPagingSource(): MoviePopularPagingSource

    fun getUpcomingPagingSource(): MovieUpcomingPagingSource

    suspend fun getPopular(page: Int): Response<MovieDto>

    suspend fun getUpcoming(page: Int): Response<MovieDto>
}