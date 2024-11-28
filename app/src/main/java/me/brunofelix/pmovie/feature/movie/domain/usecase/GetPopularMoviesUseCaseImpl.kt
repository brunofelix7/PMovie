package me.brunofelix.pmovie.feature.movie.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.brunofelix.pmovie.feature.movie.domain.model.Movie
import me.brunofelix.pmovie.feature.movie.domain.repository.MovieRepository
import javax.inject.Inject

class GetPopularMoviesUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : GetPopularMoviesUseCase {

    override fun invoke(): Flow<PagingData<Movie>> {
        return repository.getPopular(
            pagingConfig = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20
            )
        )
    }
}