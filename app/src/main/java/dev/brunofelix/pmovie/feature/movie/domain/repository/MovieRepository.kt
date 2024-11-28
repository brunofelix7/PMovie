package dev.brunofelix.pmovie.feature.movie.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import dev.brunofelix.pmovie.feature.movie.domain.model.Movie

interface MovieRepository {
    fun getPopular(pagingConfig: PagingConfig): Flow<PagingData<Movie>>

    fun getUpcoming(pagingConfig: PagingConfig): Flow<PagingData<Movie>>
}