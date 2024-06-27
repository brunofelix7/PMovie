package me.brunofelix.pmovie.feature.movie.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.brunofelix.pmovie.core.domain.model.Movie
import me.brunofelix.pmovie.feature.movie.domain.repository.MovieRepository
import me.brunofelix.pmovie.feature.movie.domain.source.MovieRemoteDataSource
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
}