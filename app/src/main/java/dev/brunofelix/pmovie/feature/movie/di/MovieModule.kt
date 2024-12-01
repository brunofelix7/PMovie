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
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetFavoriteMoviesUseCase
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetMovieDetailsUseCase
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetPopularMoviesUseCase
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetUpcomingMoviesUseCase
import dev.brunofelix.pmovie.feature.movie.domain.use_case.IsFavoriteMovieUseCase
import dev.brunofelix.pmovie.feature.movie.domain.use_case.MarkAsFavoriteUseCase
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
    fun provideGetPopularMoviesUseCase(repository: MovieRepository): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetUpcomingMoviesUseCase(repository: MovieRepository): GetUpcomingMoviesUseCase {
        return GetUpcomingMoviesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetMovieDetailsUseCase(repository: MovieRepository): GetMovieDetailsUseCase {
        return GetMovieDetailsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideMarkAsFavoriteUseCase(repository: MovieRepository): MarkAsFavoriteUseCase {
        return MarkAsFavoriteUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideDeleteFromFavoritesUseCase(repository: MovieRepository): DeleteFromFavoritesUseCase {
        return DeleteFromFavoritesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideIsFavoriteMovieUseCase(repository: MovieRepository): IsFavoriteMovieUseCase {
        return IsFavoriteMovieUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetFavoriteMoviesUseCase(repository: MovieRepository): GetFavoriteMoviesUseCase {
        return GetFavoriteMoviesUseCase(repository)
    }
}