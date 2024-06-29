package me.brunofelix.pmovie.feature.movie.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import me.brunofelix.pmovie.feature.movie.domain.usecase.GetPopularMoviesUseCase
import me.brunofelix.pmovie.feature.movie.presentation.state.MovieState
import javax.inject.Inject

@HiltViewModel
class MoviePopularViewModel @Inject constructor(
    useCase: GetPopularMoviesUseCase
): ViewModel() {

    private var uiState by mutableStateOf(MovieState())

    init {
        val movies = useCase.invoke().cachedIn(viewModelScope)
        uiState = uiState.copy(movies = movies)
    }
}