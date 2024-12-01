package dev.brunofelix.pmovie.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dev.brunofelix.pmovie.feature.movie.domain.data_source.MovieLocalDataSource
import dev.brunofelix.pmovie.feature.movie.domain.data_source.MovieRemoteDataSource
import dev.brunofelix.pmovie.feature.movie.domain.model.Movie
import dev.brunofelix.pmovie.feature.movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource,
    private val localDataSource: MovieLocalDataSource
) : MovieRepository {

    override fun fetchPopulars(pagingConfig: PagingConfig): Flow<PagingData<Movie>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                remoteDataSource.getPopularPagingSource()
            }
        ).flow
    }

    override fun fetchUpcoming(pagingConfig: PagingConfig): Flow<PagingData<Movie>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                remoteDataSource.getUpcomingPagingSource()
            }
        ).flow
    }

    override suspend fun getDetails(id: Long) = remoteDataSource.getDetails(id).body()?.toMovie()

    override suspend fun markAsFavorite(movie: Movie) {
        localDataSource.insert(movie.toMovieEntity())
    }

    override suspend fun deleteFromFavorites(movie: Movie) {
        localDataSource.delete(movie.toMovieEntity())
    }

    override suspend fun isFavorite(id: Long): Boolean {
        return localDataSource.getById(id)?.toMovie() != null
    }

    override fun fetchFavorites(): Flow<List<Movie>?> {
        return localDataSource.getAll().map { entityList ->
            entityList?.map { it.toMovie() }
        }
    }
}