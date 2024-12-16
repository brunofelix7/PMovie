package dev.brunofelix.pmovie.feature.movie.domain.use_case

interface MovieUseCase {
    val getPopularMovies: GetPopularMoviesUseCase
    val getUpcomingMovies: GetUpcomingMoviesUseCase
    val getMovieDetails: GetMovieDetailsUseCase
    val getFavoriteMovies: GetFavoriteMoviesUseCase
    val markAsFavorite: MarkAsFavoriteUseCase
    val deleteFromFavorites: DeleteFromFavoritesUseCase
    val isFavoriteMovie: IsFavoriteMovieUseCase
}

class MovieUseCaseImpl (
    override val getPopularMovies: GetPopularMoviesUseCaseImpl,
    override val getUpcomingMovies: GetUpcomingMoviesUseCaseImpl,
    override val getMovieDetails: GetMovieDetailsUseCaseImpl,
    override val getFavoriteMovies: GetFavoriteMoviesUseCaseImpl,
    override val markAsFavorite: MarkAsFavoriteUseCaseImpl,
    override val deleteFromFavorites: DeleteFromFavoritesUseCaseImpl,
    override val isFavoriteMovie: IsFavoriteMovieUseCaseImpl
) : MovieUseCase