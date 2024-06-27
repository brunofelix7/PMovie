package me.brunofelix.pmovie.feature.movie.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.brunofelix.pmovie.core.data.remote.MovieApi
import me.brunofelix.pmovie.feature.movie.data.repository.MovieRepositoryImpl
import me.brunofelix.pmovie.feature.movie.data.source.MovieRemoteDataSourceImpl
import me.brunofelix.pmovie.feature.movie.domain.repository.MovieRepository
import me.brunofelix.pmovie.feature.movie.domain.source.MovieRemoteDataSource
import me.brunofelix.pmovie.feature.movie.domain.usecase.GetPopularMoviesUseCase
import me.brunofelix.pmovie.feature.movie.domain.usecase.GetPopularMoviesUseCaseImpl
import me.brunofelix.pmovie.feature.movie.domain.usecase.GetUpcomingMoviesUseCase
import me.brunofelix.pmovie.feature.movie.domain.usecase.GetUpcomingMoviesUseCaseImpl
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