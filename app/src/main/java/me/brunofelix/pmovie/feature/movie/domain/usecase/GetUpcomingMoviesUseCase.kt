package me.brunofelix.pmovie.feature.movie.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.brunofelix.pmovie.core.domain.model.Movie

interface GetUpcomingMoviesUseCase {
    operator fun invoke(): Flow<PagingData<Movie>>
}