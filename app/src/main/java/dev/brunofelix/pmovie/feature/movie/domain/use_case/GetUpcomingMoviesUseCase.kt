package dev.brunofelix.pmovie.feature.movie.domain.use_case

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dev.brunofelix.pmovie.feature.movie.domain.model.Movie
import dev.brunofelix.pmovie.feature.movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetUpcomingMoviesUseCase {
    operator fun invoke(): Flow<PagingData<Movie>>
}

class GetUpcomingMoviesUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : GetUpcomingMoviesUseCase {

    override operator fun invoke(): Flow<PagingData<Movie>> {
        return repository.fetchUpcoming(
            pagingConfig = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20
            )
        )
    }
}