package me.brunofelix.pmovie.feature.movie.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import me.brunofelix.pmovie.feature.movie.domain.usecase.GetUpcomingMoviesUseCase
import me.brunofelix.pmovie.feature.movie.presentation.state.MovieState
import javax.inject.Inject

@HiltViewModel
class MovieUpcomingViewModel @Inject constructor(
    useCase: GetUpcomingMoviesUseCase
): ViewModel() {

    var uiState by mutableStateOf(MovieState())
        private set

    init {
        val movies = useCase.invoke().cachedIn(viewModelScope)
        uiState = uiState.copy(upcomingMovies = movies)
    }
}