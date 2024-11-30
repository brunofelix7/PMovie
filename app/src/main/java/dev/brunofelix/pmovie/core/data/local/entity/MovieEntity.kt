package dev.brunofelix.pmovie.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.brunofelix.pmovie.feature.movie.domain.model.Movie

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "imageUrl")
    val imageUrl: String
) {
    fun toMovie(): Movie {
        return Movie(
            id = id,
            title = title,
            imageUrl = imageUrl
        )
    }
}