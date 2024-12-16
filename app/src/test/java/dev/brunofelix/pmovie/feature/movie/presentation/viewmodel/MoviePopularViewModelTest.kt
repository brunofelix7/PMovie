package dev.brunofelix.pmovie.feature.movie.presentation.viewmodel

import com.google.common.truth.Truth.assertThat
import dev.brunofelix.MainDispatcherRule
import dev.brunofelix.pmovie.core.domain.model.fake.FakePagingData
import dev.brunofelix.pmovie.core.util.exception.RemoteException
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetPopularMoviesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MoviePopularViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Mock
    lateinit var useCase: GetPopularMoviesUseCase

    private val viewModel by lazy {
        MoviePopularViewModel(useCase)
    }

    @Test
    fun `when GetPopularMoviesUseCase get success, then return a PagingData of movies`() = runTest {
        // Given
        `when`(useCase.invoke()).thenReturn(
            flowOf(FakePagingData.fakeMovies)
        )

        // When
        val result = viewModel.uiState.movies.first()

        // Then
        assertThat(result).isNotNull()
    }

    @Test(expected = RemoteException::class)
    fun `when GetPopularMoviesUseCase get error, then throw a RemoteException`() = runTest {
        // Given
        `when`(useCase.invoke()).thenThrow(RemoteException())

        // When
        val result = viewModel.uiState.movies.first()

        // Then
        assertThat(result).isNull()
    }
}