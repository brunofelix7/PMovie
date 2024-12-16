package dev.brunofelix.pmovie.feature.movie.domain.use_case

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dev.brunofelix.pmovie.feature.movie.domain.model.Movie
import dev.brunofelix.pmovie.feature.movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetPopularMoviesUseCase {
    operator fun invoke(): Flow<PagingData<Movie>>
}

class GetPopularMoviesUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : GetPopularMoviesUseCase {

    override operator fun invoke(): Flow<PagingData<Movie>> {
        return repository.fetchPopulars(
            pagingConfig = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20
            )
        )
    }
}