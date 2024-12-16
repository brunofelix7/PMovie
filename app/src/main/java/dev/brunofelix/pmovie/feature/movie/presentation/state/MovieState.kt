package dev.brunofelix.pmovie.feature.movie.presentation.state

import androidx.paging.PagingData
import dev.brunofelix.pmovie.feature.movie.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MovieState(
    val populars: Flow<PagingData<Movie>> = emptyFlow(),
    val upcoming: Flow<PagingData<Movie>> = emptyFlow(),
)