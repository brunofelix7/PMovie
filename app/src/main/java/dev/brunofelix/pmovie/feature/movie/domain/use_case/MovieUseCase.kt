package dev.brunofelix.pmovie.feature.movie.domain.use_case

import javax.inject.Inject

class MovieUseCase @Inject constructor(
    val getPopularMovies: GetPopularMoviesUseCase,
    val getUpcomingMovies: GetUpcomingMoviesUseCase,
    val getMovieDetails: GetMovieDetailsUseCase
)