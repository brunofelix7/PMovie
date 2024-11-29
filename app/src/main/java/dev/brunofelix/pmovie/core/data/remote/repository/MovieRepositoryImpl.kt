package dev.brunofelix.pmovie.core.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dev.brunofelix.pmovie.feature.movie.domain.model.Movie
import dev.brunofelix.pmovie.feature.movie.domain.repository.MovieRepository
import dev.brunofelix.pmovie.feature.movie.domain.source.MovieRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val dataSource: MovieRemoteDataSource
) : MovieRepository {

    override fun getPopular(pagingConfig: PagingConfig): Flow<PagingData<Movie>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                dataSource.getPopularPagingSource()
            }
        ).flow
    }

    override fun getUpcoming(pagingConfig: PagingConfig): Flow<PagingData<Movie>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                dataSource.getUpcomingPagingSource()
            }
        ).flow
    }

    override suspend fun getDetails(id: Int) = dataSource.getDetails(id).body()?.toMovie()
}