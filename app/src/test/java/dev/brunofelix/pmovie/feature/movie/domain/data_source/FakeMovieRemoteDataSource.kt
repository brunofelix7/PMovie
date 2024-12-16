package dev.brunofelix.pmovie.feature.movie.domain.data_source

import dev.brunofelix.core.domain.model.factory.MovieDtoFactory
import dev.brunofelix.core.domain.model.fake.FakeMovie
import dev.brunofelix.pmovie.core.data.remote.dto.MovieDto
import dev.brunofelix.pmovie.core.data.remote.dto.ResultDto
import dev.brunofelix.pmovie.core.data.remote.paging.MoviePopularPagingSource
import dev.brunofelix.pmovie.core.data.remote.paging.MovieUpcomingPagingSource
import dev.brunofelix.pmovie.core.util.exception.RemoteException
import retrofit2.Response

class FakeMovieRemoteDataSource : MovieRemoteDataSource {

    private var shouldReturnError = false

    fun setShouldReturnError(value: Boolean) {
        shouldReturnError = value
    }

    override fun getPopularPagingSource(): MoviePopularPagingSource {
        TODO("Not yet implemented")
    }

    override fun getUpcomingPagingSource(): MovieUpcomingPagingSource {
        TODO("Not yet implemented")
    }

    override suspend fun getPopular(page: Int): Response<MovieDto> {
        TODO("Not yet implemented")
    }

    override suspend fun getUpcoming(page: Int): Response<MovieDto> {
        TODO("Not yet implemented")
    }

    override suspend fun getDetails(id: Long): Response<ResultDto> {
        if (shouldReturnError) {
            throw RemoteException()
        }
        return Response.success(200, MovieDtoFactory().create(FakeMovie.JohnWick))
    }
}