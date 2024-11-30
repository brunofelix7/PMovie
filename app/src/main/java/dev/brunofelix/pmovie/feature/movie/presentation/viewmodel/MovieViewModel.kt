package dev.brunofelix.pmovie.feature.movie.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.brunofelix.pmovie.feature.movie.domain.use_case.MovieUseCase
import dev.brunofelix.pmovie.feature.movie.presentation.state.MovieDetailsState
import dev.brunofelix.pmovie.feature.movie.presentation.state.MovieState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val useCase: MovieUseCase
): ViewModel() {

    private val _movieDetails = MutableLiveData<MovieDetailsState>()
    val movieDetails: LiveData<MovieDetailsState> get() = _movieDetails

    var popularMovies by mutableStateOf(MovieState())
        private set

    var upcomingMovies by mutableStateOf(MovieState())
        private set

    init {
        popularMovies = popularMovies.copy(
            popularMovies = useCase.getPopularMovies.invoke().cachedIn(viewModelScope)
        )
        upcomingMovies = upcomingMovies.copy(
            upcomingMovies = useCase.getUpcomingMovies.invoke().cachedIn(viewModelScope)
        )
    }

    fun getDetails(movieId: Long) = viewModelScope.launch {
        useCase.getMovieDetails.invoke(movieId)
            .onStart {
                _movieDetails.value = MovieDetailsState.Loading
            }
            .catch { error ->
                _movieDetails.value = MovieDetailsState.Error(error.message)
            }
            .collect { movie ->
                _movieDetails.value = MovieDetailsState.Success(movie)
            }
    }
}