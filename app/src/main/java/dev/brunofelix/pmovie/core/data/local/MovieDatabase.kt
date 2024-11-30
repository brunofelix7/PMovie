package dev.brunofelix.pmovie.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.brunofelix.pmovie.core.data.local.dao.MovieDao
import dev.brunofelix.pmovie.core.data.local.entity.MovieEntity

@Database(
    entities = [MovieEntity::class],
    exportSchema = false,
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {
    abstract val movieDao: MovieDao
}