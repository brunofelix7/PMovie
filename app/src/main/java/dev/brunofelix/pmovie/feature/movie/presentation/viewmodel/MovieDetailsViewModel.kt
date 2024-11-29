package dev.brunofelix.pmovie.feature.movie.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetMovieDetailsUseCase
import dev.brunofelix.pmovie.feature.movie.presentation.state.MovieDetailsState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val useCase: GetMovieDetailsUseCase
): ViewModel() {

    private val _movie = MutableLiveData<MovieDetailsState>()
    val movie: LiveData<MovieDetailsState> get() = _movie

    fun getDetails(movieId: Int) = viewModelScope.launch {
        useCase.invoke(movieId)
            .onStart {
                _movie.value = MovieDetailsState.Loading
            }
            .catch { error ->
                _movie.value = MovieDetailsState.Error(error.message)
            }
            .collect { movie ->
                _movie.value = MovieDetailsState.Success(movie)
            }
    }
}