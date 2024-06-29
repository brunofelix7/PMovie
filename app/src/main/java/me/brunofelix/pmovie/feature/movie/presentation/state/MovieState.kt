package me.brunofelix.pmovie.feature.movie.presentation.state

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import me.brunofelix.pmovie.core.domain.model.Movie

data class MovieState(
    val popularMovies: Flow<PagingData<Movie>> = emptyFlow(),
    val upcomingMovies: Flow<PagingData<Movie>> = emptyFlow(),
)