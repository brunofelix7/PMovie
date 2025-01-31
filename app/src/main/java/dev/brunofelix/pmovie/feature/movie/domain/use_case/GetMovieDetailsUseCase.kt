package dev.brunofelix.pmovie.feature.movie.domain.use_case

import dev.brunofelix.pmovie.core.util.exception.RemoteException
import dev.brunofelix.pmovie.feature.movie.domain.model.Movie
import dev.brunofelix.pmovie.feature.movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetMovieDetailsUseCase {
    suspend operator fun invoke(id: Long): Flow<Movie?>
}

class GetMovieDetailsUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : GetMovieDetailsUseCase {

    override suspend operator fun invoke(id: Long): Flow<Movie?> = flow {
        try {
            emit(repository.getDetails(id))
        } catch (e: Exception) {
            throw RemoteException("We couldn't load the details for this movie.")
        }
    }
}