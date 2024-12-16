package dev.brunofelix.pmovie.feature.movie.domain.use_case

import dev.brunofelix.pmovie.core.util.exception.LocalException
import dev.brunofelix.pmovie.feature.movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface IsFavoriteMovieUseCase {
    suspend operator fun invoke(id: Long): Flow<Boolean>
}

class IsFavoriteMovieUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : IsFavoriteMovieUseCase {

    override suspend operator fun invoke(id: Long): Flow<Boolean> = flow {
        try {
            emit(repository.isFavorite(id))
        } catch (e: Exception) {
            throw LocalException("Failed to verify favorite movie.")
        }
    }
}