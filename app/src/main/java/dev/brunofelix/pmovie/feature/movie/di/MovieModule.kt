package dev.brunofelix.pmovie.feature.movie.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.brunofelix.pmovie.core.data.remote.MovieApi
import dev.brunofelix.pmovie.feature.movie.data.repository.MovieRepositoryImpl
import dev.brunofelix.pmovie.feature.movie.data.source.MovieRemoteDataSourceImpl
import dev.brunofelix.pmovie.feature.movie.domain.repository.MovieRepository
import dev.brunofelix.pmovie.feature.movie.domain.source.MovieRemoteDataSource
import dev.brunofelix.pmovie.feature.movie.domain.usecase.GetPopularMoviesUseCase
import dev.brunofelix.pmovie.feature.movie.domain.usecase.GetPopularMoviesUseCaseImpl
import dev.brunofelix.pmovie.feature.movie.domain.usecase.GetUpcomingMoviesUseCase
import dev.brunofelix.pmovie.feature.movie.domain.usecase.GetUpcomingMoviesUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(api: MovieApi): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(api)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(dataSource: MovieRemoteDataSource): MovieRepository {
        return MovieRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideGetPopularMoviesUseCase(repository: MovieRepository): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetUpcomingMoviesUseCase(repository: MovieRepository): GetUpcomingMoviesUseCase {
        return GetUpcomingMoviesUseCaseImpl(repository)
    }
}