package dev.brunofelix.pmovie.feature.movie.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dev.brunofelix.pmovie.feature.movie.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopular(pagingConfig: PagingConfig): Flow<PagingData<Movie>>

    fun getUpcoming(pagingConfig: PagingConfig): Flow<PagingData<Movie>>

    suspend fun getDetails(id: Int): Movie?
}