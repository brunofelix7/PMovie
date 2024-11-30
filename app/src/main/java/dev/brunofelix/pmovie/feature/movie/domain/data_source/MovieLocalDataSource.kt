package dev.brunofelix.pmovie.feature.movie.domain.data_source

import dev.brunofelix.pmovie.core.data.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {
    suspend fun insert(entity: MovieEntity): Long

    suspend fun delete(entity: MovieEntity): Int

    suspend fun getById(id: Long): MovieEntity?

    fun getAll(): Flow<List<MovieEntity>?>
}