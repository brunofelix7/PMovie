package dev.brunofelix.pmovie.feature.movie.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dev.brunofelix.pmovie.feature.movie.domain.data_source.FakeMovieLocalDataSource
import dev.brunofelix.pmovie.feature.movie.domain.data_source.FakeMovieRemoteDataSource
import dev.brunofelix.pmovie.feature.movie.domain.model.Movie
import kotlinx.coroutines.flow.Flow

class FakeMovieRepository (
    private val remoteDataSource: FakeMovieRemoteDataSource,
    private val localDataSource: FakeMovieLocalDataSource
): MovieRepository {

    override fun fetchPopulars(pagingConfig: PagingConfig): Flow<PagingData<Movie>> {
        TODO("Not yet implemented")
    }

    override fun fetchUpcoming(pagingConfig: PagingConfig): Flow<PagingData<Movie>> {
        TODO("Not yet implemented")
    }

    override suspend fun getDetails(id: Long) = remoteDataSource.getDetails(id).body()?.toMovie()

    override suspend fun markAsFavorite(movie: Movie) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFromFavorites(movie: Movie) {
        TODO("Not yet implemented")
    }

    override suspend fun isFavorite(id: Long): Boolean {
        TODO("Not yet implemented")
    }

    override fun fetchFavorites(): Flow<List<Movie>?> {
        TODO("Not yet implemented")
    }
}