package dev.brunofelix.pmovie.feature.movie.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.brunofelix.pmovie.core.data.repository.MovieRepositoryImpl
import dev.brunofelix.pmovie.feature.movie.domain.data_source.MovieLocalDataSource
import dev.brunofelix.pmovie.feature.movie.domain.data_source.MovieRemoteDataSource
import dev.brunofelix.pmovie.feature.movie.domain.repository.MovieRepository
import dev.brunofelix.pmovie.feature.movie.domain.use_case.DeleteFromFavoritesUseCase
import dev.brunofelix.pmovie.feature.movie.domain.use_case.DeleteFromFavoritesUseCaseImpl
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetFavoriteMoviesUseCase
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetFavoriteMoviesUseCaseImpl
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetMovieDetailsUseCase
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetMovieDetailsUseCaseImpl
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetPopularMoviesUseCase
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetPopularMoviesUseCaseImpl
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetUpcomingMoviesUseCase
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetUpcomingMoviesUseCaseImpl
import dev.brunofelix.pmovie.feature.movie.domain.use_case.IsFavoriteMovieUseCase
import dev.brunofelix.pmovie.feature.movie.domain.use_case.IsFavoriteMovieUseCaseImpl
import dev.brunofelix.pmovie.feature.movie.domain.use_case.MarkAsFavoriteUseCase
import dev.brunofelix.pmovie.feature.movie.domain.use_case.MarkAsFavoriteUseCaseImpl
import dev.brunofelix.pmovie.feature.movie.domain.use_case.MovieUseCase
import dev.brunofelix.pmovie.feature.movie.domain.use_case.MovieUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        remoteDataSource: MovieRemoteDataSource,
        localDataSource: MovieLocalDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(remoteDataSource, localDataSource)
    }

    @Provides
    @Singleton
    fun provideGetPopularMoviesUseCase(
        repository: MovieRepository
    ): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetUpcomingMoviesUseCase(
        repository: MovieRepository
    ): GetUpcomingMoviesUseCase {
        return GetUpcomingMoviesUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetMovieDetailsUseCase(
        repository: MovieRepository
    ): GetMovieDetailsUseCase {
        return GetMovieDetailsUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideMarkAsFavoriteUseCase(
        repository: MovieRepository
    ): MarkAsFavoriteUseCase {
        return MarkAsFavoriteUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideDeleteFromFavoritesUseCase(
        repository: MovieRepository
    ): DeleteFromFavoritesUseCase {
        return DeleteFromFavoritesUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideIsFavoriteMovieUseCase(
        repository: MovieRepository
    ): IsFavoriteMovieUseCase {
        return IsFavoriteMovieUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetFavoriteMoviesUseCase(
        repository: MovieRepository
    ): GetFavoriteMoviesUseCase {
        return GetFavoriteMoviesUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideMovieUseCase(
        getPopularMovies: GetPopularMoviesUseCaseImpl,
        getUpcomingMovies: GetUpcomingMoviesUseCaseImpl,
        getMovieDetails: GetMovieDetailsUseCaseImpl,
        getFavoriteMovies: GetFavoriteMoviesUseCaseImpl,
        markAsFavorite: MarkAsFavoriteUseCaseImpl,
        deleteFromFavorites: DeleteFromFavoritesUseCaseImpl,
        isFavoriteMovie: IsFavoriteMovieUseCaseImpl,
    ): MovieUseCase {
        return MovieUseCaseImpl(
            getPopularMovies,
            getUpcomingMovies,
            getMovieDetails,
            getFavoriteMovies,
            markAsFavorite,
            deleteFromFavorites,
            isFavoriteMovie
        )
    }
}