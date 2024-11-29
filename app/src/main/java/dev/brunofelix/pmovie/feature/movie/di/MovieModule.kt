package dev.brunofelix.pmovie.feature.movie.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.brunofelix.pmovie.core.data.remote.MovieApi
import dev.brunofelix.pmovie.core.data.remote.repository.MovieRepositoryImpl
import dev.brunofelix.pmovie.core.data.remote.source.MovieRemoteDataSourceImpl
import dev.brunofelix.pmovie.feature.movie.domain.repository.MovieRepository
import dev.brunofelix.pmovie.feature.movie.domain.source.MovieRemoteDataSource
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetMovieDetailsUseCase
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetPopularMoviesUseCase
import dev.brunofelix.pmovie.feature.movie.domain.use_case.GetUpcomingMoviesUseCase
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
}