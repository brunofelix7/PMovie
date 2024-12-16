package dev.brunofelix.pmovie.feature.movie.domain.use_case

import dev.brunofelix.pmovie.core.util.exception.RemoteException
import dev.brunofelix.pmovie.feature.movie.domain.model.Movie
import dev.brunofelix.pmovie.feature.movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetFavoriteMoviesUseCase {
    suspend operator fun invoke(): Flow<List<Movie>?>
}

class GetFavoriteMoviesUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : GetFavoriteMoviesUseCase {

    override suspend operator fun invoke(): Flow<List<Movie>?> {
        return try {
            repository.fetchFavorites()
        } catch (e: Exception) {
            throw RemoteException("Failed to fetch your favorite movies.")
        }
    }
}