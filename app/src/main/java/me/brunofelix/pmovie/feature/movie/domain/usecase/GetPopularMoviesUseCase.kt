package me.brunofelix.pmovie.feature.movie.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.brunofelix.pmovie.feature.movie.domain.model.Movie

interface GetPopularMoviesUseCase {
    operator fun invoke(): Flow<PagingData<Movie>>
}