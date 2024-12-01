package dev.brunofelix.pmovie.feature.movie.domain.use_case

import dev.brunofelix.pmovie.core.util.exception.RemoteException
import dev.brunofelix.pmovie.feature.movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFavoriteMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke() = flow {
        try {
            emit(repository.fetchFavorites())
        } catch (e: Exception) {
            throw RemoteException("Failed to fetch your favorite movies.")
        }
    }
}