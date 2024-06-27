package me.brunofelix.pmovie.feature.movie.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.brunofelix.pmovie.core.domain.model.Movie

interface MovieRepository {
    fun getPopular(pagingConfig: PagingConfig): Flow<PagingData<Movie>>

    fun getUpcoming(pagingConfig: PagingConfig): Flow<PagingData<Movie>>
}