package dev.brunofelix.pmovie.feature.movie.domain.source

import dev.brunofelix.pmovie.core.data.remote.dto.MovieDto
import dev.brunofelix.pmovie.core.data.remote.dto.ResultDto
import dev.brunofelix.pmovie.core.data.remote.paging.MoviePopularPagingSource
import dev.brunofelix.pmovie.core.data.remote.paging.MovieUpcomingPagingSource
import retrofit2.Response

interface MovieRemoteDataSource {
    fun getPopularPagingSource(): MoviePopularPagingSource

    fun getUpcomingPagingSource(): MovieUpcomingPagingSource

    suspend fun getPopular(page: Int): Response<MovieDto>

    suspend fun getUpcoming(page: Int): Response<MovieDto>

    suspend fun getDetails(id: Int): Response<ResultDto>
}