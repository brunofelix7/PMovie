package dev.brunofelix.pmovie.feature.movie.domain.use_case

import dev.brunofelix.pmovie.core.util.exception.LocalException
import dev.brunofelix.pmovie.feature.movie.domain.model.Movie
import dev.brunofelix.pmovie.feature.movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface MarkAsFavoriteUseCase {
    suspend operator fun invoke(movie: Movie): Flow<Unit>
}

class MarkAsFavoriteUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : MarkAsFavoriteUseCase {

    override suspend operator fun invoke(movie: Movie): Flow<Unit> = flow {
        try {
            emit(repository.markAsFavorite(movie))
        } catch (e: Exception) {
            throw LocalException("Failed to mark this movie as favorite.")
        }
    }
}