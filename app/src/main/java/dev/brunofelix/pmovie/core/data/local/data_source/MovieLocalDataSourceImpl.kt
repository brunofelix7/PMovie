package dev.brunofelix.pmovie.core.data.local.data_source

import dev.brunofelix.pmovie.core.data.local.MovieDatabase
import dev.brunofelix.pmovie.core.data.local.entity.MovieEntity
import dev.brunofelix.pmovie.feature.movie.domain.data_source.MovieLocalDataSource
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(
    private val db: MovieDatabase
): MovieLocalDataSource {
    override suspend fun insert(entity: MovieEntity) = db.movieDao.insert(entity)

    override suspend fun delete(entity: MovieEntity) = db.movieDao.delete(entity)

    override suspend fun getById(id: Long) = db.movieDao.getById(id)

    override fun getAll() = db.movieDao.getAll()
}